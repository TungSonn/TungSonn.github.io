/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.Worker;

/**
 *
 * @author ASUS
 */
public interface InterfaceWorker {

    public void addNewWorker(ArrayList<Worker> list);

    public int autoCreaslistWorkerID(ArrayList<Worker> list);

    public void changeSalary(ArrayList<Worker> listWorker);

    public void displayAll(ArrayList<Worker> list);
}
