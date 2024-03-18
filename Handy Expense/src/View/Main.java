package View;

import Controller.ExpenseController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseController controller = new ExpenseController();
        Menu view = new Menu();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            view.displayMenu();
            // Get user input for choice
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Get user input for date, amount, and content
                    System.out.print("Enter date (dd-MM-yyyy): ");
                    String dateString = scanner.next();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter content: ");
                    String content = scanner.next();
                    
                    // Parse date string to Date object
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = null;
                    try {
                        date = dateFormat.parse(dateString);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    
                    controller.addExpense(date, amount, content);
                    view.displayMessage("Expense added successfully.");
                    break;
                case 2:
                    double totalAmount = view.displayExpenses(controller.getAllExpenses());
                    System.out.println("Total: " + totalAmount);
                    break;
                case 3:
                    // Get user input for ID to delete
                    System.out.print("Enter the ID of the expense to delete: ");
                    int idToDelete = scanner.nextInt();
                    if (controller.deleteExpense(idToDelete)) {
                        view.displayMessage("Expense deleted successfully.");
                    } else {
                        view.displayMessage("Delete an expense failed. Expense not found.");
                    }
                    break;
                case 4:
                    view.displayMessage("Exiting program...");
                    break;
                default:
                    view.displayMessage("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        // Close the scanner
        scanner.close();
    }
}
