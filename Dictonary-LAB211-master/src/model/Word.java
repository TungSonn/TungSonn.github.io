/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Word {
    private String Vword;
    private String Eword;

    public Word() {
    }

    public Word(String Vword, String Eword) {
        this.Vword = Vword;
        this.Eword = Eword;
    }

    public String getVword() {
        return Vword;
    }

    public void setVword(String Vword) {
        this.Vword = Vword;
    }

    public String getEword() {
        return Eword;
    }

    public void setEword(String Eword) {
        this.Eword = Eword;
    }

    @Override
    public String toString() {
        return "Word{" + "Vword=" + Vword + ", Eword=" + Eword + '}';
    }
    
}
