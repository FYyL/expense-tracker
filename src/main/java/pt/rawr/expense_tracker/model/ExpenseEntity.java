package pt.rawr.expense_tracker.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import pt.rawr.expense_tracker.dto.ExpenseCategory;
import pt.rawr.expense_tracker.dto.ExpenseStatus;

@Getter 
@Setter
@Entity
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;
    
    private double amount;
    private String description;
    private LocalDate date;
    private LocalDateTime createTimestamp;
    private LocalDateTime updateTimestamp;
    
    @Enumerated(EnumType.STRING)
    private ExpenseStatus status;
}
