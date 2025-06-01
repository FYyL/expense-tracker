package pt.rawr.expense_tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pt.rawr.expense_tracker.mapper.ExpenseMapper;
import pt.rawr.expense_tracker.repository.ExpenseRepository;
import pt.rawr.expense_tracker.service.ExpenseTrackerService;
import pt.rawr.expense_tracker.service.impl.ExpenseTrackerServiceImpl;

@Configuration
public class ExpenseTrackerConfig {

    @Bean
    ExpenseTrackerService expenseTrackerService(@Autowired ExpenseRepository expenseRepository, @Autowired ExpenseMapper expenseMapper) {
        return new ExpenseTrackerServiceImpl(expenseRepository, expenseMapper);
    }
}
