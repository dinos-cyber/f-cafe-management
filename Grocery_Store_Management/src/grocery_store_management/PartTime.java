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
public class PartTime extends Staff {
    private int SalaryInHour;
    private int Hours;

    public PartTime() {
    }

    public PartTime(String Name, String gender, String place, int Yob,int SalaryInHour, int Hours) {
        super(Name, gender, place, Yob);
        this.SalaryInHour = SalaryInHour;
        this.Hours = Hours;
    }

   

    public int getSalaryInHour() {
        return SalaryInHour;
    }

    public void setSalaryInHour(int SalaryInHour) {
        this.SalaryInHour = SalaryInHour;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int Hours) {
        this.Hours = Hours;
    }

    @Override
    public void showInfo() {
        System.out.printf("|%15s|%7s|%10s|%7d|%7d|%7d|\n", super.getName(), super.getGender(), super.getPlace(), super.getYob(), (int)SalaryInHour, (int)Hours);
    }
}
