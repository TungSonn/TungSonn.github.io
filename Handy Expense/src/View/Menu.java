package View;

import Model.Expense;
import java.util.List;

public class Menu {
    public void displayMenu() {
        System.out.println("Handy Expense Menu:");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Remove an expense");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public double displayExpenses(List<Expense> expenses) {
        System.out.println("ID\tDate\t\tAmount\t\tContent");
        double totalAmount = 0;
        for (Expense expense : expenses) {
            System.out.println(expense);
            totalAmount += expense.getAmount();
        }
        return totalAmount;
    }


    public void displayMessage(String message) {
        System.out.println(message);
    }
}


