/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import javax.xml.validation.Validator;
import model.User;
import view.Menu;
import view.Validation;

/**
 *
 * @author ASUS
 */
public class Login extends Menu<String> {

    Validation vl = new Validation();
    static String[] choices = {"Vietnamese", "English"};

    public Login() {
        super("TPBANK", choices, "Exit");
    }
    ArrayList<User> list = new ArrayList<>();

    @Override
    public void execute(int n) {
        switch (n) {
            case 2: {
                Locale localeEn = new Locale("en");
                ResourceBundle labels = ResourceBundle.getBundle("en", localeEn);
                String account = vl.inputInt(labels.getString("an"), labels);
                String password = vl.getPassword(labels.getString("p"), labels);
                String inputCaptcha = generateCaptcha();
                System.out.println(labels.getString("c") + inputCaptcha);
                String lastR = "";
                while (true) {
                    String captcha = vl.checkCaptcha(inputCaptcha, labels);
                    if (captcha.isEmpty()) {
                        inputCaptcha = generateCaptcha();
                        System.out.println(labels.getString("c") + inputCaptcha);
                        continue;
                    } else {
                        lastR = captcha;
                        break;
                    }
                }

                User u = new User(account, password, lastR);
                list.add(u);
                break;
            }
            case 1: {
                Locale localeEn = new Locale("vi");
                ResourceBundle labels = ResourceBundle.getBundle("vn", localeEn);
                String account = vl.inputInt(labels.getString("an"), labels);
                String password = vl.getPassword(labels.getString("p"), labels);
                String inputCaptcha = generateCaptcha();
                System.out.println(labels.getString("c") + inputCaptcha);
                String lastR = "";
                while (true) {
                    String captcha = vl.checkCaptcha(inputCaptcha, labels);
                    if (captcha.isEmpty()) {
                        inputCaptcha = generateCaptcha();
                        System.out.println(labels.getString("c") + inputCaptcha);
                        continue;
                    } else {
                        lastR = captcha;
                        break;
                    }
                }

                User u = new User(account, password, lastR);
                list.add(u);
                break;
            }
        }
    }

    public String generateCaptcha() {
        int length = 5;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

}
