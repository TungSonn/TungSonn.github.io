/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tung2
 */
public class TaskController {
    private List<Task> tasks = new ArrayList<>();

    public int addTask(String requirementName, String assignee, String reviewer, int taskTypeID, Date date, double planFrom, double planTo) throws Exception {
        if (taskTypeID < 1 || taskTypeID > 4) {
            throw new Exception("Invalid Task Type ID");
        }

        if (planFrom >= planTo || planFrom < 8 || planTo > 17.5) {
            throw new Exception("Invalid Plan From/To");
        }

        int id = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        Task task = new Task(id, taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
        tasks.add(task);
        return id;
    }

    public void deleteTask(int id) throws Exception {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new Exception("Task with ID " + id + " not found");
        }
    }

    public List<Task> getDataTasks() {
        return tasks;
    }
}
