package pt.rawr.expense_tracker.exception;

public class ExpenseNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExpenseNotFoundException(Long id) {
        super("Expense with ID " + id + " not found.");
    }

    public ExpenseNotFoundException(String message) {
        super(message);
    }

}
