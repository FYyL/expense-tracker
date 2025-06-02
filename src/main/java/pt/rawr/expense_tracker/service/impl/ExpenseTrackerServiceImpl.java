package pt.rawr.expense_tracker.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import pt.rawr.expense_tracker.dto.CreateExpenseRequest;
import pt.rawr.expense_tracker.dto.CreateExpenseResponse;
import pt.rawr.expense_tracker.dto.ExpenseDto;
import pt.rawr.expense_tracker.dto.ExpenseSearchCriteria;
import pt.rawr.expense_tracker.dto.ExpenseStatus;
import pt.rawr.expense_tracker.dto.UpdateExpenseRequest;
import pt.rawr.expense_tracker.dto.UpdateExpenseResponse;
import pt.rawr.expense_tracker.exception.ExpenseNotFoundException;
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
    public CreateExpenseResponse createExpense(CreateExpenseRequest request) {
        LocalDateTime now = LocalDateTime.now();
        ExpenseEntity expense = new ExpenseEntity();
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());
        expense.setCreateTimestamp(now);
        expense.setUpdateTimestamp(now);
        expense.setStatus(ExpenseStatus.CREATED);
        expense = expenseRepository.save(expense);
        
        CreateExpenseResponse response = new CreateExpenseResponse();
        response.setId(expense.getId());
        return response;
        
    }

    @Override
    public UpdateExpenseResponse updateExpense(long expenseId, UpdateExpenseRequest request) {
        ExpenseEntity expense = expenseRepository.findById(expenseId)
            .orElseThrow(() -> new ExpenseNotFoundException(expenseId));
        
        expenseMapper.updateExpenseFromRequest(request, expense);
        expense.setUpdateTimestamp(LocalDateTime.now());
        expense = expenseRepository.save(expense);
        UpdateExpenseResponse response = new UpdateExpenseResponse();
        response.setId(expense.getId());
        return response;
    }

    @Override
    public void deleteExpense(long expenseId) {
        ExpenseEntity expense = expenseRepository.findById(expenseId)
            .orElseThrow(() -> new ExpenseNotFoundException(expenseId));
        
        expense.setStatus(ExpenseStatus.DELETED);
        expense.setUpdateTimestamp(LocalDateTime.now());
        expenseRepository.save(expense);
    }

    @Override
    public List<ExpenseDto> findExpenses(ExpenseSearchCriteria criteria) {
        Specification<ExpenseEntity> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getCategory() != null) {
                predicates.add(cb.equal(root.get("category"), criteria.getCategory()));
            }
            if (criteria.getStartDate() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("date"), criteria.getStartDate()));
            }
            if (criteria.getEndDate() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("date"), criteria.getEndDate()));
            }
            if (criteria.getStartAmount() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("amount"), criteria.getStartAmount()));
            }
            if (criteria.getEndAmount() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("amount"), criteria.getEndAmount()));
            }

            // Always filter by status CREATED
            predicates.add(cb.equal(root.get("status"), ExpenseStatus.CREATED));

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        return expenseMapper.toDtoList(expenseRepository.findAll(spec));
    }

    @Override
    public ExpenseDto getExpenseById(long id) {
        ExpenseEntity expense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
        return expenseMapper.expenseEntityToExpenseDto(expense);
    }

}
