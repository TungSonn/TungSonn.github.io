/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.Contact;

/**
 *
 * @author ASUS
 */
public interface InterFaceContact {

    public void displayAll(ArrayList<Contact> list);

    public void deleteContact(ArrayList<Contact> list);

    public void addContact(ArrayList<Contact> contactList);

    public int autoCreaslistContactingID(ArrayList<Contact> listContact);
}
