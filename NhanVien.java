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
public abstract class NhanVien extends Person{
    private String GioiTinh;
    private String QueQuan;

    public NhanVien() {
    }

    public NhanVien(String Name,  String GioiTinh, String QueQuan, int Yob) {
        super(Yob, Name);
        this.GioiTinh = GioiTinh;
        this.QueQuan = QueQuan;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }
    public abstract void showInfo();
}
