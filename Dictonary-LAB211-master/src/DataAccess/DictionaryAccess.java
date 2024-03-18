/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Common.Library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import model.Word;

/**
 *
 * @author suunh
 */
public class DictionaryAccess {

    private static DictionaryAccess instance = null;
    Library lib = new Library();

    public static DictionaryAccess Intance() {
        if (instance == null) {
            synchronized (Word.class) {
                if (instance == null) {
                    instance = new DictionaryAccess();
                }
            }
        }
        return instance;
    }

    public void createNewDictionary(HashMap<String, String> dic) {
        String English = lib.getValue("Enter English: ");
        String Vietnamese = lib.getValue("Enter Vietnamese: ");
        dic.put(English, Vietnamese);
        System.out.println(" ======================================== ");
        System.out.println("              create success              ");
        System.out.println(" ======================================== ");

    }

    public void deteleDictionary(HashMap<String, String> dic) {
        String eng = lib.getValue("Enter word to delete: ");
        if (dic.remove(eng) != null) {
            dic.remove(eng);
            System.err.println("Delete success");
        }
    }

    public void translateDictionary(HashMap<String, String> dic) {
        String eng = lib.getValue("Enter English: ");
        if (dic.containsKey(eng)) {
            System.out.println("Vietnamese: " + dic.get(eng));
        }
        System.out.println("Not found with word: " + eng);

    }

    public void readFile(HashMap<String, String> dic, String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String arr[] = line.split(":");
                Word VW = new Word(arr[0], arr[1]);
                dic.put(arr[0], arr[1]);
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
        }
    }

    public boolean saveFilekde(HashMap<String, String> dic, String path) {

        try {
//            FileOutputStream fos = new FileOutputStream(path);
//            OutputStreamWriter osw = new OutputStreamWriter(fos);
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            Set<String> setKey = dic.keySet();
            for (String s : setKey) {
                bw.write(s + ":" + dic.get(s));
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
        public boolean saveFilecde(HashMap<String, String> dic, String path) {

        try {
//            FileOutputStream fos = new FileOutputStream(path);
//            OutputStreamWriter osw = new OutputStreamWriter(fos);
            FileWriter fw = new FileWriter(path, false);
            BufferedWriter bw = new BufferedWriter(fw);
            Set<String> setKey = dic.keySet();
            for (String s : setKey) {
                bw.write(s + ":" + dic.get(s));
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
