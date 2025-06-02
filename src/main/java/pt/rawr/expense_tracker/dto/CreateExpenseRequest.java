package pt.rawr.expense_tracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateExpenseRequest {
    private ExpenseCategory category;
    private LocalDate date;
    private Double amount;
    private String description;
}
