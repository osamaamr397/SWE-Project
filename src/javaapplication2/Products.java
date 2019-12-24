/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author amr
 */
public   class Products {
    String Pname;
    String Pprice;
    String Pcat;
    String Pquant;
    String Brand;
   
    public Products(String Pname,String Pprice,String Pcat,String Pquant,String Brand){ 
    this.Pname=Pname;
    this.Pprice=Pprice;
    this.Pcat=Pcat;
    this.Pquant=Pquant;
    this.Brand=Brand;
    }
    
    public void setPname(String Pname) {
    this.Pname = Pname;
}
     public void setPprice(String Pprice) {
    this.Pprice = Pprice;
}
     public void setPcat(String Pcat) {
    this.Pcat = Pcat;
}
   public void setPquant(String Pquant) {
   this.Pquant=Pquant ;
}
    public void setBrand(String Brand) {
   this.Brand=Brand ;
}
    
     public String getPname() {
     return this.Pname = Pname;
}
     public String getPprice() {
    return this.Pprice = Pprice;
}
     public String getPcat() {
   return this.Pcat = Pcat;
}
     public String getPquant() {
   return this.Pquant ;
}
     public String getBrand(){ 
     return this.Brand;
     }

}
