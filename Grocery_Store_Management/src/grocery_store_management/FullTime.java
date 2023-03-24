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
public class FullTime extends Staff {
    private int Salary;
    private int Hours;

    public FullTime() {
    }

    public FullTime(String Name, String gender, String place, int Yob,int Salary, int Hours) {
        super(Name, gender, place, Yob);
        this.Salary = Salary;
        this.Hours = Hours;
    }


    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int Hours) {
        this.Hours=Hours;
    }
    
    @Override
    public void showInfo() {
        System.out.printf("|%15s|%7s|%10s|%7d|%7d|%7d|\n", super.getName(), super.getGender(), super.getPlace(), super.getYob(), (int)Salary, (int)Hours);
    }
}
