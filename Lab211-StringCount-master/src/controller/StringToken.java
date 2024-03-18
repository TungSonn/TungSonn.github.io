/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Common.Library;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class StringToken {

//    static String[] mc = {"Letter and Charator Count", "Convert base number", "Exit"};
    Library lib = new Library();

    public StringToken() {
//        super("Counting Application",)
    }

    public void handleCountWord(String input) {
        String[] string = new String[100];
        int length = 0;

        LinkedHashMap<String, Integer> countWord = new LinkedHashMap<String, Integer>();
        StringTokenizer token = new StringTokenizer(input, "~!@#$%^&*()_+<>?/. ");
        while (token.hasMoreTokens()) {
            string[length] = token.nextToken();
            length++;
        }
        for (int i = 0; i < length; i++) {
            String word = string[i];
            int d = 0;
            for (int j = 0; j < length; j++) {
                if (string[j].equals(word)) {
                    d++;
                }
//                Hel lo Hel ld 
            }
            countWord.put(word, d);
        }

        lib.display(countWord);
    }

    public void handleCountChar(String input) {
        StringTokenizer token = new StringTokenizer(input, "~!@#$%^&*()_+<>?/. ");
        StringBuilder stringBuild = new StringBuilder();
        while (token.hasMoreTokens()) {
            stringBuild.append(token.nextToken());
        }
        String str = stringBuild.toString();

        LinkedHashMap<String, Integer> countChar = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str.charAt(i) == ' ') {
                continue;
            }
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }
            countChar.put(ch + "", count);
        }

        lib.display(countChar);
    }

    public void run() {
        String input = lib.inputString("Enter your content:");
        System.out.println("");
        handleCountWord(input);
        System.out.println("");
        handleCountChar(input);
        System.out.println("");

    }

}
