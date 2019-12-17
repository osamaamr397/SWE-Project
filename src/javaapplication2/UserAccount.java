/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author amr
 */
public class UserAccount implements Regist,Login{
    static int count=0;
    String username;
    private  String password;
    public UserAccount(String username, String password) {
    this.username = username;
    this.password = password;
}

  
    
    
    public boolean login(String username, String password) throws FileNotFoundException, IOException {
        
        //File users = new File("users.txt");
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        String row = reader.readLine();
        while(row != null) {
            String[] fields = row.split(" ");
            String currentUsername = fields[0];
            if(username.equals(currentUsername)) {
                String currentPassword = fields[1];
                if(password.equals(currentPassword)) {
                    return true;
                }
            }
            row = reader.readLine();
        }
        
        return false;
    }
    public boolean Register(String username, String password ) throws IOException{
    //FileWriter writer=new FileWriter(file, true);//true 3lshan my3mlsh overwrite yzod 3la s\el file
    BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
    String row = reader.readLine();
    while(row!=null){ 
        String[] fields=row.split(" ");
        String currentUsername=fields[0];
        if(username.equals(currentUsername)) {
            return false;
        }
        row = reader.readLine();
    }
    reader.close();
    PrintWriter writer = new PrintWriter(new FileWriter("users.txt", true));
    String newRow = username;
    newRow = newRow.concat(" ");
    newRow = newRow.concat(password);
    writer.println(newRow);
    writer.close();
    return true;
    }
    
    /*public boolean checkPassword()
    {

         return (username.equals(accounts[0][0])) && (password.equals(accounts[0][1]));
    }*/
    
    public Products search(String Pname) throws FileNotFoundException, IOException{ 
         count+=1;
  Integer intInstance = new Integer(count);      
String numberAsString = intInstance.toString();
        BufferedReader reader=new BufferedReader(new FileReader("products.txt"));
        String row=reader.readLine();
        while(row!=null){ 
        String[] fields=row.split(" ");
        String CurrentProduct=fields[0];
        if(Pname.equals(CurrentProduct)){
         System.out.println(row);
        }
        row=reader.readLine();
        }
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now(); 
        PrintWriter writer =new PrintWriter(new FileWriter("userstatisic.txt",true));
        String newRow=this.username;
        newRow = newRow.concat(" ");
        newRow=newRow.concat(Pname);
        newRow = newRow.concat(" ");
        newRow=newRow.concat(dtf.format(now));
         newRow = newRow.concat(" ");
        newRow=newRow.concat(numberAsString);
        writer.println(newRow);
    writer.close();
     PrintWriter writerR =new PrintWriter(new FileWriter("live.txt",true));
     String newRowr=this.username;
        newRowr = newRowr.concat(" ");
        newRowr=newRowr.concat(Pname);
        newRowr = newRowr.concat(" ");
         writerR.println(newRowr);
        writerR.close();
        return null;
    }
  
   public boolean Buy(String s,String numOfProd) throws FileNotFoundException, IOException{ 
   //File users = new File("users.txt");
        int number = Integer.parseInt(numOfProd);
     Products p=new Products (null,null,null,null,null);
     p.setPname(s);
        BufferedReader reader = new BufferedReader(new FileReader("products.txt"));
        String row = reader.readLine();
        while(row != null) {
            String[] fields = row.split(" ");
            String CurrentProduct=fields[0];
           String currentPrice=fields[1];
           String currentCat=fields[2];
           String currentBrand=fields[4];
             
            if(!s.equals(CurrentProduct)) {
            return false;
        }
        if(p.getPname().equals(CurrentProduct)){
             
            String currentQuant=fields[3];
            int QuantN=Integer.parseInt(currentQuant);
            if(QuantN>number){ 
                QuantN=QuantN-number;
                   String str1 = Integer.toString(QuantN); 

 PrintWriter writer = new PrintWriter(new FileWriter("products.txt"));
    String newRow = CurrentProduct;
    newRow = newRow.concat(" ");
    newRow = newRow.concat(currentPrice);
    newRow=newRow.concat(" ");
    newRow=newRow.concat(currentCat);
    newRow=newRow.concat(" ");
    newRow=newRow.concat(str1);
    newRow=newRow.concat(" ");
     newRow=newRow.concat(currentBrand);
    newRow=newRow.concat(" ");
    
    writer.println(newRow);
    writer.close();
    
     
     
            }
       
        }
            
            row = reader.readLine();
             int number1 = Integer.parseInt(numOfProd);
     int number2=Integer.parseInt(currentPrice);
     
     System.out.println("Total Price is "+(number1*number2));
        }
       reader.close();
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now(); 
        PrintWriter writer =new PrintWriter(new FileWriter("userstatisic.txt",true));
        String newRow=this.username;
        newRow = newRow.concat(" ");
        newRow=newRow.concat(s);
        newRow = newRow.concat(" ");
        newRow=newRow.concat(dtf.format(now));
         newRow = newRow.concat(" ");
        newRow=newRow.concat("          ");
        newRow=newRow.concat(s);
         newRow=newRow.concat(" ");
         newRow=newRow.concat("             ");
         newRow=newRow.concat("              ");
          newRow=newRow.concat(numOfProd);
        writer.println(newRow);
    writer.close();  
        return true;
          
    }
   public void offer(String s,String numOfProd,String Orgprice) throws FileNotFoundException, IOException{ 
       int number1 = Integer.parseInt(Orgprice);
     BufferedReader reader = new BufferedReader(new FileReader("userstatisic.txt"));
     String row = reader.readLine();
        while(row != null) {
            String[] fields = row.split(" ");
            String Currentuser=fields[0];
            String currentnum=fields[3];
            String b=" ";
            if(currentnum.equals(b)&&this.username.equals(Currentuser)){
             int number = Integer.parseInt(numOfProd);
             int r=(int) (number*number1*(0.05));
             System.out.println("Total Price is "+r);
             String str1 = Integer.toString(r); 
             PrintWriter writer =new PrintWriter(new FileWriter("userstatisic.txt",true));
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
             LocalDateTime now = LocalDateTime.now(); 
             String newRow=this.username;
        newRow = newRow.concat(" ");
        newRow=newRow.concat(s);
        newRow = newRow.concat(" ");
        newRow=newRow.concat(dtf.format(now));
         newRow = newRow.concat(" ");
        newRow=newRow.concat("          ");
        newRow=newRow.concat(s);
         newRow=newRow.concat(" ");
         newRow=newRow.concat("             ");
         newRow=newRow.concat("              ");
          newRow=newRow.concat(numOfProd);
           newRow=newRow.concat(" ");
            newRow=newRow.concat(str1);
        writer.println(newRow);
    writer.close();  
             
            }
            else if(numOfProd.equals("2")){
                int number = Integer.parseInt(numOfProd);
            int r=(int) (number*number1*(0.1));
             System.out.println("Total Price is "+r);
              String str1 = Integer.toString(r); 
             PrintWriter writer =new PrintWriter(new FileWriter("userstatisic.txt",true));
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
             LocalDateTime now = LocalDateTime.now(); 
             String newRow=this.username;
        newRow = newRow.concat(" ");
        newRow=newRow.concat(s);
        newRow = newRow.concat(" ");
        newRow=newRow.concat(dtf.format(now));
         newRow = newRow.concat(" ");
        newRow=newRow.concat("          ");
        newRow=newRow.concat(s);
         newRow=newRow.concat(" ");
         newRow=newRow.concat("             ");
         newRow=newRow.concat("              ");
          newRow=newRow.concat(numOfProd);
           newRow=newRow.concat(" ");
            newRow=newRow.concat(str1);
        writer.println(newRow);
    writer.close();  
            }
        }
    }
    
 public void request(String OwnerName,String location,String number,String pass,String StoreType) throws IOException{ 
     PrintWriter writer = new PrintWriter(new FileWriter("request.txt", true));
    String newRow = OwnerName;
    newRow = newRow.concat(" ");
    newRow = newRow.concat(location);
    newRow=newRow.concat(" ");
    newRow=newRow.concat(number);
    newRow=newRow.concat(" ");
    newRow=newRow.concat(pass);
    newRow=newRow.concat(" ");
    newRow=newRow.concat(StoreType);
    writer.println(newRow);
    writer.close();
 }
 
public void setusername(String username) {
    this.username = username;
}
     
    
     public String getusername() {
     return this.username;
}
   
    public void deactivateAccount()
    {
        boolean active = false;
    }

    @Override
    public boolean Register() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
