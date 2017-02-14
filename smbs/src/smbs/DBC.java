/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smbs;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author sriram
 */
public class DBC {
    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    Scanner inp=new Scanner(System.in);
    
    int cnt=1;
    
    double tot=0;
    double tot_cus=0;

    
    public void DBCon()
    {        
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Super?zeroDateTimeBehavior=convertToNull","root","");
          st = con.createStatement();
        }
        catch(Exception ex){
            System.out.println("Error : "+ex);
        }
    }
    public void insert_prod()
    {
        try
        {
            System.out.println("Enter the Table No. you wanted to Insert");
            System.out.println("1.Sub");
            int ch=inp.nextInt();
            switch(ch)
            {
                case 1:
                {
                    System.out.println("Enter the new prod_code");
                    int pro_cod=inp.nextInt();
                    inp.nextLine();
                    System.out.println("Enter the Product name");
                    String pro_name=inp.next();
                    inp.nextLine();
                    System.out.println("Enter the new price");
                    double pri=inp.nextDouble();
                    inp.nextLine();
                    System.out.println("Enter the Stock");
                    int pro_stock=inp.nextInt();
                    inp.nextLine();
                    System.out.println("Enter the pro_detail");
                    String pro_detail=inp.next();
                    inp.nextLine();
                    System.out.println("Enter the min_stock");
                    int min_stock=inp.nextInt();
                    String query = "INSERT INTO Sub VALUES(?,?,?,?,?,?)";
                    pst = con.prepareStatement(query);
                    pst.setInt(1,pro_cod);
                    pst.setString(2,pro_name);
                    pst.setDouble(3,pri);
                    pst.setInt(4,pro_stock);
                    pst.setString(5,pro_detail);
                    pst.setInt(6,min_stock);
                    int suc;
                    suc=pst.executeUpdate();
                    if(suc==1)
                    {
                        System.out.println("1 Record Inserted Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to Insert Record");
                    }
                    pst.close();
                    break;
                }
            }
            con.close();
        }catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        
    }
    public void update_prod()
    {
       try
        {
            System.out.println("Enter the choice that you wanted to update");
            System.out.println("1.Product code 2.Product name 3.Price 4.Stock 5.Product Detail 6.Min Stock");
            int ch=inp.nextInt();
            inp.nextLine();
            switch(ch)
            {
                case 1:
                {  
                    System.out.println("Enter the Product name whose code has to be modified");
                    String prod_name=inp.next();
                    inp.nextLine();
                    System.out.println("Enter the new Product code");
                    int prod_cod = inp.nextInt();
                    String query = "Update Sub set pro_code=? where pro_name=?";
                    pst=con.prepareStatement(query);
                    pst.setInt(1,prod_cod);
                    pst.setString(2,prod_name);
                    int suc;
                    suc=pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Updated Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to update Record");
                    }
                }
                pst.close();
                break;
                case 2:
                {
                    System.out.println("Enter the Product code whose name has to be modified");
                    int prod_cod = inp.nextInt();
                    System.out.println("Enter the new Product code");
                    
                    String prod_name=inp.next();
                    inp.nextLine();

                    String query = "Update Sub set pro_name=? where pro_code=?";
                    pst=con.prepareStatement(query);
                    pst.setInt(2,prod_cod);
                    pst.setString(1,prod_name);
                    int suc;
                    suc=pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Updated Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to update Record");
                    }
                }
                pst.close();
                break;
                
                case 3:
                {
                    System.out.println("Enter the Product code whose Price has to be modified");
                    int prod_cod = inp.nextInt();
                    System.out.println("Enter the new Product Price");
                    
                    double price=inp.nextDouble();
                  
                    String query = "Update Sub set price=? where pro_code=?";
                    pst=con.prepareStatement(query);
                    pst.setInt(2,prod_cod);
                    pst.setDouble(1,price);
                    int suc;
                    suc=pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Updated Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to update Record");
                    }
                }
                pst.close();
                break;
                case 4:
                {
                    System.out.println("Enter the Product code whose Stock has to be modified");
                    int prod_cod = inp.nextInt();
                    System.out.println("Enter the new Product stock");
                    
                    int pro_sto = inp.nextInt();
                    
                    String query = "Update Sub set stock=? where pro_code=?";
                    pst=con.prepareStatement(query);
                    pst.setInt(2,prod_cod);
                    pst.setInt(1,pro_sto);
                    int suc;
                    suc=pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Updated Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to update Record");
                    }
                
                }
                pst.close();
                break;
                
                case 5:
                {
                    System.out.println("Enter the Product code whose product detail has to be modified");
                    int prod_cod = inp.nextInt();
                    System.out.println("Enter the new Product Detail");
                    
                    String pro_det = inp.next();
                    inp.nextLine();
                    
                    String query = "Update Sub set prod_deal=? where pro_code=?";
                    pst=con.prepareStatement(query);
                    pst.setInt(2,prod_cod);
                    pst.setString(1,pro_det);
                    int suc;
                    suc=pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Updated Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to update Record");
                    }
                }
                pst.close();
                break;
                
                case 6:
                {
                    System.out.println("Enter the Product code whose product min stock has to be modified");
                    int prod_cod = inp.nextInt();
                    System.out.println("Enter the new Product min stock");
                    
                    int min_sto = inp.nextInt();                    
                    String query = "Update Sub set min_stock=? where pro_code=?";
                    pst=con.prepareStatement(query);
                    pst.setInt(2,prod_cod);
                    pst.setInt(1,min_sto);
                    int suc;
                    suc=pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Updated Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to update Record");
                    }
                }
                pst.close();
                break;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error : "+ex);
        }
    }
    public void delete_prod()
    {
        try
        {
            System.out.println("Enter the choice that you wanted to Delete");
            System.out.println("1.Product code 2.Product name 3.Product detail");
            int ch=inp.nextInt();
            inp.nextLine();
            switch(ch)
            {
                case 1:
                {
                    String query = "Delete from sub where pro_code=?";
                    pst=con.prepareStatement(query);
                    System.out.println("Enter the product code to be deleted");
                    int pro_code = inp.nextInt();
                    pst.setInt(1,pro_code);
                    int suc;
                    suc = pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Deleted Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to delete Record");
                    }
                    pst.close();
                    con.close();
                    
                }
                break;
                
                case 2:
                {
                    String query = "Delete from sub where pro_name=?";
                    pst=con.prepareStatement(query);
                    System.out.println("Enter the product name to be deleted");
                    String pro_name=inp.next();
                    inp.nextLine();
                    
                    pst.setString(1,pro_name);
                    int suc;
                    suc = pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Deleted Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to delete Record");
                    }
                    pst.close();
                    con.close();
                    
                }
                break;
                
                case 3:
                {
                    String query = "Delete from sub where prod_deal=?";
                    pst=con.prepareStatement(query);
                    System.out.println("Enter the product detail to be deleted");
                    String pro_det=inp.next();
                    inp.nextLine();
                    pst.setString(1,pro_det);
                    int suc;
                    suc = pst.executeUpdate();
                    if(suc>=1)
                    {
                        System.out.println(suc+" Record Deleted Successfully");
                    }
                    else
                    {
                        System.out.println("Unable to delete Record");
                    }
                    pst.close();
                    con.close();
                    
                }
                break;
            }
        }catch(Exception ex)
        {
            System.out.println("Error : "+ex);
        }
    }
    
    public void del_bill()
    {
        try{
            String query="Delete from Bill ";
            pst=con.prepareStatement(query);
            pst.executeUpdate();
            
        }catch(Exception e)
        {
            
        }
    }
    
    public void bill()
    {
        

        
        int cus=0;
        System.out.println("---  Welcome to Billing Counter  ---");
        System.out.println("         ******************* ");
        try{
            System.out.println("1.New Customer 2.Existing Customer");
            cus=inp.nextInt();
            switch(cus)
            {
                case 1:
                {
                    System.out.println("Enter the Customer Name");
                    String cus_name=inp.next();
                    inp.nextLine();
                    System.out.println("Enter the Mobile Num");
                    String mob_num=inp.next();
                    inp.nextLine();
                    String query="INSERT INTO Customer VALUES(?,?,?,?)";
                    pst=con.prepareStatement(query);
                    pst.setString(1,cus_name);
                    pst.setString(2,mob_num);
                    pst.setInt(3, 0);
                    pst.setDouble(4, 0);
                    pst.executeUpdate();
                    billing();
                    String queryy="Update Customer set No_of_pur=?, Bill_amount=? where Cust_name=?";
                    pst=con.prepareStatement(queryy);
                    pst.setInt(1,cnt);
                    pst.setDouble(2, tot_cus);
                    pst.setString(3, cus_name);
                    pst.executeUpdate();
                    
                }
                pst.close();
                break;
                
                case 2:
                {
                    System.out.println("Enter Customer name");
                    String cus_name=inp.next();
                    inp.nextLine();
                    billing();
                    String queryy="Update Customer set No_of_pur=?, Bill_amount=? where Cust_name=?";
                    pst=con.prepareStatement(queryy);
                    pst.setInt(1,cnt);
                    pst.setDouble(2, tot_cus);
                    pst.setString(3, cus_name);
                    pst.executeUpdate();
                    
                    
                }
                pst.close();
                break;
            }
            
        }catch(Exception e)
        {
            System.out.println("Exception"+e);
        }
    }
    
        
    public void billing()
    {
        int cou=1;
        cnt=0;
       

        do{
            
        
        try
        {
            System.out.println("");
            System.out.println("Enter the choice to process Bill");
            
            System.out.println("1.Product Code 2.Product Name ");
            int ch=inp.nextInt();
            cnt++;
            
            switch(ch)
            {
                case 1:
                {
                    
                    System.out.println("Product code?");
                    int pro_code=inp.nextInt();
                    System.out.println("Enter the quantity");
                    int pro_quan=inp.nextInt();
                    String querys = "Select * from sub where pro_code=?";
                    pst=con.prepareStatement(querys);
                    pst.setInt(1, pro_code);
                    rs = pst.executeQuery();
                    while(rs.next())
                    {
                    String pro_name= rs.getString("pro_name");
                    double price = rs.getDouble("price");
                    int stock = rs.getInt("stock");
                    int sto_upd = stock - pro_quan;
                    tot=0;
                    tot=tot+(price*pro_quan);
                    System.out.println("");
                    System.out.println(pro_name+"\t\t"+pro_quan+"\t\t"+tot);
                    //pst.close();
                    String queryy = "INSERT INTO Bill VALUES(?,?,?,?,?)";
                    pst = con.prepareStatement(queryy);
                    pst.setInt(1,pro_code);
                    pst.setString(2,pro_name);
                    pst.setDouble(3,price);
                    pst.setDouble(4,tot);
                    pst.setInt(5, pro_quan);
                    pst.executeUpdate();
                    
                    String queryyy="Update sub set stock=? where pro_code=?";
                    pst=con.prepareStatement(queryyy);
                    pst.setInt(1, sto_upd);
                    pst.setInt(2, pro_code);
                    pst.executeUpdate();
                    
                    tot_cus+=tot;
                    

                    
                    }
                }
                pst.close();
                st.close();
                break;
                
                case 2:
                {
                    System.out.println("Product Name?");
                    String pro_name=inp.next();
                    inp.nextLine();
                    System.out.println("Enter the quantity");
                    int pro_quan=inp.nextInt();
                    String querys = "Select * from sub where pro_name=?";
                    pst=con.prepareStatement(querys);
                    pst.setString(1, pro_name);
                    rs = pst.executeQuery();
                    while(rs.next())
                    {
                        int pro_code= rs.getInt("pro_code");
                    double price = rs.getDouble("price");
                    int stock = rs.getInt("stock");
                    int sto_upd = stock - pro_quan;
                    tot=0;
                    tot=tot+(price*pro_quan);
                    System.out.println("");
                    System.out.println(pro_name+"\t\t"+pro_quan+"\t\t"+tot);
                    //pst.close();
                    String queryy = "INSERT INTO Bill VALUES(?,?,?,?,?)";
                    pst = con.prepareStatement(queryy);
                    pst.setInt(1,pro_code);
                    pst.setString(2,pro_name);
                    pst.setDouble(3,price);
                    pst.setDouble(4,tot);
                    pst.setInt(5, pro_quan);
                    pst.executeUpdate();
                    
                    String queryyy="Update sub set stock=? where pro_code=?";
                    pst=con.prepareStatement(queryyy);
                    pst.setInt(1, sto_upd);
                    pst.setInt(2, pro_code);
                    pst.executeUpdate();
                    
                    tot_cus+=tot;
                    

                    
                    }
                

                }
            }
        }catch(Exception e)
        {
            System.out.println("Exception :"+e);
        }
        System.out.println("To continue Billing press 1 else 0");
        cou=inp.nextInt();
        }while(cou==1);
        

    }
    
    
}