/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Common.Validation;
import java.util.Date;

/**
 *
 * @author suunh
 */
public class DataFormateManage {
    Validation vl = new Validation();
    public void run(){
        System.out.println("====== Validate Progaram ======");
        String Phone = vl.checkPhone("Phone number: ");
        String Email = vl.checkMail("Email: ");
       Date ngay = vl.checkDate("Date ");
        
    }
}
