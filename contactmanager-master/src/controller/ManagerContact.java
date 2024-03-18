/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Contact;
import repository.ContactRespository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class ManagerContact extends Menu<String> {
    static String[] choices = {"Create Contact", "Display all contacts", "Delete a contact"};
    ContactRespository contactRepo = new ContactRespository();
    ArrayList<Contact> listContact = new ArrayList<>();

    public ManagerContact() {
        super("======================== Manger Contact ========================", choices, "Exit");
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                contactRepo.addContact(listContact);
                break;
            }
            case 2: { 
                contactRepo.displayAll(listContact);
                break;
            }
            case 3: { 
                contactRepo.deleteContact(listContact);
                break;
            }
        }
    }

}
