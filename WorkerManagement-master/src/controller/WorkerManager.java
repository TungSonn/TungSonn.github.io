/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Worker;
import repository.ReposityWorker;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class WorkerManager extends Menu<String>{
    static String[] menu = {"Add Worker", "Change Salary", "Display Information Salary"};
    ReposityWorker repo = new ReposityWorker();
    ArrayList<Worker> list = new ArrayList<>();
    public WorkerManager() {
    super("======== Worker Management =========",menu,"Exit");
    }

    @Override
    public void execute(int n) {
        switch(n) { 
            case 1:  { 
                repo.addNewWorker(list);
                break;
            }
            case 2: { 
                repo.changeSalary(list);
                break;
            }
            case 3: { 
                repo.displayAll(list);
                break;
            }
        }
    }
    
}
