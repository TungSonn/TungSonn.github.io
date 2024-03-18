/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.TaskController;
import java.util.Scanner;

/**
 *
 * @author tung2
 */
public class main {
    public static void main(String[] args) {
        TaskController controller = new TaskController();
        Scanner scanner = new Scanner(System.in);
        menu view = new menu(controller, scanner);

        int choice;
        do {
            view.displayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    view.addTask();
                    break;
                case 2:
                    view.deleteTask();
                    break;
                case 3:
                    view.showTasks(controller.getDataTasks());
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
