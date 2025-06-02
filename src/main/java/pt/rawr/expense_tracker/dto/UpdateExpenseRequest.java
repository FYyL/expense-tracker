package pt.rawr.expense_tracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UpdateExpenseRequest {
    private ExpenseCategory category;
    private LocalDate date;
    private Double amount;
    private String description;
}
