package Common;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class Library {

    Scanner sc = new Scanner(System.in);

    public String inputString(String mes) {
        System.out.println(mes);
        return sc.nextLine();
    }

    public int inputInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public void display(LinkedHashMap map) {
        map.forEach((key, value) -> {
            System.out.print(key + " = " + value+"\t");
        });
    }
   
}
