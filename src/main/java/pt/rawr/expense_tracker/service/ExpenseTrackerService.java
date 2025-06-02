package pt.rawr.expense_tracker.service;

import java.util.List;

import pt.rawr.expense_tracker.dto.CreateExpenseRequest;
import pt.rawr.expense_tracker.dto.CreateExpenseResponse;
import pt.rawr.expense_tracker.dto.ExpenseDto;
import pt.rawr.expense_tracker.dto.ExpenseSearchCriteria;
import pt.rawr.expense_tracker.dto.UpdateExpenseRequest;
import pt.rawr.expense_tracker.dto.UpdateExpenseResponse;

public interface ExpenseTrackerService {
    public CreateExpenseResponse createExpense(CreateExpenseRequest request);
    public UpdateExpenseResponse updateExpense(long expenseId, UpdateExpenseRequest request);
    public void deleteExpense(long expenseId);
    public List<ExpenseDto> findExpenses(ExpenseSearchCriteria criteria);
    public ExpenseDto getExpenseById(long id);
}
