/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

public class Validation {

    // declear Scanner class to input field 
    private static final Scanner sc = new Scanner(System.in);

    public String inputString(String msg) {
        // vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {
            // allow user input a string 
            System.out.println(msg);
            String input_raw = sc.nextLine();

            // input == null or do dai = 0 => rong 
            if (input_raw == null || input_raw.length() == 0) {
                // error
                System.err.println("Must input a string not empty !!!");
                System.out.println("Please enter again!");
                continue;
            }
            return input_raw;
        }
    }

    // kiem tra so nguyen nam tu min den max 
    public int checkInt(String msg, int min, int max) {
        // vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {

            // allow user input a string 
            String input_raw = inputString(msg);

            try {
                // loi nhap sai dinh dang so 
                // asd 2123hu 
                int input = Integer.parseInt(input_raw);
                // loi nhap ngoai range cho phep
                if (input < min || input > max) {
                    System.err.println("Must input a number from " + min + " to " + max);
                    continue;

                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("");
                continue;
            }

        }
    }

     public String inputInt(String msg, ResourceBundle bundle) {
        // vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {

            // allow user input a string 
            String input_raw = inputString(msg);

            try {
                // loi nhap sai dinh dang so 
                // asd 2123hu 
                int input = Integer.parseInt(input_raw);
                // loi nhap ngoai range cho phep
                if (input_raw.length() != 10) {
                    System.out.println(bundle.getString("ae"));
                    continue;
                }
                return input + "";
            } catch (NumberFormatException e) {
                   System.out.println(bundle.getString("ae"));
                continue;
            }

        }
    }

    public int checkINT(String input) {
        while (true) {
            if (Integer.parseInt(input) > 0) {
                return Integer.parseInt(input);
            } else {
                continue;
            }
        }
    }


    public String getPassword(String mes, ResourceBundle bundle) {
        String temp;
        while (true) {
            System.out.print(mes + ": ");
            try {
                temp = sc.nextLine();
                if (temp.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,31}$")) {
                    break;
                    
                }
                else throw new Exception();
            } catch (Exception e) {
                System.out.println(bundle.getString("pe"));
            }
        }
        return temp;
    }
    
    public String checkCaptcha(String inpt,ResourceBundle bundle) { 
       
            String captcha = inputString(bundle.getString("cm"));
                if(!captcha.equals(inpt)) { 
                    System.out.println(bundle.getString("ce"));
                  return "";
                }
                else return captcha ;
        
    }

    public boolean checkNum(String i) {
        try {
            if (Integer.parseInt(i) > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
