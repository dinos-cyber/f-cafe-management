/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery_store_management;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aleno
 */
public class Manager extends ArrayList<Staff> {
    
     private static Scanner sc = new Scanner(System.in); 
    //Khai bao Warehouse(Kho) de su dung ware house nhu noi co the chua hang, ho tro manager nhap hang cung nhu ho tro khach hang xem hang thong qua doi tuong Manager
    private static WareHouse warehouse = new WareHouse();
    private static float Revenue = 0;

    {              
         
         try
         {
         Scanner scstaff = new Scanner(new File("Staff.txt"));
         while(scstaff.hasNextLine())
         {
             String s = scstaff.nextLine();
             String[] arr = s.split("\\s+");
             int index = 0;
             String name = "",gender="",place="",type="";
             int yob,salary,hour;
             for(int i=0;i<arr.length;++i)
             {
                 if(arr[i].equalsIgnoreCase("male")||arr[i].equalsIgnoreCase("female"))
                 {
                     index=i;
                     break;
                 }
                 else name += (arr[i]+" ");
             }
             gender += arr[index];
             for (int i=index+1;i<arr.length;++i) {
                 if(Character.isDigit(arr[i].charAt(0)))
                 {
                     index=i;
                     break;
                 }
                 else place += (arr[i]+" ");
             }
             yob = Integer.parseInt(arr[index]);
             salary = Integer.parseInt(arr[index+1]);
             hour = Integer.parseInt(arr[index+2]);
             type += arr[index+3];
             if(type.equalsIgnoreCase("fulltime")) this.add(new FullTime(name.trim(), gender, place.trim(), yob, salary, hour));
             else if(type.equalsIgnoreCase("parttime")) this.add(new PartTime(name.trim(), gender, place.trim(), yob, salary, hour));
         }        
         scstaff.close();
       }catch(Exception e){
       }
        
    }
    public void showWareHouse()
    {
        warehouse.showWareHouse();
    }
    
    //Them 1 nhan vien moi vao( note: luong cua full-time la 20.000/h, part-time la 15.000/h, dieu chinh o dong 51 va 55.
    //Mac dinh ban dau khi them moi nhan vien so co so gio lam(Hour) la 0.
    public void addStaff()
    {
        System.out.print("Enter Name of your new staff: ");
        String name = sc.nextLine();
        System.out.print("Enter gender for your staff: ");
        String gender = sc.nextLine();
        System.out.print("Enter year of birth for your staff: ");
        int birth = sc.nextInt();
        sc.nextLine();
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
            this.add(new FullTime(name, gender, place,birth, 20000, 0));
        }
        else
        {
            this.add(new PartTime(name, gender, place,birth, 15000, 0));
        }
        
        try{
            FileWriter f = new FileWriter("Staff.txt");
            for (Staff x : this) {
              if(x instanceof FullTime)
              {
                  f.write(x.getName()+" "+x.getGender()+" "+x.getPlace()+" "+x.getYob()+" "+((FullTime) x).getSalary()+" "+((FullTime) x).getHours()+" FullTime\n");
              }else if(x instanceof PartTime)
              {
                  f.write(x.getName()+" "+x.getGender()+" "+x.getPlace()+" "+x.getYob()+" "+((PartTime) x).getSalaryInHour()+" "+((PartTime) x).getHours()+" PartTime\n");
              }           
            }
            f.close();
        }catch(Exception E){
        }
    }
    
    // ham de cham cong, co the cap nhat thoi gian lam viec cho nhan vien.
    // doi voi full-time: moi lan su dung se tu dong cap nhat them 8h.
    // doi voi part-time: moi lan su dung phai nhap vao 1 so luong gio lam cu the( 7>=hour>=1)
    public void Timekeeping()
    {
        this.showStaff();
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
                    {
                    System.out.printf("Your staff have worked %d hour\n"
                                     +"You will update 8 more hours for your staff!\n"
                                     +"Updated successful!!\n",(int)((FullTime) x).getHours());
                    ((FullTime) x).setHours(8);
                    }
                    else if(x instanceof PartTime)
                    {
                    System.out.printf("Your staff have worked %d hour\n"
                                     +"How much time you want to add?(note:your hour must less than 8) ",(int)((PartTime) x).getHours());
                    int addHour = sc.nextInt();
                    sc.nextLine();
                    System.out.printf("You will update %d more hours for your staff!\n", addHour);
                    ((PartTime) x).setHours(((PartTime) x).getHours()+addHour);
                    System.out.println("Updated successful!!");
                    }
                   
                    break;
                }
            }
            if(check==false) break;
            try{
            FileWriter f = new FileWriter("Staff.txt");
            for (Staff x : this) {
              if(x instanceof FullTime)
              {
                  f.write(x.getName()+" "+x.getGender()+" "+x.getPlace()+" "+x.getYob()+" "+((FullTime) x).getSalary()+" "+((FullTime) x).getHours()+" FullTime\n");
              }else if(x instanceof PartTime)
              {
                  f.write(x.getName()+" "+x.getGender()+" "+x.getPlace()+" "+x.getYob()+" "+((PartTime) x).getSalaryInHour()+" "+((PartTime) x).getHours()+" PartTime\n");
              }
            }
            f.close();
        }catch(Exception E){
        }
        }
        
    }
    
    // xoa bo 1 nhan vien theo Ten( String ) nhap vao.
    public void RemoveStaff()
    {
       for (int i = 0; i < this.size(); i++) {
           System.out.printf("%d %s\n",i+1,this.get(i).toString());
       }          
         System.out.println("Please enter the ID number of the staff that you want to remove: ");
         int index = sc.nextInt();
         sc.nextLine();
         this.remove(this.get(index-1));
         try{
            FileWriter f = new FileWriter("Staff.txt");
            for (Staff x : this) {
              if(x instanceof FullTime)
              {
                  f.write(x.getName()+" "+x.getGender()+" "+x.getPlace()+" "+x.getYob()+" "+((FullTime) x).getSalary()+" "+((FullTime) x).getHours()+" FullTime\n");
              }else if(x instanceof PartTime)
              {
                  f.write(x.getName()+" "+x.getGender()+" "+x.getPlace()+" "+x.getYob()+" "+((PartTime) x).getSalaryInHour()+" "+((PartTime) x).getHours()+" PartTime\n");
              }
              
            }
            f.close();
        }catch(Exception E){
        }
    }

    //Nhap mot loai hang hoa moi vao kho( Warehouse ), co kiem tra neu loai hang da nhap co ton tai trong kho.
    
    public void AddnewProduct() {
        warehouse.addProduct();
        try{
            FileWriter fh = new FileWriter("WareHouse.txt");
            for (Product x : warehouse) {
                fh.write(x.getName()+" "+x.getPrice()+" "+x.getStock()+"\n");
            }
            fh.close();
        }catch(Exception e){  
        }
    }
    
    //hang tra luong cho nhan vien, se in ra 1 cau cho bt so tien phai tra cho nhan vien va return gia tri do de ham Income su dung.
    public int paySalary()
    {
        int Salary = 0;
        for (Staff x : this) {
            if(x instanceof FullTime) Salary += (((FullTime) x).getSalary()*((FullTime) x).getHours());
            else if(x instanceof PartTime ) Salary += (((PartTime) x).getSalaryInHour())*((PartTime) x).getHours();
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
        try{
         Scanner scbill = new Scanner(new File("Bill.txt"));
         while(scbill.hasNextInt())
         {
             float money = scbill.nextFloat();
             Revenue += money;
         }
          scbill.close();
         }catch(Exception e2){
             
         }

    }
    //ham tinh loi nhuan, co in ra so tien Doanh thu ( Revenue ) va so Tien phai chi cho tra luong ( paySalary ).
    //In ra tong thu nhap ( Income ) bang cach lay Doanh thu ( Revenue ) tru cho ( - ) tien luong tra nhan vien ( paySalary ).
    public void Income()
    {
        System.out.printf("You have earn $%.0f from Revenue\n", Revenue);
        int Salary = paySalary();
        System.out.printf("So, Your total income is: $%.0f - $%d = $%.0f\n",Revenue,paySalary(),Revenue-Salary);
    }
    public void sort()
    {
        warehouse.sortProductByFirstLetter();
        try{
            FileWriter fh = new FileWriter("WareHouse.txt");
            
            for (Product x : warehouse) {
                fh.write(x.getName()+" "+x.getPrice()+" "+x.getStock()+"\n");
            }
            fh.close();
        }catch(Exception e){  
        }
    }
    public void setStock()
    {
        warehouse.setStock();
    }
    public void showStaff()
    {
        for (Staff x : this) {
            if(x instanceof FullTime) ((FullTime) x).showInfo();
            else if(x instanceof PartTime) ((PartTime) x).showInfo();
        }
    }
   
}
