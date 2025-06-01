package pt.rawr.expense_tracker.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import pt.rawr.expense_tracker.dto.ExpenseCategory;

@Getter 
@Setter
public class ExpenseEntity {

    private long id;
    private ExpenseCategory category;
    private double amount;
    private String description;
    private LocalDate date;
    private LocalDateTime createTimestamp;
    private LocalDateTime updateTimestamp;
}
