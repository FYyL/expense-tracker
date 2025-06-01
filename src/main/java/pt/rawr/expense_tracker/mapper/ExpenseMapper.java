package pt.rawr.expense_tracker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import pt.rawr.expense_tracker.dto.ExpenseDto;
import pt.rawr.expense_tracker.model.ExpenseEntity;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    ExpenseDto expenseEntityToExpenseDto(ExpenseEntity expenseEntity);

}
