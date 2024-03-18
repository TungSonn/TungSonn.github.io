/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Menu;

/**
 *
 * @author ASUS
 */
public class Manager extends Menu<String>{
        static String[] choices = {"Calculate Superlative Equation", "Calculate Quadratic  Equation"};

    public Manager() {
        super("Calculate Phuong Trinh",choices,"Exit");
    }
        
        HandleCalculate handle = new HandleCalculate();

    @Override
    public void execute(int n) {
        switch(n){ 
            case 1:{ 
                handle.superlativeEquation();
                break;
            }
            case 2: { 
                handle.quadraticEquation();
                break;
            }
        }
    }
    
}
