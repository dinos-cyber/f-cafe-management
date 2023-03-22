/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapnhom1;

/**
 *
 * @author FPTSHOP
 */
public class Person {
    private int Yob;
    private String Name;

    public Person() {
    }

    public Person(int Yob, String Name) {
        this.Yob = Yob;
        this.Name = Name;
    }

    public int getYob() {
        return Yob;
    }

    public void setYob(int Yob) {
        this.Yob = Yob;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}
