package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
        String name;
        System.out.println("----- Nhap hang -----");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nhap ten san pham: ");
            name = sc.nextLine();
            check = searchSanPhamByName(name);
            if (check == true) {
                System.out.printf("San pham nay da ton tai\n", name);
            }
        } while (check == true);
        System.out.print("Nhap gia san pham: ");
        int price = sc.nextInt();
        System.out.print("Nhap so luong muon them vao kho: ");
        int stock = sc.nextInt();
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
    }

    public void showKho() {
        DoBan db = new DoBan();
        System.out.printf("|%-15s|%-10s|%-10s|\n", "Ten san pham", "Gia do ban", "So luong");
        for (DoBan doBan : list) {
            doBan.showInfo();
        }
    }

    public void setStock() {
        DoBan db = new DoBan();
        Scanner sc = new Scanner(System.in);
        System.out.print("San pham muon chinh sua: ");
        String reStockTen = sc.nextLine();
        if (searchSanPhamObjectByName(reStockTen) != null) {
            System.out.print("Chinh sua so luong san pham: ");
            int reStock = sc.nextInt();
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
