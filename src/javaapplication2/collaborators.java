/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author mmmoohhaammmeeeedd
 */
public class collaborators {
   private String  name;
   private String  location;
   private String number;
   private String pass;
   private String StoreType;
   private String originals;
  public collaborators(String name,String location,String number,String pass,String StoreType,String originals ){ 
  this.name=name;
  this.location=location;
  this.number=number;
  this.pass=pass;
  this.StoreType=StoreType;
  this.originals=originals;
  }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getNumber() {
        return number;
    }

    public String getPass() {
        return pass;
    }

    public String getStoreType() {
        return StoreType;
    }

    public String getOriginals() {
        return originals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setStoreType(String StoreType) {
        this.StoreType = StoreType;
    }

    public void setOriginals(String originals) {
        this.originals = originals;
    }
  
}
