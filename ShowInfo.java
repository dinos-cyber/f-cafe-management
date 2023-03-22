/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author npthi
 */
public class ShowInfo {
   
    private String name;
    private int price;
    private int stock;

    public ShowInfo() {
    }

    public ShowInfo(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void showInfo() {
        System.out.printf("|%-20s|%-10s|%5s|\n",getName(),getPrice(),getStock());
    }
    
}

