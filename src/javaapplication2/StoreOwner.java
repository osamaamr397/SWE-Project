/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author amr
 */
public class StoreOwner implements Regist, Login {

    private String OwnerName;
    private String location;
    private String number;
    private String pass;
    private String StoreType;
    private String StroreProduct;

    public StoreOwner(String OwnerName, String location, String number, String pass, String StoreType) {
        this.OwnerName = OwnerName;
        this.location = location;
        this.number = number;
        this.pass = pass;
        this.StoreType = StoreType;

    }

    public boolean login(String OwnerName, String pass) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("storeowners.txt"));
        String row = reader.readLine();
        while (row != null) {
            String[] fields = row.split(" ");
            String CurrentOwner = fields[0];
            if (OwnerName.equals(CurrentOwner)) {
                String CurrentPass = fields[1];
                if (pass.equals(CurrentPass)) {
                    return true;
                }
            }
            row = reader.readLine();
        }
        return false;
    }

    public void addToStore(String pro, String quan) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("products.txt"));
        String row = reader.readLine();
        while (row != null) {
            String[] fields = row.split(" ");
            String CurrentProduct = fields[0];
            String Pprice = fields[1];
            String Pcat = fields[2];
            String Brand = fields[4];

            if (pro.equals(CurrentProduct)) {
                PrintWriter writer = new PrintWriter(new FileWriter("StoreProducts.txt", true));
                String newRow = pro;
                newRow = newRow.concat(" ");
                newRow = newRow.concat(Pprice);
                newRow = newRow.concat(" ");
                newRow = newRow.concat(Pcat);
                newRow = newRow.concat(" ");
                newRow = newRow.concat(quan);
                newRow = newRow.concat(" ");
                newRow = newRow.concat(Brand);
                newRow = newRow.concat(" ");
                newRow = newRow.concat(this.OwnerName);
                writer.println(newRow);
                writer.close();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                PrintWriter riter = new PrintWriter(new FileWriter("StoreStatisics.txt", true));
                String newrow = this.OwnerName;
                newrow = newrow.concat(" ");
                newrow = newrow.concat(pro);
                newrow = newrow.concat(" ");
                newrow = newrow.concat(quan);
                newrow = newrow.concat(" ");
                newrow = newrow.concat(dtf.format(now));
                riter.println(newRow);
                riter.close();

            }
        }
    }
    public void StoreStat() throws FileNotFoundException, IOException{ 
     BufferedReader reader=new BufferedReader(new FileReader("StoreStatisics.txt"));
        String row=reader.readLine();
        while(row!=null){ 
        String[] fields=row.split(" ");
        String Currentname=fields[0];
        if(this.OwnerName.equals(Currentname)){
         System.out.println(row);
        }
        row=reader.readLine();
        }
    }
    public boolean Register(String OwnerName, String location, String number, String pass, String StoreType) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("storeowners.txt"));
        String row = reader.readLine();
        while (row != null) {
            String[] fields = row.split(" ");
            String CurrentOwner = fields[0];
            if (OwnerName.equals(CurrentOwner)) {
                String CurrentNumber = fields[2];
                if (number.equals(CurrentNumber)) {
                    return false;
                }
            }
            row = reader.readLine();
        }
        reader.close();
        PrintWriter writer = new PrintWriter(new FileWriter("storeowners.txt", true));
        String newRow = OwnerName;
        newRow = newRow.concat(" ");
        newRow = newRow.concat(location);
        newRow = newRow.concat(" ");
        newRow = newRow.concat(number);
        newRow = newRow.concat(" ");
        newRow = newRow.concat(pass);
        newRow = newRow.concat(" ");
        newRow = newRow.concat(StoreType);
        writer.println(newRow);
        writer.close();
        return true;
    }

    public void StoreProduct() throws FileNotFoundException, IOException {
        FileInputStream instream = null;
        FileOutputStream outstream = null;

        try {
            File infile = new File("AdminProducts.txt");
            File outfile = new File("products.txt");

            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outfile);

            byte[] buffer = new byte[1024];

            int length;
            /*copying the contents from input stream to
             * output stream using read and write methods
             */
            while ((length = instream.read(buffer)) > 0) {
                outstream.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            instream.close();
            outstream.close();

            System.out.println("File copied successfully!!");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void view() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("userstatisic.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public void deactivateAccount() {
        boolean active = false;
    }

    public boolean addcollaborator(String B) throws FileNotFoundException, IOException {
        collaborators coll = new collaborators(null, null, null, null, null, null);
        BufferedReader reader = new BufferedReader(new FileReader("collaborators.txt"));
        String row = reader.readLine();
        while (row != null) {
            String[] fields = row.split(" ");
            String currentcoll = fields[0];
            if (B.equals(currentcoll)) {
                System.out.println("Brand already Exist");
                return false;

            }
            row = reader.readLine();
        }
        reader.close();
        PrintWriter writer = new PrintWriter(new FileWriter("collaborators.txt", true));
        String name, pass, location, number, StoreType, originals;
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        name = input.nextLine();
        coll.setName(name);
        System.out.println("pass: ");
        pass = input.nextLine();
        coll.setPass(pass);
        System.out.println("Location: ");
        location = input.nextLine();
        coll.setLocation(location);
        System.out.println("number: ");
        number = input.nextLine();
        coll.setNumber(number);
        System.out.println("StroreType: ");
        StoreType = input.nextLine();
        coll.setStoreType(StoreType);
        System.out.println("original: ");
        originals = input.nextLine();
        coll.setOriginals(originals);
        String newRow = B;
        newRow = newRow.concat(" ");
        newRow = newRow.concat(" ");
        newRow = newRow.concat(location);
        newRow = newRow.concat(" ");
        newRow = newRow.concat(number);
        newRow = newRow.concat(" ");
        newRow = newRow.concat(pass);
        newRow = newRow.concat(" ");
        newRow = newRow.concat(StoreType);
        newRow = newRow.concat(" ");
        newRow = newRow.concat(this.getOwnerName());
        writer.println(newRow);
        writer.close();
        System.out.println("collaborators is added");
        return true;
    }

    public void live() throws IOException {
        Adminstrator s = new Adminstrator();
        s.live();
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
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
