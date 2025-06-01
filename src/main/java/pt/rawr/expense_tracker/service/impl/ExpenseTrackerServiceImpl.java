package pt.rawr.expense_tracker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pt.rawr.expense_tracker.dto.CreateExpenseRequest;
import pt.rawr.expense_tracker.dto.CreateExpenseResponse;
import pt.rawr.expense_tracker.dto.ExpenseDto;
import pt.rawr.expense_tracker.dto.ExpenseSearchCriteria;
import pt.rawr.expense_tracker.dto.UpdateExpenseRequest;
import pt.rawr.expense_tracker.dto.UpdateExpenseResponse;
import pt.rawr.expense_tracker.mapper.ExpenseMapper;
import pt.rawr.expense_tracker.model.ExpenseEntity;
import pt.rawr.expense_tracker.repository.ExpenseRepository;
import pt.rawr.expense_tracker.service.ExpenseTrackerService;

@Service
@RequiredArgsConstructor
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    @Override
    public CreateExpenseResponse addExpense(CreateExpenseRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addExpense'");
    }

    @Override
    public UpdateExpenseResponse updateExpense(long expenseId, UpdateExpenseRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateExpense'");
    }

    @Override
    public void deleteExpense(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteExpense'");
    }

    @Override
    public List<ExpenseDto> findExpenses(ExpenseSearchCriteria criteria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findExpenses'");
    }

    @Override
    public ExpenseDto getExpenseById(long id) {
        ExpenseEntity expense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
        return expenseMapper.expenseEntityToExpenseDto(expense);
    }

}
