/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery_store_management;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import grocery_store_management.Cart;

/**
 *
 * @author aleno
 */
public class Customer extends Person implements ICustomer{
    
    private static ArrayList<Customer> cs = new ArrayList<>();
    private static Scanner su = new Scanner(System.in);
    private static WareHouse warehouse = new WareHouse();
    Bill bill = new Bill();
    Cart cart = new Cart();
     {
        try{
            Scanner so = new Scanner(new File("WareHouse.txt"));
            Scanner scv = new Scanner("Customer.txt");
            Scanner sv = new Scanner("Bill.txt");
            while(scv.hasNextLine())
            {
                String s = scv.nextLine();
                String[] arr = s.split("\\s+");
                String cusname = "",type="";
                int year,index=0;
                for(int i=0;i<arr.length;++i)
                {
                    if(Character.isDigit(arr[i].charAt(0)))
                    {
                        index=i;
                        break;
                    }
                    else cusname += (arr[i]+" ");
                }
                year = Integer.parseInt(arr[index]);
                type += arr[index+1];
                cs.add(new Customer(cusname, year, type));
            }
            scv.close();
            while(sv.hasNextLine())
            {
                String v = sv.nextLine();
                float money = Float.parseFloat(v);
                bill.add(new Bill((int) money));
            }
            sv.close();
             while(so.hasNextLine())
            {
             String k = so.nextLine();
             String[] avv = k.split("\\s+");
             String name = "";
             int price,stock;
             int index=0;
             for(int i=0;i<avv.length;++i)
             {
                 if(Character.isDigit(avv[i].charAt(0)))
                 {
                     index=i;
                     break;
                 }
                 else name += (avv[i]+" ");
             }
             price = Integer.parseInt(avv[index]);
             stock = Integer.parseInt(avv[index+1]);
             warehouse.add(new Product(name.trim(), price, stock));
             }
          so.close();
        }catch(Exception e){
        }
        
    }
    
    private String type;

   
    public Customer() {
    }

    
    public Customer(String Name, int Yob,String type) {
        super(Name, Yob);
        this.type = type;
    }
    
    
    public void showWareHouse()
    {
        warehouse.showWareHouse();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public boolean checkVIP(String iname)
    {
        for (Customer x : cs) {
            if(x.getName().toLowerCase().equalsIgnoreCase(iname))
            {
                if(x.getType().equalsIgnoreCase("vip")) return true;
            }
        }
        return false;
    }
    @Override
    public void buyProduct() {
        int number;
        String name;
        System.out.print("Please enter name of product that you want to add to Cart: ");
        name = su.nextLine();
        if (warehouse.searchProductByName(name)==false) {
            System.out.println("This product does not exsits");
        } else {
            //if(bill.contains(bill.getName().equalsIgnoreCase(name)))
            while(true) {
                System.out.println("Enter number of product that you want to buy");
                number = su.nextInt();
                if(this.warehouse.checkStock(name, number))
                {
                    cart.addtoCart(name, number);
                    break;
                } else {
                    System.out.printf("Product named '%s' only have %d left, make sure you enter number below or equal %d\n",name,warehouse.searchProductObjectByName(name).getStock()
                        ,warehouse.searchProductObjectByName(name).getStock());
                }
            }  
            }
    }
    
    @Override
    public void payForProduct(boolean check) {
        float moneyPay = 0;
        for (Cart x : cart) {
                moneyPay += warehouse.searchProductObjectByName(x.getName()).getPrice()*x.getNumber();
                warehouse.updateStock(x.getName(), x.getNumber());
            }
          if(check==true)  
          {
              moneyPay*=(0.9);
          } 
           warehouse.toFile();
         System.out.println("Total: "+moneyPay);
          
         bill.add(new Bill((int)moneyPay));
         try{
             FileWriter fk = new FileWriter("Bill.txt");
             for (Bill x : bill) {
                 fk.write((int) x.getMoney());
             }
             fk.close();
         }catch(Exception e){   
         }
        cart.clear();
        }
    
     @Override
    public void viewCart() {
        System.out.println("------Your Cart------");
        if(cart.isEmpty()) System.out.println("Your Cart is Empty!!!");
        for (Cart x : cart) {
            System.out.printf("|%-15s|%-10d|%-10d|\n", x.getName(),warehouse.searchProductObjectByName(x.getName()).getPrice(),x.getNumber());
        }
       }

}
    

   
