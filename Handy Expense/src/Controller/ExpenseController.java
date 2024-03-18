package Controller;

import Model.Expense;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseController {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Date date, double amount, String content) {
        int id = expenses.isEmpty() ? 1 : expenses.get(expenses.size() - 1).getId() + 1;
        Expense expense = new Expense(id, date, amount, content);
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }

    public boolean deleteExpense(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                expenses.remove(expense);
                return true;
            }
        }
        return false;
    }
}
