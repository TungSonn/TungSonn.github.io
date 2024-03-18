/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DataAccess.ContactAcces;
import java.util.ArrayList;
import model.Contact;

/**
 *
 * @author ASUS
 */
public class ContactRespository implements InterFaceContact {

    @Override
    public void addContact(ArrayList<Contact> contactList) {
        int id = autoCreaslistContactingID(contactList);
        ContactAcces.Intance().createContact(contactList, id);
    }

    @Override
    public void displayAll(ArrayList<Contact> list) {
        System.out.println("===================== List all the contacts ===================");
        System.out.printf("%-5s|%-20s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact c : list) {
            System.out.printf("%-6d%-21s%-16s%-16s%-16s%-16s%-16s\n", c.getId(), c.getFullname(), c.getFirstName(), c.getLastName(), c.getGroup(), c.getAddress(), c.getPhone());
        }
        System.out.println("==========================================================");
        System.out.println("");

    }

    @Override
    public void deleteContact(ArrayList<Contact> list) {
        ContactAcces.Intance().deleteContact(list);
        displayAll(list);
    }

    @Override
    public int autoCreaslistContactingID(ArrayList<Contact> listContact) {
        int id = 0;
        if (listContact.size() == 0) {
            return 1;
        } else {
            for (Contact c : listContact) {
                if (c.getId() == listContact.size()) {
                    id = c.getId() + 1;
                }
            }
        }
        return id;
    }

}
