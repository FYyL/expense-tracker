package pt.rawr.expense_tracker.controller.bean;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateExpenseResponse {
    private long id;
    private ExpenseCategory category;
    private LocalDate date;
    private Double amount;
    private String description;
}
