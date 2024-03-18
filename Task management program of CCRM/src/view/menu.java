/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.TaskController;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Task;

import java.util.List;
import java.util.Scanner;

public class menu {
    private TaskController controller;
    public Scanner scanner;

    public menu(TaskController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("===== Task Management Menu =====");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Show Tasks");
        System.out.println("4. Exit");
        System.out.println("===============================");
        System.out.print("Enter your choice: ");
    }

    public void addTask() {
        try {
            System.out.print("Enter Requirement Name: ");
            String requirementName = scanner.nextLine();
            System.out.print("Enter Assignee: ");
            String assignee = scanner.nextLine();
            System.out.print("Enter Reviewer: ");
            String reviewer = scanner.nextLine();
            System.out.print("Enter Task Type ID (1-4): ");
            int taskTypeID = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Date (dd-MM-yyyy): ");
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(scanner.nextLine());
            System.out.print("Enter Plan From (8.0-17.5): ");
            double planFrom = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Plan To (8.0-17.5): ");
            double planTo = Double.parseDouble(scanner.nextLine());

            int id = controller.addTask(requirementName, assignee, reviewer, taskTypeID, date, planFrom, planTo);
            System.out.println("Task added successfully with ID: " + id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteTask() {
        try {
            System.out.print("Enter Task ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            controller.deleteTask(id);
            System.out.println("Task with ID " + id + " deleted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showTasks(List<Task> tasks) {
    if (tasks.isEmpty()) {
        System.out.println("No tasks found.");
    } else {
        System.out.println("===== Tasks =====");
        System.out.printf("%-5s | %-20s | %-10s | %-12s | %-15s | %-15s | %-15s%n", "ID", "Name", "Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : tasks) {
            System.out.printf("%-5d | %-20s | %-10s | %-12s | %-15s | %-15s | %-15s%n", 
                              task.getId(), 
                              task.getRequirementName(), 
                              getTaskTypeName(task.getTaskTypeID()), 
                              new SimpleDateFormat("dd-MM-yyyy").format(task.getDate()), 
                              task.getPlanFrom() + " - " + task.getPlanTo(), 
                              task.getAssignee(), 
                              task.getReviewer());
        }
        System.out.println("=================");
    }
}

    private String getTaskTypeName(int taskTypeID) {
        switch (taskTypeID) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
            default:
                return "Unknown";
        }
    }
}
