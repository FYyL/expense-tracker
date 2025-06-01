package pt.rawr.expense_tracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseSearchCriteria {
    private Long userId;
    private ExpenseCategory category;
    private LocalDate startDate; 
    private LocalDate endDate;
    private Double startAmount;
    private Double endAmount;
}
