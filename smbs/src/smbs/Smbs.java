/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smbs;
import java.util.*;

/**
 *
 * @author sriram
 */
public class Smbs {

    
    public static void main(String[] args) {
        
        System.out.println("--- Welcome to Super maket ---");
        sumbs();
        
        
        
    }
    public static void sumbs()
    {
        Scanner sc=new Scanner(System.in);
        DBC conn=new DBC();
        conn.DBCon();
        System.out.println("What Operation would you like to perform");
        System.out.println("1.Insert  2.Update  3.Delete  4.Bill");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
            {
                conn.insert_prod();
                break;
            }
            case 2:
            {
                conn.update_prod();
                break;
            }
            case 3:
            {
                conn.delete_prod();
                break;
            }
            case 4:
            {
                conn.bill();
                break;
            }
            default:
                System.out.println("Enter correct choice:");
                break;
                
        }
        System.out.println();
        System.out.println("Would you like to perform any other operation");
        System.out.println("If Yes Enter 1 else Enter 0");
        int c=sc.nextInt();
        if(c==1)
        {
            sumbs();
        }
        else if(c==0){
            conn.del_bill();
        }
    }
    
}
