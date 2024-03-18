/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import java.util.ArrayList;
import model.InterFaceEqualation;
import model.inputNumber;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class HandleCalculate implements InterFaceEqualation{

    inputNumber ipn = new inputNumber();
    Library lib = new Library();

    public void superlativeEquation() {
        System.out.println("============================== Calculate Superlative Equation =================================");
        double firstNum = lib.getDouble("Input the first number:");
        double secondNum = lib.getDouble("Input the second number:");
        double result = 0;
        result = result + (-secondNum) / firstNum;
        System.out.println("Solution: x = " + result);
        double[] a = {firstNum, secondNum, result};
        inra(a);

    }

    public void quadraticEquation() {
        System.out.println("============================== Calculate Quadratic  Equation =================================");
        double firstNum = lib.getDouble("Input the first number:");
        double secondNum = lib.getDouble("Input the second number:");
        double thirdNum = lib.getDouble("Input the third number:");
        double delta = secondNum * secondNum - 4 * firstNum * thirdNum;

        if (delta > 0) {
            double x1 = (-secondNum + Math.sqrt(delta)) / (2 * firstNum);
            double x2 = (-secondNum - Math.sqrt(delta)) / (2 * firstNum);
            System.out.println("The equation has two distinct solutions:");
            System.out.println("x1 = " + x1 + " and " + "x2 = " + x2);
            double[] a = {firstNum, secondNum, thirdNum, x1, x2};
            inra(a);
        } else if (delta == 0) {
            double x = -secondNum / (2 * firstNum);
            System.out.println("The equation has a double solution:");
            System.out.println("x = " + x);
            double[] a = {firstNum, secondNum, thirdNum, x};
            inra(a);

        } else {
            System.out.println("The equation has no real solutions.");
            double[] a = {firstNum, secondNum, thirdNum};
            inra(a);

        }

    }

    public void inra(double a[]) {
        System.out.print("Odd Number:");
        display(checkNumber(a).get(0));
        System.out.println("");
        System.out.print("Even Number:");
        display(checkNumber(a).get(1));
        System.out.println("");
        System.out.println("Square Number:");
        display(checkNumber(a).get(2));

    }

    public ArrayList<ArrayList<Double>> checkNumber(double[] a) {
        ArrayList<Double> numberOdd = new ArrayList<>();
        ArrayList<Double> numberEven = new ArrayList<>();
        ArrayList<Double> numberSquare = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 1) {
                numberOdd.add(a[i]);
            } else if (i % 2 == 0) {
                numberEven.add(a[i]);
            } else if (i % 4 == 0) {
                numberSquare.add(a[i]);
            }
        }
        ArrayList<ArrayList<Double>> total = new ArrayList<>();
        total.add(numberOdd);
        total.add(numberEven);
        total.add(numberSquare);
        return total;
    }

    public void display(ArrayList<Double> list) {
        for (Double d : list) {
            System.out.print(d + " ;");
        }
    }

}
