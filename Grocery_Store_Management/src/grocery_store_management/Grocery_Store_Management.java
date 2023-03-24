/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery_store_management;

import java.util.Scanner;
import grocery_store_management.Manager;
import ultil.IOCE171676;
import grocery_store_management.Customer;
/**
 *
 * @author aleno
 */
public class Grocery_Store_Management {
 
    public static Manager manager = new Manager();
    
    public static void MenuRolePlay()
    {
        System.out.println("Menu\n"
                         + "1.Manager\n"
                         + "2.Customer\n"
                         + "3.Quit");         
        
        System.out.print("Enter option: ");
    }
    
    public static void MenuManager()
    {
        System.out.println("Manager\n"
                         + "1.Add New Staff\n"
                         + "2.Add New Product\n"
                         + "3.Timekeeping\n"
                         + "4.Show WareHouse\n"
                         + "5.Show All Satff\n"
                         + "6.Sort Product\n"
                         + "7.Set Stock\n"
                         + "8.Quit\n");
        System.out.print("Enter option: ");
    }
    
    public static void MenuCustomer()
    {
        System.out.println("Customer\n"
                         + "1.Buy\n"
                         + "2.View Cart\n"
                         + "3.Pay\n");

        System.out.print("Enter option: ");
    }
    public static void Run()
    {
       int option;
       while(true)
       {
           MenuRolePlay();
           option = IOCE171676.getInteger("", "Invalid, must be from 1 to 3", 1, 3);
           if(option==1)
           {
              int option_Man;
              while(true)
              {
                MenuManager();
                option_Man=IOCE171676.getInteger("", "Invalid", 1, 8);
                if(option_Man==1)
                {
                    manager.addStaff();
                }
                else if(option_Man==2)
                {
                    manager.AddnewProduct();
                }
                else if(option_Man==3)
                {
                    manager.Timekeeping();
                }
                else if(option_Man==4)
                {
                    manager.showWareHouse();
                }
                else if(option_Man==5)
                {
                    manager.showStaff();
                }
                else if(option_Man==6)
                {
                    manager.sort();
                }
                else if(option_Man==7)
                {
                    manager.setStock();
                }
                else if(option_Man==8) break;
              }
           }
           else if(option==2)
           {
               Customer customer = new Customer();
               boolean checkout=true;  
               System.out.print("Could you please enter your name so that we can check that you are VIP or not: "); 
               String name = IOCE171676.getString("", "Invalid");
               boolean check;
               if(customer.checkVIP(name)==true)
               {
                   check=true;
                   System.out.println("Cool, You are our VIP, you bill will get 10% discount");
               }else
               {
                   check=false;
                   System.out.println("Oh sorry, look like you just a normal Customer...");
               }
               int option_Cus;
               while(true)
               { 
                 MenuCustomer();
                 option_Cus=IOCE171676.getInteger("", "Invalid, must be from 1 to 3", 1, 3);       
                 if(option_Cus==1)
                 {
                     customer.showWareHouse();
                     customer.buyProduct();
                 }
                 else if(option_Cus==2)
                 {
                     customer.viewCart();
                 }
                 else if(option_Cus==3)
                 {
                     System.out.println("You have paid for your Product");
                     System.out.println("This is your bill");
                     customer.payForProduct(check);
                     break;
                 } 
               }
               
           }
           else if(option==3) break;
       }
        System.out.println("Thank You for using our Application.We very apreciate that..."
                         + "See you Again <33!!");
    }
    
    public static void main(String[] args) {
       Run();
    }
    
}
