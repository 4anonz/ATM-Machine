/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import atm.*;
import java.util.regex.Pattern;

/**
 *
 * @author Mohammed Zayyad
 */
public class ATM implements ActionListener {
    
    // Global varaibles
    ATMSignINWindow signinFrame;     // For managing the sign in frame
    ATMSignUPWindow signupFrame;     // For managing the sign up frame
    ATMWithdraw withdrawFrame;       // For managing the withdraw frame
    ATMTransfer transferFrame;       // For managing the transfer frame
    ATMDeposite depositeFrame;       // For managing the deposite frame
    ATMBalance balanceFrame;         // For managin the balance frame
    ATMAccount account;              // For holding the users ATM account detials
    JFrame mainWindow;               // For managing the main window frame
    JButton proceedButton;
    JCheckBox b1, b2, b3, b4;
    
    ATM() {
        
        // Initializing objects
        signinFrame = new ATMSignINWindow();
        signupFrame = new ATMSignUPWindow();
        withdrawFrame = new ATMWithdraw();
        transferFrame = new ATMTransfer();
        depositeFrame = new ATMDeposite();
        balanceFrame = new ATMBalance();
        account = new ATMAccount();
    
    }
    
    public void signINWindow() {
        
        // Create a new instance of the account class
        account = new ATMAccount();
        
        // Create a new sigin window
        signinFrame = new ATMSignINWindow();
        signinFrame.displayFrame();
        
        // Add sigin and signup button to an action listener
        signinFrame.signinButton.addActionListener(this);
        signinFrame.signupButton.addActionListener(this);
        
    }
    public void mainFrame() {
        
        mainWindow = new JFrame("Automated teller machine");
        JLabel headLabel = new JLabel("WELCOME "+ account.getFullName());
        JLabel label = new JLabel("What will you like to do today?");
     
        b1 = new JCheckBox("1) Withdraw");
        b2 = new JCheckBox("2) Transfer");
        b3 = new JCheckBox("3) Deposite");
        b4 = new JCheckBox("4) Balance");
        proceedButton = new JButton("Proceed");
        
        Font font = new Font("SansSerif", Font.ITALIC, 25);
        headLabel.setFont(font);
        
        headLabel.setBounds(240, 40, 300, 50);
        label.setBounds(140, 100, 300, 20);
        b1.setBounds(140, 150, 250, 20);
        b2.setBounds(140, 200, 250, 20);
        b3.setBounds(140, 250, 250, 20);
        b4.setBounds(140, 300, 250, 20);
        proceedButton.setBounds(500, 490, 100, 30);
        proceedButton.addActionListener(this);
        

        mainWindow.add(headLabel);
        mainWindow.add(label);
        mainWindow.add(b1);
        mainWindow.add(b2);
        mainWindow.add(b3);
        mainWindow.add(b4);
        mainWindow.add(proceedButton);
        
        mainWindow.setBounds(350, 75, 500, 500);
        mainWindow.setSize(750, 620);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        b1.addItemListener( new ItemListener() {
            
            public void itemStateChanged(ItemEvent ie) {
                if(b1.isSelected()) {
                    if(b2.isSelected())
                        b2.setSelected(false);
                    if(b3.isSelected())
                        b3.setSelected(false);
                    if(b4.isSelected())
                        b4.setSelected(false);
                }
            }
        });
        
        b2.addItemListener( new ItemListener() {
            
            public void itemStateChanged(ItemEvent ie) {
                if(b2.isSelected()) {
                    if(b1.isSelected())
                        b1.setSelected(false);
                    if(b3.isSelected())
                        b3.setSelected(false);
                    if(b4.isSelected())
                        b4.setSelected(false);
                }
            }
        });
        
        b3.addItemListener( new ItemListener() {
            
            public void itemStateChanged(ItemEvent ie) {
                if(b3.isSelected()) {
                    if(b1.isSelected())
                        b1.setSelected(false);
                    if(b2.isSelected())
                        b2.setSelected(false);
                    if(b4.isSelected())
                        b4.setSelected(false);
                }
            }
        });
        
        b4.addItemListener( new ItemListener() {
            
            public void itemStateChanged(ItemEvent ie) {
                if(b4.isSelected()) {
                    if(b1.isSelected())
                        b1.setSelected(false);
                    if(b2.isSelected())
                        b2.setSelected(false);
                    if(b3.isSelected())
                        b3.setSelected(false);
                }
            }
        });
    }
    
    public void signUpWindow() {
        
        signupFrame = new ATMSignUPWindow();
        signupFrame.displayFrame();
        // Add the sign in and sign up button to the action listener
        signupFrame.signinButton.addActionListener(this);
        signupFrame.signupButton.addActionListener(this);
    }
    
    /**
     * For displaying the withdraw window frame
    */
    public void withdrawWindow() {
        
        withdrawFrame = new ATMWithdraw();
        withdrawFrame.displayFrame();
        
        withdrawFrame.setTitle("Withdraw Money "+ account.getFullName());
        withdrawFrame.backButton.addActionListener(this);
        withdrawFrame.withdrawButton.addActionListener(this);
        
    }
    
    public void transferWindow() {
        
        transferFrame = new ATMTransfer();
        transferFrame.displayFrame();
        
        transferFrame.setTitle("Transfer Money "+ account.getFullName());
        transferFrame.backButton.addActionListener(this);
        transferFrame.transferButton.addActionListener(this);
    }
    
    public void depositeWindow() {
        
        depositeFrame = new ATMDeposite();
        depositeFrame.displayFrame();
        
        depositeFrame.setTitle("Deposite Money " + account.getFullName());
        depositeFrame.backButton.addActionListener(this);
        depositeFrame.depositeButton.addActionListener(this);
    }
    
    public void balanceWindow() {
        
        balanceFrame = new ATMBalance();
        balanceFrame.displayFrame();
        
        balanceFrame.setTitle("Account Balance - " + account.getFullName());
        balanceFrame.balanceField.setText("Your total main account balance " + account.getBalance());
        balanceFrame.backButton.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        // If the sigin Button is pressed
        if(ae.getSource() == signinFrame.signinButton) {
            // Try to login
            String pin = new String(signinFrame.pinNoField.getPassword());
            if((signinFrame.accountNoField.getText().length() < 1) || (signinFrame.pinNoField.getPassword().length < 1)) {
                JOptionPane.showMessageDialog(signinFrame, "Please complte filling your details");
            }else if(!Pattern.matches("[0-9]{4}", pin)) {
                JOptionPane.showMessageDialog(signinFrame, "Incorrect Pin!!\nPin must not contain any special character(s)\nor alphabet(s) and must be 4 in length.");
            } else {
                if(account.login(signinFrame.accountNoField.getText(), pin)) {
                    signinFrame.setVisible(false);
                    mainFrame();
                } else {
                    JOptionPane.showMessageDialog(signinFrame, "Authentication failed\nCheck and try again");
                }
            }
        } else if(ae.getSource() == signinFrame.signupButton) {
            signinFrame.setVisible(false);
            signUpWindow();
        } else if(ae.getSource() == signupFrame.signupButton) {
            
            String pin = signupFrame.pinNoField.getText();
            if((signupFrame.firstNameField.getText().length() < 1) ||
               (signupFrame.secondNameField.getText().length() < 1) || (!signupFrame.maleRadio.isSelected() && !signupFrame.femaleRadio.isSelected())
                || (signupFrame.phoneNumberField.getText().length() < 1) || (signupFrame.emailAddressField.getText().length() < 1)
                || (!signupFrame.accountTypeCurrent.isSelected() && !signupFrame.accountTypeSavings.isSelected())
                || (!signupFrame.cardTypeMaster.isSelected() && !signupFrame.cardTypeVerve.isSelected())) {
                    JOptionPane.showMessageDialog(signupFrame, "Please complete filling in the form!");
                
                        /**
                        * Validating the pin number
                        * pin number must be 4 in length and must not contain a alphabet or
                        * any special character
                       */
            } else if(!signupFrame.emailAddressField.getText().contains("@") || ! signupFrame.emailAddressField.getText().contains(".")) {
                
                JOptionPane.showMessageDialog(signupFrame, "Invalid email address\nPlease double check it!!");
            } else if(!Pattern.matches("[0-9]{4}", pin)) {
                JOptionPane.showMessageDialog(signupFrame, "Pin must not contain any special character(s)\n or alphabet(s) and must be 4 in length.");
            } else {
                
                // Create an ATM card number for the account created
                String cardNumber = new ATMAccount().newATMCardNumber();
                
                // Create a new account number for the newly account
                String accountNumber = new ATMAccount().newAccountNumber();
                
                final String accountType, atmCardType;
                
                if(signupFrame.accountTypeCurrent.isSelected())
                    accountType = "Current Account";
                else
                    accountType = "Savings Account";
                
                if(signupFrame.cardTypeMaster.isSelected())
                     atmCardType = "Master Card";
                else
                    atmCardType = "Verve Card";
                
                final int gender;
                if(signupFrame.maleRadio.isSelected())
                    gender = 0;
                else
                    gender = 1;
                
                account = new ATMAccount(signupFrame.firstNameField.getText(), signupFrame.secondNameField.getText(), signupFrame.pinNoField.getText(),
                cardNumber, signupFrame.phoneNumberField.getText(), signupFrame.emailAddressField.getText(), accountNumber, accountType, atmCardType, gender);
                
                if(account.createNewAccountRecord()) {
                    JOptionPane.showMessageDialog(signupFrame, "Account created successfully!!\nYour Account Number is " + accountNumber +
                    "\nYour ATM Card Number is "+ cardNumber);
                    signupFrame.setVisible(false);
                    signINWindow();
                } else {
                    JOptionPane.showMessageDialog(signupFrame, "An Error occured\nAccount not created.\nTry again later");
                }
            }
        } else if(ae.getSource() == signupFrame.signinButton) {
            signupFrame.setVisible(false);
            signINWindow();
        } else if(ae.getSource() == proceedButton) {
            
            /**
             * If the proceed button is pressed, check which ATM operation
             * the user requires to perform
             */
            if(!b1.isSelected() && !b2.isSelected() && !b3.isSelected() && !b4.isSelected()) {
                JOptionPane.showMessageDialog(mainWindow, "Please select an option to proceed!");
            } else {
                mainWindow.setVisible(false);
                /**
                 * Check which option is selected
                 * and perform action accordingly.
                */
                
                if(b1.isSelected())
                    withdrawWindow();
                else if(b2.isSelected())
                    transferWindow();
                else if(b3.isSelected())
                    depositeWindow();
                else
                    balanceWindow();
                
            }
        } else if(ae.getSource() == withdrawFrame.withdrawButton) {
             //If the withdraw button is pressed.
            String amountStr = withdrawFrame.withdrawAmountField.getText();
            double amount;
            // Validate amount
            if(Pattern.matches("[a-zA-Z]", amountStr)) {
                JOptionPane.showMessageDialog(withdrawFrame, "Invalid withdraw amount provided.!");

            } else {
                amount = Double.parseDouble(amountStr);
                if(account.withdraw(amount)) {
                    JOptionPane.showMessageDialog(withdrawFrame, "Successfuly withdrown " + amountStr + "\nNew account balance " +
                    account.getBalance());
                    // go back to the main frame
                    withdrawFrame.setVisible(false);
                    mainFrame();
                } else
                    JOptionPane.showMessageDialog(withdrawFrame, "Insufficient account balance");

            }
            
        } else if(ae.getSource() == withdrawFrame.backButton) {
            
            withdrawFrame.setVisible(false);
            mainFrame();
        } else if(ae.getSource() == transferFrame.transferButton) {
            /***
             *  If the transfer button is pressed
             * perform the transaction.
            */
            String amountStr = transferFrame.transferAmountField.getText();
            double amount;
            // Validate amount
            if(Pattern.matches("[a-zA-Z]", amountStr)) {
                JOptionPane.showMessageDialog(transferFrame, "Invalid transfer amount provided.!");

            } else {
                amount = Double.parseDouble(amountStr);
                if(account.transfer(amount, transferFrame.accountNoField.getText())) {
                    JOptionPane.showMessageDialog(transferFrame, "Transfer completed successfully!\nNew account balance " +
                    account.getBalance());
                    transferFrame.setVisible(false);
                    mainFrame();
                } else
                    JOptionPane.showMessageDialog(transferFrame, "Insufficient account balance");
            }
            
        } else if(ae.getSource() == transferFrame.backButton) {
            transferFrame.setVisible(false);
            mainFrame();
        } else if(ae.getSource() == balanceFrame.backButton) {
            balanceFrame.setVisible(false);
            mainFrame();
        } else if(ae.getSource() == depositeFrame.depositeButton) {
                    // If the withdraw button is pressed.
            String amountStr = depositeFrame.depositeAmountField.getText();
            double amount;
            // Validate amount
            if(Pattern.matches("[a-zA-Z]", amountStr)) {
                JOptionPane.showMessageDialog(depositeFrame, "Invalid deposite amount provided.!");

            } else {
                amount = Double.parseDouble(amountStr);
                account.deposite(amount);
                JOptionPane.showMessageDialog(depositeFrame, amountStr + " has been deposited to main account\nNew balance is " +
                account.getBalance());
                depositeFrame.setVisible(false);
                mainFrame();
            }
            
        } else if(ae.getSource() == depositeFrame.backButton) {
            depositeFrame.setVisible(false);
            mainFrame();
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ATM atm = new ATM();
        atm.signINWindow();
    }
}
