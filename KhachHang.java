/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.util.ArrayList;
import cafemanament.func;
import item.sold;

/**
 *
 * @author Admin
 */
public class KhachHang extends Person implements IKhach {

    public String type;

    public KhachHang(String name, int yob, String type) {
        super(name, yob);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    ArrayList<sold> order = new ArrayList<>();

    @Override
    public void muaHang() {
        int quan;
        System.out.println();
        String name = func.getString("Nhap ten do can mua: ", "Ten Khong hop le");
        if (!kho.searchGoodByName(name)) {
            System.out.println("trong kho khong co san pham");
        } else {
            do {
                quan = func.getInteger("nhap so luong: ", "so luong khong hop le");
                if (kho.checkQuantity(name, quan)) {
                    order.add(new sold(name, quan));
                } else {
                    System.out.println("Hang ton kho khong du, ban vui long nham so luong nho hon");
                }
            }  (quan > kho.searchGoodByName(name).getStock());
        }

    }

    @Override
    public void thanhToan() {
        int sum = 0;
        for (sold g : order) {
            if (type == "vip") {
                sum += (Integer) kho.searchGoodByName(g.getName()).getPrice() * g.getQuan() * 0.9;

            } else {
                sum += kho.searchObjectByName(g.getName()).getPrice() * g.getQuan();
            }

            manager.updateInCome(sum);
            System.out.println("----HOA DON----\n");
            System.out.println("Ngay: " + java.time.LocalDate.now() + "\n");
            System.out.println("Gia tri: " + sum);
        }

    }

}
