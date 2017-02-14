
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sriram
 */
public class Author {
    
   
    Scanner inp = new Scanner(System.in);
    
    

    public static void main(String args[])
    {
        aut();
    }
    public static void aut()
    {
        Author ob= new Author();
        Scanner inp = new Scanner(System.in);
        db obj = new db();
        obj.DBCon();

        int ch=0;
    System.out.println("Enter your choice:");
    System.out.println("1.Add author");
    System.out.println("2.Edit the details of authors");
    System.out.println("3.Add titles to a specific author");
    System.out.println("4.Exit");
    ch=inp.nextInt();
    switch(ch)
    {
        case 1:
        {
            obj.add_author();
            
        }
        break;
        
        case 2:
        {
            obj.edit_author();
            
        }
        break;
        
        case 3:
        {
            obj.add_title();
            
        }
        break;
        
        
    }
    
        int c=inp.nextInt();
        if(c==1)
        {
            aut();
        }
    
}
}
    
   
    
    
   

  
