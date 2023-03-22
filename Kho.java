package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import ultil.IOCE170935;

/**
 *
 * @author Ung Nhat Tien
 */
public class Kho {

    ArrayList<DoBan> list = new ArrayList<>();

    public Kho() {
    }

    {
        list.add(new DoBan("7 down", 10000, 15));
        list.add(new DoBan("Pepsu", 10000, 15));
        list.add(new DoBan("Coce cole", 10000, 15));
        list.add(new DoBan("Trau cung", 15000, 10));
        list.add(new DoBan("Snack", 15000, 20));
        list.add(new DoBan("Mi goi", 3000, 20));
    }

    public void addSanPham() {
        boolean check;
        boolean check2;
        String name;
        System.out.println("----- Nhap hang -----");
        do {
            name = IOCE170935.getString("Nhap ten san pham: ", "Ten khong hop le", 1);

            check = searchSanPhamByName(name);
  
            if (check == true) {
                System.out.printf("San pham nay da ton tai hoac chu cai dau cua san pham khong duoc viet hoa\n");
            }
        } while (check == true);
        int price = IOCE170935.getInteger("Nhap gia san pham: ", "Gia san pham phai la so duong!", 0);
        int stock = IOCE170935.getInteger("Nhap so luong muon them vao kho: ", "So luong san pham phai la so duong", 1);
        list.add(new DoBan(name, price, stock));
        System.out.println("Da them san pham thanh cong!");
    }

    public boolean searchSanPhamByName(String name) {
        for (DoBan doBan : list) {
            if (doBan.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean soLuongTonKho(String name, int soLuongMua) {
        if (searchSanPhamObjectByName(name) != null) {
            for (DoBan doBan : list) {
                if (name.equalsIgnoreCase(doBan.getName()) && doBan.getStock() > soLuongMua) {
                    return true;
                }
            }
        } else {
            System.out.println("San pham khong co trong kho!");
        }
        return false;
    }

    public DoBan searchSanPhamObjectByName(String name) {
        for (DoBan doBan : list) {
            if (doBan.getName().equalsIgnoreCase(name)) {
                return doBan;
            }
        }
        return null;
    }

    public void sortSanPhamByFirstLetter() {
        Comparator<DoBan> cm = new Comparator<DoBan>() {
            @Override
            public int compare(DoBan o1, DoBan o2) {
                if (o1.getName().charAt(0) > o2.getName().charAt(0)) {
                    return 1;
                } else if (o1.getName().charAt(0) < o2.getName().charAt(0)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(list, cm);
        System.out.println("Da sap xep san pham thanh cong!");
    }

    public void showKho() {
        DoBan db = new DoBan();
        System.out.printf("|%-15s|%-15s|%-10s|\n", "Ten san pham", "Gia san pham", "So luong");
        for (DoBan doBan : list) {
            doBan.showInfo();
        }
    }

    public void setStock() {
        String reStockTen;
        reStockTen = IOCE170935.getString("Nhap ten san pham muon chinh sua: ", "Ten khong hop le!", 1);
        if (searchSanPhamObjectByName(reStockTen) != null) {
            int reStock = IOCE170935.getInteger("Chinh sua so luong san pham: ", "So luong san pham phai la so duong!", 1);
            for (DoBan doBan : list) {
                if (reStockTen.equalsIgnoreCase(doBan.getName())) {
                    doBan.setStock(reStock);
                }
            }
        } else {
            System.out.println("San pham khong co trong kho!");
        }
    }

}
