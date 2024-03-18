/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DataAccess.DictionaryAccess;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author suunh
 */
public class DictionaryDictonary implements InterFaceDictionary{

    @Override
    public void createNewDictionary(HashMap<String, String> dic) {
        DictionaryAccess.Intance().createNewDictionary(dic);
        DictionaryAccess.Intance().saveFilekde(dic, "diction.txt");
    }

    @Override
    public void deteleDictionary(HashMap<String, String> dic) {
        DictionaryAccess.Intance().deteleDictionary(dic);
        DictionaryAccess.Intance().saveFilecde(dic, "diction.txt");
    }

    @Override
    public void translateDictionary(HashMap<String, String> dic) {
        DictionaryAccess.Intance().translateDictionary(dic);
        
    }

 
    
}
