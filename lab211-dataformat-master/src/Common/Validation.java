/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author suunh
 */
public class Validation {

    protected String DATE_FORMAT = "dd/MM/yyyy";
    Scanner sc = new Scanner(System.in);

    public String getValue(String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine();
            input.trim();
            if (input == null || input.length() == 0) {
                System.out.println("Do not enter null data. Please enter again.");
                continue;
            }
            return input;
        }
    }

    public Date checkDate(String promptString) {
        boolean isValidDate = false;
        Date date = null;

        while (!isValidDate) {
            try {
                System.out.print(promptString + ":");
                date = validStringToDate(sc.nextLine().trim());
                isValidDate = true;
            } catch (ParseException ex) {
                System.out.println("Date to correct format(dd/mm/yyyy)");
            }
        }

        return date;
    }

    public Date validStringToDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setLenient(false);
        // df.setLenient(false);
        return df.parse(date);
    }
//#makingcolor

    public String showDate(Date date) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(date);
    }

    public String checkMail(String msg) {
        while (true) {

            String email = getValue(msg);

            if (isValidEmail(email)) {
                return email;
            } else {
                System.out.println("Email must is correct format");
            }
        }
    }

    public boolean isValidEmail(String email) {

        String emailRegex = "^[a-z0-9.-]+@[a-z0-9.-]+\\.[a-z]{2,63}$";
        return email.matches(emailRegex);
    }

    public String checkPhone(String msg) {
        String input;
        while (true) {
            input = getValue(msg);
            try {
                Long.parseLong(input);
                if (input == null || input.length() != 10) {
                    System.out.println("Phone number must be 10 digits");
                    continue;

                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Phone must be number");
            }

        }
        return input;
    }
}
