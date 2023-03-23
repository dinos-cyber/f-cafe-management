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
public class PartTime extends NhanVien {

    private double SalaryInHour;
    private double Hours;

    public PartTime() {
    }

    public PartTime(String Name, String GioiTinh, String QueQuan, int Yob, double SalaryInHour, double Hours) {
        super(Name, GioiTinh, QueQuan, Yob);
        this.SalaryInHour = SalaryInHour;
        this.Hours = Hours;
    }

    public double getSalaryInHour() {
        return SalaryInHour;
    }

    public void setSalaryInHour(double SalaryInHour) {
        this.SalaryInHour = SalaryInHour;
    }

    public double getHours() {
        return Hours;
    }

    public void setHours(double Hours) {
        this.Hours = Hours;
    }

    @Override
    public void showInfo() {
        System.out.printf("|%15s|%7s|%10s|%7d|%7f|%7f|", super.getName(), super.getGioiTinh(), super.getQueQuan(), super.getYob(), SalaryInHour, Hours);
    }

}
