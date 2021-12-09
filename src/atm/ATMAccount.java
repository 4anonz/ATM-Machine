/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import atm.ATMOperation;

interface AccountOperation extends ATMOperation {
    String newAccountNumber();
    String newATMCardNumber();
    boolean login(String cardNumber, String pin);
    boolean createNewAccountRecord();
    void updateDatabase();
}

/**
 *
 * @author Mohammed Zayyad
 */
public class ATMAccount implements AccountOperation {

    private String firstName, secondName, pinNumber, cardNumber, phoneNumber, emailAddress;
    private String accountType, atmCardType, accountNumber; 
    private int gender;
    private double accountBalance;
    String recordFile = "database.csv";
    
    // Initializing varaibles
    ATMAccount(String firstName, String secondName, String pinNumber, String cardNumber,
               String phoneNumber, String emailAddress, String accountNumber, String accountType, String atmCardType, int gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.pinNumber = pinNumber;
        this.cardNumber = cardNumber;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.atmCardType = atmCardType;
        this.emailAddress = emailAddress;
        this.accountNumber = accountNumber;
        this.gender = gender;
        accountBalance = 0.00;
    }
    ATMAccount() {}
    
    // For generating an account number for new users
    public String newAccountNumber() {
        
        Random random = new Random();
        String accountNumber = "0004";
        for(int i = 0; i < 6; i++) {
            final int r = 1 + random.nextInt(9);
            accountNumber += String.valueOf(r);
        }
        
        return accountNumber;
    }
    
    public String newATMCardNumber() {
        
        Random random = new Random();
        String cardNumber = new String();
        for(int i = 0; i < 10; i++) {
            final int rand = 1 + random.nextInt(9);
            cardNumber += String.valueOf(rand);
        }
        return cardNumber;
    }
    /**
     * Note.. In this part of the code they're security flows, since this project
     * was not make to be used by real bank, as this was to give a clean and clear
     * example. We'll be storing every account details in a CSV file.
    */
    public boolean createNewAccountRecord() {
        File databaseFile = new File(recordFile);
        FileWriter fwrite;
        if(!databaseFile.exists()) {
            try {
                databaseFile.createNewFile();
                FileWriter f = new FileWriter(recordFile);
                f.write("PIN NO,FIRST NAME,SECOND NAME,GENDER,PHONE NO,EMAIL,"
                        + "ACCOUNT NO,ATM CARD NO,ACCOUNT TYPE,ATM CARD TYPE,"
                        + "ACCOUNT BALANCE\n");
                f.close();
            }
            catch(IOException ioe) {
                return false;
            }
        }
        try{
            fwrite = new FileWriter(recordFile, true);
            fwrite.write(pinNumber + ","+ firstName + "," + secondName + "," + 
            gender + "," + phoneNumber + "," + emailAddress + "," + accountNumber +
            "," + cardNumber + "," + accountType + "," + atmCardType + "" +
            "," + accountBalance + "\n");
            fwrite.flush();
            fwrite.close();
            return true;
        }
        catch(IOException e) { return false; }
    }
    
    public boolean login(String accountNumber, String pin) {
        
           File databaseFile = new File(recordFile);
           Scanner readFile = null;
           String line;
        try {
            readFile = new Scanner(databaseFile);
           // Read file line by line
           while(readFile.hasNextLine()) {
               
               line = readFile.nextLine();
               String[] data = line.split(",");
               
               // If we find login details are correct.
               // Then we set all account details
               if(data[0].equals(pin) && data[6].equals(accountNumber)) {
                   int g = Integer.parseInt(data[3]);
                   double b = Double.parseDouble(data[10]);
                   setPinNumber(data[0]);
                   setFirstName(data[1]);
                   setSecondName(data[2]);
                   setGender(g);
                   setPhoneNumber(data[4]);
                   setEmailAddress(data[5]);
                   setAccountNumber(data[6]);
                   setCardNumber(data[7]);
                   setAccountType(data[8]);
                   setATMCardType(data[9]);
                   setBalance(b);
                   
                   readFile.close();
                   return true;
               }    
           }
        }
        catch(FileNotFoundException es) { return false; }
        readFile.close();
        return false;
    }
    
    public void setPinNumber(String pinNumber) { 
        this.pinNumber = pinNumber; 
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public void setATMCardType(String atmCardType) {
        this.atmCardType = atmCardType;
    }
    
    public String getFullName() {
        return firstName + " " + secondName;
    }
    public double getBalance() {
        return accountBalance;
    }
    public void setBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    // Abstract method for withdrawing money
    public boolean withdraw(double amount) {
        if(amount > accountBalance)
            return false;
        setBalance(accountBalance - amount);
        // Update the user record in the database to a new account balance
        updateDatabase();
        return true;
    }
    
    // Abstrack method for Depositing money
    public void deposite(double amount) {
        setBalance(accountBalance + amount);
        // Update the user record in the database to a new account balance
        updateDatabase();
    }
    
    // Abstract method for withdrawing money
    public boolean transfer(double amount, String accountNumber) {
        if(amount > accountBalance)
            return false;
        setBalance(accountBalance - amount);
        // Update the user record in the database to a new account balance
        updateDatabase();
        return true;
    }
    
    /**
     * This method is use for updating the database.
     * For example when a user transfers, withdraws or deposites money.
    */
    
    public void updateDatabase() {
        File databaseFile = new File(recordFile);
        Scanner readFile = null, readFileLines;
        int counter = 0, totalLines = 0;
        
        /**
         * Count the total records available in the database
        */
        try {
            readFileLines = new Scanner(databaseFile);
            while(readFileLines.hasNextLine()) {
                readFileLines.nextLine();
                totalLines++;
            }
            readFileLines.close();
        }
        catch(FileNotFoundException e) {}
     
        String[] lines = new String[totalLines];
        
        try {
            readFile = new Scanner(databaseFile);
            // Read all database records
            while(readFile.hasNextLine()) {
                lines[counter] = readFile.nextLine();
                counter++;
            }
            readFile.close();
        }
        catch(FileNotFoundException e) {}
        
        /**
         * Find the specific record we want to update
        */
        String[] newLines = new String[totalLines];  // For storing the updated records
        counter = 0;
        
        for(String l: lines) {
            String[] op = l.split(",");
            if(op[0].equals(pinNumber) && op[6].equals(accountNumber)) {
                op[10] = String.valueOf(getBalance());
                String tmp = "";
                for(String val: op) {
                    tmp += val + ",";
                }
                if(tmp.endsWith(",")) {
                    int index = tmp.lastIndexOf(',');
                    tmp = tmp.substring(0, index - 1);
                    newLines[counter] = tmp + "\n";
                    counter++;
                    continue;
                }
            }
            newLines[counter] = l + "\n";
            counter++;
        }
        /**
         * Update the database file by overriding the existing contents
         * with the new content
        */
        try {
            // first override the existing content
            FileWriter fwrite = new FileWriter(recordFile);
            fwrite.write("");
            fwrite.close();
            
            // Reopen the file in an append mode
            fwrite = new FileWriter(recordFile, true);
            fwrite.write("PIN NO,FIRST NAME,SECOND NAME,GENDER,PHONE NO,EMAIL,"
                        + "ACCOUNT NO,ATM CARD NO,ACCOUNT TYPE,ATM CARD TYPE,"
                        + "ACCOUNT BALANCE\n");
            for(String sLine: newLines)
                fwrite.write(sLine);
            fwrite.close();
            
        }
        catch(IOException ie) {}
    }
}
