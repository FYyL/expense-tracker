package pt.rawr.expense_tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pt.rawr.expense_tracker.dto.CreateExpenseRequest;
import pt.rawr.expense_tracker.dto.CreateExpenseResponse;
import pt.rawr.expense_tracker.dto.ExpenseDto;
import pt.rawr.expense_tracker.dto.ExpenseSearchCriteria;
import pt.rawr.expense_tracker.dto.UpdateExpenseRequest;
import pt.rawr.expense_tracker.dto.UpdateExpenseResponse;
import pt.rawr.expense_tracker.service.ExpenseTrackerService;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expense-tracker")
public class ExpenseTrackerController {

    private final ExpenseTrackerService expenseTrackerService;

    @GetMapping("/expense/list")
    public List<ExpenseDto> getExpenses(@RequestBody ExpenseSearchCriteria searchCriteria) {
        return expenseTrackerService.findExpenses(searchCriteria);
    }

    @GetMapping("/expense/{expenseId}")
    public ExpenseDto getExpenseById(@PathVariable long expenseId) {
        return expenseTrackerService.getExpenseById(expenseId);
    }
    
    @PostMapping("/expense")
    public CreateExpenseResponse createExpense(@RequestBody CreateExpenseRequest request) {
        return expenseTrackerService.createExpense(request);
    }

    @DeleteMapping("/expense/{expenseId}")
    public void deleteExpense(@PathVariable long expenseId) {
        expenseTrackerService.deleteExpense(expenseId);
    }

    @PatchMapping("/expense/{expenseId}")
    public UpdateExpenseResponse updateExpense(@PathVariable long expenseId, 
                                @RequestBody UpdateExpenseRequest request) {
        return expenseTrackerService.updateExpense(expenseId, request);
    }
    
}
