package pt.rawr.expense_tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pt.rawr.expense_tracker.controller.ExpenseTrackerController;
import pt.rawr.expense_tracker.mapper.ExpenseMapper;
import pt.rawr.expense_tracker.repository.ExpenseRepository;
import pt.rawr.expense_tracker.service.ExpenseTrackerService;
import pt.rawr.expense_tracker.service.impl.ExpenseTrackerServiceImpl;

@Configuration
public class ExpenseTrackerConfig {

    @Bean
    ExpenseTrackerService expenseTrackerService(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        return new ExpenseTrackerServiceImpl(expenseRepository, expenseMapper);
    }

    @Bean
    ExpenseTrackerController expenseTrackerController(ExpenseTrackerService expenseTrackerService) {
        return new ExpenseTrackerController(expenseTrackerService);
    }
}
