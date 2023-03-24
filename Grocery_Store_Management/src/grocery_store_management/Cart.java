/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery_store_management;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author aleno
 */
public class Cart extends ArrayList<Cart> {
    private String name;
    private int number;  
    
    public Cart() {
    }

    public void addtoCart(String iname, int inumber)
    {
        this.add(new Cart(iname, inumber));
    }
    public Cart(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

 
    
}
