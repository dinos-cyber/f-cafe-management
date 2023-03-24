/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery_store_management;

import java.util.ArrayList;

/**
 *
 * @author aleno
 */
public class Bill extends ArrayList<Bill> {
    
    private int money;

    
    public Bill() {
    }

    public Bill(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    
}
