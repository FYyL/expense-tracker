package pt.rawr.expense_tracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDto {
    private ExpenseCategory category;
    private double amount;
    private String description;
    private LocalDate date;
}
