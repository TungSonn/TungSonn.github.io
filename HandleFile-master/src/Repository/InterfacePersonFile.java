/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import java.util.ArrayList;
import model.Person;

/**
 *
 * @author ASUS
 */
public interface InterfacePersonFile {


    public void readFile(String path, ArrayList<Person> listPerson);

    public boolean writeFile();

    public void findPerson(ArrayList<Person> listPerson);

    public void displayAll(ArrayList<Person> listPerson);

}
