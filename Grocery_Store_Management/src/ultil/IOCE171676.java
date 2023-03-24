/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;

import java.util.Scanner;

/**
 *
 * @author aleno
 */
public class IOCE171676 {
    
    static Scanner sc = new Scanner(System.in);
    public static int getInteger(String iMsg,String iErr) {
        while(true)
        {
          try {
              System.out.print(iMsg);
             int a = Integer.parseInt(sc.nextLine());
             return a;
              } catch (Exception e) {
            System.out.println(iErr);
              
        }
     }
}
    //OVERLOAD
    public static int getInteger(String iMsg,String iErr, int start, int end) {
        
        if(start>end)
        {
            int tmp = start;
            start = end;
            end = tmp;
        }
        while(true)
        {
          try {
              System.out.print(iMsg);
              int a = Integer.parseInt(sc.nextLine());
              if(a < start || a > end)
              {
                  throw new Exception();
              }
              return a;
        } catch(Exception e){
              System.out.println(iErr);
        }
     }
}
    
    public static double getDouble(String iMsg,String iErr){
      while(true) 
      {
        try {
            System.out.print(iMsg); 
            double a = Double.parseDouble(sc.nextLine());
            return a;
        } catch(Exception e)
        {
            System.out.println(iErr);
        }
    }
    }
    
    public static double getDouble(String iMsg,String iErr, double start, double end)  {
       if(start > end)
    {
        double tmp = start;
        start = end;
        end = tmp;
    }
       while(true)
       {
       try{
           System.out.print(iMsg);
           double a = Double.parseDouble(sc.nextLine());
           if( a < start || a > end)
           {
               throw new Exception();
           }
           return a;
       } catch(Exception e)
       {
           System.out.println(iErr);
       }
       }
    }
    
    public static String getString(String iMsg,String iErr){
        while(true)
        {
            try{
                System.out.print(iMsg);
                String s = sc.nextLine();
                if(s.length()==0){
                    throw new Exception();
                }
                return s;
            }catch(Exception e)
            {
                System.out.println(iErr);
            }
        }
    }
    
    public static String getString(String iMsg,String iErr, int t)
    {
        while(true)
        {
            try{
                System.out.print(iMsg);
                String s = sc.nextLine();
                if(s.length()<t){
                    throw new Exception();
                }
                return s;
            }catch(Exception e)
            {
                System.out.println(iErr);
            }
        }
    }
}
