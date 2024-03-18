/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Common.Library;
import java.util.ArrayList;
import model.Contact;

/**
 *
 * @author ASUS
 */
public class ContactAcces {

    private static ContactAcces instance = null;
    Library lib = new Library();

    public static ContactAcces Intance() {
        if (instance == null) {
            synchronized (Contact.class) {
                if (instance == null) {
                    instance = new ContactAcces();
                }
            }
        }
        return instance;
    }

    public void createContact(ArrayList<Contact> listContact, int id) {
        String fullName = lib.getValue("Input full name of the contact:");
        String group = lib.getValue("Input group of the contact:");
        String add = lib.getValue("Input address of the contact:");
        String phone = lib.checkUpdatePhone("Input phone:");
        String lastName = lib.getValue("Input last name of the contact:");
        String firstName = lib.getValue("Input first name of the contact:");
        Contact contact = new Contact(id, fullName, group, add, phone, lastName, firstName);
        listContact.add(contact);
        System.out.println("========================================================");
        System.out.println("Create new Contact is Sucess");
        System.out.println("========================================================");
    }

    public void deleteContact(ArrayList<Contact> listContact) {
        int id = lib.getInt("Input id contact you want to delete:", 1, listContact.size());
        listContact.removeIf(c -> c.getId() == id);
        System.out.println("========================================================");
        System.out.println("Delete is Sucess");
        System.out.println("========================================================");
        

    }

}
