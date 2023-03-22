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
public class FullTime extends NhanVien{
    private double Salary;
    private int ThamNien;

    public FullTime() {
    }

    public FullTime(String Name, String GioiTinh, String QueQuan, int Yob, double Salary, int ThamNien) {
        super(Name, GioiTinh, QueQuan, Yob);
        this.Salary = Salary;
        this.ThamNien = ThamNien;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public int getThamNien() {
        return ThamNien;
    }

    public void setThamNien(int ThamNien) {
        this.ThamNien = ThamNien;
    }
    
    @Override
    public void showInfo() {
        System.out.printf("|%15s|%7s|%10s|%7d|%7f|%7d|", super.getName(), super.getGioiTinh(), super.getQueQuan(), super.getYob(), Salary, ThamNien);
    }
    
}
