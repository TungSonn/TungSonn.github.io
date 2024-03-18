/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcess;

import Common.Library;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import model.Salary;
import model.Worker;

/**
 *
 * @author ASUS
 */
public class WorkerAccess {

    private static WorkerAccess instance = null;
    private Library lib = new Library();
    LocalDateTime now = LocalDateTime.now();

    public static WorkerAccess Intance() {
        if (instance == null) {
            synchronized (Worker.class) {
                if (instance == null) {
                    instance = new WorkerAccess();
                }
            }
        }
        return instance;
    }

    public void createContact(ArrayList<Worker> listWorker, int id) {
        String fullName = lib.getValue("Input name of the worker:");
        int age = lib.checkInt("Input old of the worker:", 18, 50);
        Salary salary = new Salary(lib.getDouble("Input Salary of the worker:"), "UP", now);
        String localtion = lib.getValue("Input work location of the Worker:");
        Worker woker = new Worker(id, fullName, age, salary, localtion);
        listWorker.add(woker);
        System.out.println("========================================================");
        System.out.println("Create new Worker is Sucess");
        System.out.println("========================================================");
    }

    public void changeSalary(ArrayList<Worker> listWorker) {
        System.out.println("--------------------Change Salary-----------------------");
        Worker newW = null;
        int id = lib.checkInt("Input id of worker you want to change", 1, listWorker.size());
        for (int i=listWorker.size()-1; i>=0;i--) {
            Worker w = listWorker.get(i);
            if (w.getId() == id) {
                Salary s;
                int type = lib.checkType("Input type change you want to apply for worker:(1.UP 2.DOWN):");
                switch (type) {

                    case 1: {
                        System.out.println("--------------------Up Salary-----------------------");
                        double newSalary = lib.getDouble("Input Bonus Salary you want to update:");
                        double oldSalry = w.getSalary().getSalary();
                        s = new Salary(newSalary + oldSalry, "UP", now);
                        newW = new Worker(w.getId(), w.getName(), w.getAge(), s, w.getWorkLocation());
//                        w.setSalary(s);
                        System.out.println("-----------------------------------------------");
                        break;
                    }
                    case 2: {
                        System.out.println("--------------------Down Salary-----------------------");

                        double newSalary = lib.getDouble("Input Abstraction Salary you want to update:");
                        double oldSalry = w.getSalary().getSalary();
                        double finalSalary = oldSalry - newSalary;
                        if (finalSalary < 0) {
                            System.out.println("Khong du luong de tru.");
                            System.out.println("-----------------------------------------------");

                            break;
                        } else {
//                            w.setSalary(new Salary(finalSalary, "DOWN", now));
                            s = new Salary(oldSalry - newSalary, "DOWN", now);
                            newW = new Worker(w.getId(), w.getName(), w.getAge(), s, w.getWorkLocation());

                        }
                        System.out.println("-----------------------------------------------");

                        break;
                    }
                }
                break;
            }
        }
        listWorker.add(newW);

    }

    public void displayAll(ArrayList<Worker> list) {
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.println("Code\tName\t\t\tAge\t\tSalary\t\t\tStatus\tDate");

        for (Worker w : list) {
            String formattedRow = String.format("%s\t%s\t\t\t%s\t\t%s\t\t\t%s\t%s", w.getId(), w.getName(), w.getAge(), w.getSalary().getSalary(), w.getSalary().getStatus(), w.getSalary().getDate().getYear()+"/"+w.getSalary().getDate().getMonthValue()+"/"+w.getSalary().getDate().getDayOfMonth()+" - "+w.getSalary().getDate().getHour()+":"+w.getSalary().getDate().getMinute()+":"+w.getSalary().getDate().getSecond());
            System.out.println(formattedRow);
        }
    }
}
