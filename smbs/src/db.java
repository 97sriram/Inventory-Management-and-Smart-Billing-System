
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
public class db {
     private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    Scanner inp = new Scanner(System.in);
    public void DBCon()
    {        
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Author?zeroDateTimeBehavior=convertToNull","root","");
          st = con.createStatement();
        }
        catch(Exception ex){
            System.out.println("Error : "+ex);
        }
    }
    
    public void add_author()
    {
         String name,award,title;
        try{
            System.out.println("Enter the name of the auhtor:");
        name = inp.next();
        inp.nextLine();
        System.out.println("Enter the name of awards:"); 	 
                award = inp.next();
        inp.nextLine();
 	System.out.println("Enter the name of the title:"); 
        title = inp.next();
        inp.nextLine();
        String query = "Insert into author values(?,?,?)";
        pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, award);
        pst.setString(3, title);
        pst.executeUpdate();
        }catch(Exception e)
        {
            System.out.println("Exception" +e);
        }
    }
    
    public void edit_author()
    {
        String name,award,title;
        try{
System.out.println("Enter the name of the author whose title you want to modify:"); 
name = inp.next();
            inp.nextLine();
 	 	 	 	System.out.println("Enter the new awards secured by author"); 
                                award = inp.next();
            inp.nextLine();
            
            String query="Update author set awards=? where author=?";
            pst=con.prepareStatement(query);
            pst.setString(1, award);
            pst.setString(2,name);
            pst.executeUpdate();
        }catch(Exception e)
        {
           

            
        }
    }
    
    public void add_title()
    {
        String name,award,title;
        try{
System.out.println("Enter the name of the author whose title you want to modify:");  
name = inp.next();
            inp.nextLine();
System.out.println("Enter the new title:"); 
title = inp.next();
System.out.println("Title added..."); 
            inp.nextLine();
            String query="Update author set titles=? where author=?";
            pst=con.prepareStatement(query);
            pst.setString(1,title);
            pst.setString(2,name);
            pst.executeUpdate();
        }
        catch(Exception e)
        {
            

            
        }

    }
    
}
