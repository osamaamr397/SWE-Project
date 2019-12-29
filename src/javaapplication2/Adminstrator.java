/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author amr
 */
public class Adminstrator implements Regist,Login {
    private String Aname;
    private String Apass;
    /**
     *
     * @param Aname
     * @param Apass
     */
    
    public Adminstrator(String Aname,String Apass){ 
    this.Aname=Aname;
    this.Apass=Apass;
    }
    
	Adminstrator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    public boolean login(String Aname, String Apass) throws FileNotFoundException, IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader("Adminstrator.txt"));
        String row = reader.readLine();
        while(row != null) {
            String[] fields = row.split(" ");
            String currentAdmin = fields[0];
            if(Aname.equals(currentAdmin)) {
                String CurrentPaAdmin = fields[1];
                if(Apass.equals(CurrentPaAdmin)) {
                    return true;
                }
            }
            row = reader.readLine();
        }
        
        return false;
    }
    
    public boolean Register(String Aname, String Apass ) throws IOException{
    //FileWriter writer=new FileWriter(file, true);//true 3lshan my3mlsh overwrite yzod 3la s\el file
    BufferedReader reader = new BufferedReader(new FileReader("Adminstrator.txt"));
    String row = reader.readLine();
    while(row!=null){ 
        String[] fields=row.split(" ");
        String currentAdmin=fields[0];
        if(Aname.equals(currentAdmin)) {
            return false;
        }
        row = reader.readLine();
    }
    reader.close();
    PrintWriter writer = new PrintWriter(new FileWriter("Adminstrator.txt", true));
    String newRow = Aname;
    newRow = newRow.concat(" ");
    newRow = newRow.concat(Apass);
    writer.println(newRow);
    writer.close();
    return true;
    }
    
    
    public boolean addproduct(String Pname,String Pprice,String Pcat,String Pquant,String Brand) throws FileNotFoundException, IOException { 
    BufferedReader reader=new BufferedReader(new FileReader("AdminProducts.txt"));
    String row=reader.readLine();
    while(row!=null){ 
    String []fields=row.split(" ");
    String CurrentProduct=fields[0];
    if(Pname.equals(CurrentProduct)){ 
    String CurrentPquant=fields[3];
     PrintWriter writer = new PrintWriter(new FileWriter("AdminProducts.txt",true));
   

 
     return false;
    }
    row=reader.readLine();
    }
    
    
    reader.close();
    PrintWriter writer = new PrintWriter(new FileWriter("AdminProducts.txt",true));
    
    String newRow = Pname;
    newRow = newRow.concat(" ");
    newRow = newRow.concat(Pprice);
    newRow=newRow.concat(" ");
    newRow=newRow.concat(Pcat);
    newRow=newRow.concat(" ");
    newRow=newRow.concat(Pquant);
    newRow=newRow.concat(" ");
    newRow=newRow.concat(Brand);
    writer.println(newRow);
    writer.close();
    return true;

    }
    public boolean readRequset(UserAccount user) throws FileNotFoundException, IOException{ 
        //UserAccount user=new UserAccount();
    BufferedReader reader=new BufferedReader(new FileReader("storeowners.txt"));
    String row=reader.readLine();
     while(row!=null){ 
        String[] fields=row.split(" ");
        String currentuser=fields[0];
        if(user.getusername().equals(currentuser)){ 
            return false;
            
        }
        row = reader.readLine();
    }
    reader.close();
    FileInputStream instream = null;
	FileOutputStream outstream = null;
 
    	  try {
                     File stockInputFile = new File("request.txt");
                     File StockOutputFile = new File("storeowners.txt");

                     /*
                      * Constructor of FileInputStream throws FileNotFoundException if
                      * the argument File does not exist.
                      */

                     FileInputStream fis = new FileInputStream(stockInputFile);
                     FileOutputStream fos = new FileOutputStream(StockOutputFile);
                     int count;

                     while ((count = fis.read()) != -1) {
                           fos.write(count);
                     }
                     fis.close();
                     fos.close();
              } catch (FileNotFoundException e) {
                     System.err.println("FileStreamsReadnWrite: " + e);
              } catch (IOException e) {
                     System.err.println("FileStreamsReadnWrite: " + e);
              }
        return false;
       }
    public boolean addBrand(String B) throws FileNotFoundException, IOException{
       Products brand=new Products (null,null,null,null,null);
       BufferedReader reader=new BufferedReader (new FileReader("Brand.txt") );
       String row=reader.readLine();
     while(row!=null){ 
        String[] fields=row.split(" ");
        String currentBrand=fields[0];
        if(B.equals(currentBrand)){ 
             System.out.println("Brand already Exist");
            return false;
          
        }
        row = reader.readLine();
    }
     reader.close();
      PrintWriter writer = new PrintWriter(new FileWriter("Brand.txt", true));
      String newRow = B;
    newRow = newRow.concat(" ");
    writer.println(newRow);
    writer.close();
    System.out.println("Brand is added");
    return true;
    }
    public void live() throws IOException{ 
    CrunchifyFindMaxOccurance s=new CrunchifyFindMaxOccurance();
    s.view();
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

       

