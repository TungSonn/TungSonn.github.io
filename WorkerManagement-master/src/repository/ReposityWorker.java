/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DataAcess.WorkerAccess;
import java.util.ArrayList;
import model.Worker;

/**
 *
 * @author ASUS
 */
public class ReposityWorker implements InterfaceWorker{

      @Override
    public void addNewWorker(ArrayList<Worker> contactList) {
        int id = autoCreaslistWorkerID(contactList);
          WorkerAccess.Intance().createContact(contactList, id);
    }

      @Override
    public int autoCreaslistWorkerID(ArrayList<Worker> listContact) {
        int id = 0;
        if (listContact.size() == 0) {
            return 1;
        } else {
            for (Worker c : listContact) {
                if (c.getId() == listContact.size()) {
                    id = c.getId() + 1;
                }
            }
        }
        return id;
    }

    @Override
    public void changeSalary(ArrayList<Worker> listWorker) {
        WorkerAccess.Intance().changeSalary(listWorker);
    }

    @Override
    public void displayAll(ArrayList<Worker> list) {
        WorkerAccess.Intance().displayAll(list);
    }



}
