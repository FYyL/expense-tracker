package pt.rawr.expense_tracker.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pt.rawr.expense_tracker.dto.CreateExpenseRequest;
import pt.rawr.expense_tracker.dto.CreateExpenseResponse;
import pt.rawr.expense_tracker.dto.ExpenseCategory;
import pt.rawr.expense_tracker.dto.ExpenseDto;
import pt.rawr.expense_tracker.dto.ExpenseSearchCriteria;
import pt.rawr.expense_tracker.dto.UpdateExpenseRequest;
import pt.rawr.expense_tracker.dto.UpdateExpenseResponse;
import pt.rawr.expense_tracker.model.ExpenseEntity;
import pt.rawr.expense_tracker.service.ExpenseTrackerService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expense-tracker")
public class ExpenseTrackerController {

    private final ExpenseTrackerService expenseTrackerService;

    @GetMapping("/expense/list")
    public List<ExpenseDto> getExpensesForUser(@RequestBody ExpenseSearchCriteria searchCriteria) {
        return expenseTrackerService.findExpenses(searchCriteria);
    }

    @GetMapping("/expense/{expenseId}")
    public ExpenseDto getExpense(@PathVariable long expenseId) {
        return expenseTrackerService.getExpense(expenseId);
    }
    
    @PostMapping("/expense")
    public CreateExpenseResponse createExpense(@RequestBody CreateExpenseRequest request) {
        return expenseTrackerService.addExpense(request);
    }

    @DeleteMapping("/expense/{expenseId}")
    public String removeExpense(@PathVariable long expenseId) {
        return expenseTrackerService.deleteExpense(expenseId);
    }

    @PatchMapping("/expense/{expenseId}")
    public UpdateExpenseResponse updateExpense(@PathVariable long expenseId, 
                                @RequestBody UpdateExpenseRequest request) {
        return null; // TODO
    }
    
}
