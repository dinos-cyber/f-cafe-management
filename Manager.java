/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ssg_main_controller;

import java.util.ArrayList;
import java.util.Scanner;
import project_ssg_main_controller.WareHouse;

/**
 *
 * @author aleno
 */
//Manager se dong vai tro la 1 ArrayList chua nhan vien va tuong tac
public class Manager extends ArrayList<Staff> implements IInteract_WareHouse_Manager{
    private Scanner sc = new Scanner(System.in);
    //Khai bao Warehouse(Kho) de su dung ware house nhu noi co the chua hang, ho tro manager nhap hang cung nhu ho tro khach hang xem hang thong qua doi tuong Manager
    private static WareHouse warehouse = new WareHouse();
    public static int Revenue = 0;

    public void showWareHouse()
    {
        warehouse.showGoodList();
    }
    
    //Them 1 nhan vien moi vao( note: luong cua full-time la 20.000/h, part-time la 15.000/h, dieu chinh o dong 51 va 55.
    //Mac dinh ban dau khi them moi nhan vien so co so gio lam(Hour) la 0.
    public void addStaff()
    {
        System.out.print("Enter Name of your new staff: ");
        String name = sc.nextLine();
        System.out.print("Enter year of birth for your staff: ");
        int birth = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter gender for your staff: ");
        String gender = sc.nextLine();
        System.out.print("Enter your staff's place: ");
        String place = sc.nextLine();  
        String kind;
        while(true)
        {
          System.out.print("What kind of Staff is it? Full-Time or Part-Time: ");
          kind = sc.nextLine();
          if(kind.toLowerCase().contains("full") || kind.toLowerCase().contains("part")) break;
          else System.out.println("You must enter Full or Part Time job, Bro!");
        }
        
        if(kind.toLowerCase().contains("full"))
        {
            this.add(new FullTime(name, birth, gender, place, 20000, 0));
        }
        else
        {
            this.add(new PartTime(name, birth, gender, place, 15000, 0));
        }
    }
    
    // ham de cham cong, co the cap nhat thoi gian lam viec cho nhan vien.
    // doi voi full-time: moi lan su dung se tu dong cap nhat them 8h.
    // doi voi part-time: moi lan su dung phai nhap vao 1 so luong gio lam cu the( 7>=hour>=1)
    public void Timekeeping()
    {
        for (Staff x : this) {
            if(x instanceof FullTime) ((FullTime) x).showInfo();
            else if(x instanceof PartTime) ((PartTime) x).showInfo();
        }
        String findName;
        while(true)
        {
            boolean check=true;
            System.out.println("Enter the name of Staff that you want to TimeKeeping: ");
            findName=sc.nextLine();
            for (Staff x : this) {
                if(x.getName().toLowerCase().equals(findName.toLowerCase()));
                {
                    check=false;
                    if(x instanceof FullTime)
                    System.out.printf("Your staff have worked %d hour\n"
                                     +"You will update 8 more hours for your staff!\n"
                                     +"Updated successful!!\n",((FullTime) x).getHour());
                    else if(x instanceof PartTime)
                    {
                    System.out.printf("Your staff have worked %d hour\n"
                                     +"How much time you want to add?(note:your hour must less than 8) ",((PartTime) x).getHour());
                    int addHour = sc.nextInt();
                    sc.nextLine();
                    System.out.printf("You will update %d more hours for your staff!\n", addHour);
                    ((PartTime) x).setHour(((PartTime) x).getHour()+addHour);
                    System.out.println("Updated successful!!");
                    }
                   
                    break;
                }
            }
            if(check==false) break;
        }
    }
    
    // xoa bo 1 nhan vien theo Ten( String ) nhap vao.
    public int RemoveStaff()
    {
       for (int i = 0; i < this.size(); i++) {
           System.out.printf("%d %s\n",i+1,this.get(i).toString());
       }   
           while(true)
          {
           System.out.println("Do you want to remove any staff from you store? Y/N");
           String answer = sc.nextLine();
           if(answer.equalsIgnoreCase("n")) return 0;
           else if(answer.equalsIgnoreCase("y")) break;
           else 
           {
               System.out.println("Sorry, Please enter 'Y' or 'N'!");
           }     
          }
        
         System.out.println("Please enter the ID number of the staff that you want to remove: ");
         int index = sc.nextInt();
         sc.nextLine();
         this.remove(this.get(index));
         return 1;
    }

    //Nhap mot loai hang hoa moi vao kho( Warehouse ), co kiem tra neu loai hang da nhap co ton tai trong kho.
    @Override
    public void import_goods() {
        String productName;
        while(true)
        {
        boolean check=true;
        System.out.print("Please enter the name of product you want to import to the WareHouse: ");
        productName = sc.nextLine();
            for (Goods x : warehouse) {
                if(x.getGoodsName().equals(x))
                {
                    check=false;
                    break;
                }
            }
            if(check==false) System.out.println("This Product is already exist!!");
            else break;
        }
        
        System.out.print("Please enter the price for your product: ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("Please enter the the stock of product you want to import: ");
        int stock = sc.nextInt();
        sc.nextLine();
        warehouse.add(new Goods(productName, price, stock));
        System.out.println("You have updated product in your warehouse successfuly");
    }
    
    //hang tra luong cho nhan vien, se in ra 1 cau cho bt so tien phai tra cho nhan vien va return gia tri do de ham Income su dung.
    public int paySalary()
    {
        int Salary = 0;
        for (Staff x : this) {
            if(x instanceof FullTime) Salary += (((FullTime) x).getSalary()*((FullTime) x).getSalary());
            else if(x instanceof PartTime ) Salary += (((PartTime) x).getSalary()*((PartTime) x).getSalary());
        }
        System.out.printf("You have to pay $%d for your staff!!\n", Salary);
        return Salary;
    }

    public void showRevenue()
    {
        System.out.println(Revenue);
    }
    //cap nhat Revenu( Doanh thu ) moi lan co hoa don dc thanh toan.
    public void updateRevenue(int Money)
    {
        Revenue+=Money;
    }
    //ham tinh loi nhuan, co in ra so tien Doanh thu ( Revenue ) va so Tien phai chi cho tra luong ( paySalary ).
    //In ra tong thu nhap ( Income ) bang cach lay Doanh thu ( Revenue ) tru cho ( - ) tien luong tra nhan vien ( paySalary ).
    public void Income()
    {
        System.out.printf("You have earn $%d from Revenue\n", Revenue);
        int Salary = paySalary();
        System.out.printf("So, Your total income is: $%d - $%d = $%d",Revenue,paySalary(),Revenue-Salary);
    }
    
    
}
