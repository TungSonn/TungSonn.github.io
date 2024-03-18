/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.HashMap;

/**
 *
 * @author suunh
 */
public interface InterFaceDictionary {

    public void createNewDictionary(HashMap<String, String> dic);

    public void deteleDictionary(HashMap<String, String> dic);

    public void translateDictionary(HashMap<String, String> dic);

}
