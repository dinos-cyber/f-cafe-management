/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery_store_management;

/**
 *
 * @author aleno
 */
public abstract class Staff extends Person {
    private String gender;
    private String place;

    public Staff() {
    }

    public Staff(String Name, String gender, String place, int Yob) {
        super(Name,Yob);
        this.gender = gender;
        this.place = place;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = gender;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    public abstract void showInfo();
}
