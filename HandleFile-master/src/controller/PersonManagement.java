/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Repository.PersonReposity;
import java.util.ArrayList;
import model.Person;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class PersonManagement extends Menu<String>{

    ArrayList<Person> listPerson = new ArrayList<>();
    PersonReposity repo = new PersonReposity();
    static String[] choices = {"Find person info", "Copy text to new file"};

    public PersonManagement() {
        super("======================= Management Person App ====================",choices,"Exit");
    }

    @Override
    public void execute(int n) {
        switch(n) { 
            case 1: { 
                repo.readFile("person.txt", listPerson);
                repo.findPerson(listPerson);
                break;
            }
            case 2: { 
                repo.writeFile();
                break;
            }
        }
    }

    
}
