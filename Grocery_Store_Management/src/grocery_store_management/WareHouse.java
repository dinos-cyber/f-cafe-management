/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery_store_management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import grocery_store_management.Product;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author aleno
 */
public class WareHouse extends ArrayList<Product> {
    private static Scanner sc = new Scanner(System.in);
    
    {
        try{
         Scanner sw = new Scanner(new File("WareHouse.txt"));
         while(sw.hasNextLine())
         {
             String k = sw.nextLine();
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
             this.add(new Product(name.trim(), price, stock));
         }
          sw.close();
       }
         catch(Exception e1){
                 
          }
    }
    public WareHouse(){
        
    }
    
    public boolean searchProductByName(String name) {
        for (Product x : this) {
            if (x.getName().equalsIgnoreCase(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    public void addProduct() {
        boolean check=false;
        String name;
        System.out.println("----- Add Product -----");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter name for Product you want to add to your WareHouse: ");
            name = sc.nextLine();
            check = searchProductByName(name.toLowerCase());
            if (check == true) {
                System.out.println("This Product already exists in your WareHouse, Please enter other Product name...\n");
            }
        } while (check == true);
        System.out.print("Enter price for your Product: ");
        int price = sc.nextInt();
        System.out.print("Please enter the number of Product you want to import: ");
        int stock = sc.nextInt();
        this.add(new Product(name, price, stock));
        System.out.println("New Product is added to your WareHouse");
    }

    

    public void updateStock(String name, int number)
    {
        if(searchProductObjectByName(name)!=null)
        {
            int amount = searchProductObjectByName(name).getStock();
            searchProductObjectByName(name).setStock(amount-number);
        }
    }
    public boolean checkStock(String name, int number) {
        if (searchProductObjectByName(name) != null) {
            if(searchProductObjectByName(name).getStock() >= number)
            {
                return true;
            }
        } else {
            System.out.println("Not have enough stock of this product!");
        }
        return false;
    }

    public Product searchProductObjectByName(String name) {
        for (Product x : this) {
            if (x.getName().equalsIgnoreCase(name.toLowerCase())) {
                return x;
            }
        }
        return null;
    }

    public void sortProductByFirstLetter() {
        Collections.sort(this, new Comparator<Product>() {
            @Override
            public int compare(Product t1, Product t2) {
                return t1.getName().charAt(0)-t2.getName().charAt(0);
            }
        });
    }

    public void showWareHouse() {
        System.out.printf("|%-15s|%-10s|%-10s|\n", "Product Name", "Price", "Stock");
        for (Product x : this) {
            x.showInfo();
        }
    }
    
    public void toFile()
    {
        try{
            FileWriter fh = new FileWriter("WareHouse.txt");
            for (Product x : this) {
                fh.write(x.getName()+" "+x.getPrice()+" "+x.getStock()+"\n");
            }
            fh.close();
        }catch(Exception e){  
        }
    }

    public void setStock() {
        System.out.print("Enter name of Product that you want to change its Stock: ");
        String reStockTen = sc.nextLine();
        if (searchProductObjectByName(reStockTen) != null) {
            System.out.print("Enter the number you want to change for this Product: ");
            int reStock = sc.nextInt();
            sc.nextLine();
            searchProductObjectByName(reStockTen).setStock(reStock);
        } else {
            System.out.println("This Product is not exsits in your WareHouse!");
        }
    }
    
}
