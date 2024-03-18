/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DataAccess.DictionaryAccess;
import java.util.HashMap;
import repository.DictionaryDictonary;
import view.Menu;

/**
 *
 * @author suunh
 */
public class ManagerDiction extends Menu<String> {

    static String[] choices = {"Add Word", "Delete Word", "Translate"};
    DictionaryDictonary dic = new DictionaryDictonary();
    HashMap<String, String> Hdic = new HashMap<>();
    
    public ManagerDiction() {
        super("======================== Manger dictionary ========================", choices, "Exit");
         DictionaryAccess.Intance().readFile(Hdic,"diction.txt");

    }
    @Override
    public void execute(int n) {
         switch (n) {
            case 1:              
                dic.createNewDictionary(Hdic);
                break;
            case 2:
                dic.deteleDictionary(Hdic);
                break;
            case 3:
                dic.translateDictionary(Hdic);
                break;
        }
    }

}
