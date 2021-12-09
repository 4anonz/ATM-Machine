/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
//import java.util.regex.Pattern;
//import atm.ATMAccount;

/**
 *
 * @author Mohammed Zayyad
 */
public class ATMSignUPWindow extends JFrame {
    // Global varaibles
    public JButton signinButton, signupButton;
    public JTextField firstNameField, secondNameField, pinNoField, phoneNumberField, emailAddressField;
    public JRadioButton maleRadio, femaleRadio, cardTypeMaster, cardTypeVerve, accountTypeCurrent, accountTypeSavings;
    boolean successStatus = false;
    
    public void displayFrame() {
        setTitle("Automated Teller Machine: Create an Account");
        // Initializing varaibles
        JLabel sText = new JLabel("ATM - Create an Account");
        JLabel firstNameLabel = new JLabel("First Name: ");
        JLabel secondNameLabel = new JLabel("Second Name: ");
        
        JLabel phoneNumberLabel = new JLabel("Phone No: ");
        JLabel emailAddressLabel = new JLabel("Email: ");
        
        JLabel cardTypeLabel = new JLabel("ATM Card Type: ");
        JLabel accountTypeLabel = new JLabel("Account Type: ");
     
        JLabel pinNoLabel = new JLabel("PIN No: ");
        JLabel genderLabel = new JLabel("Gender: ");
        
        firstNameField = new JTextField();
        secondNameField = new JTextField();
        phoneNumberField = new JTextField();
        emailAddressField = new JTextField();

        pinNoField = new JTextField();
        // Sign in and sign up button initialization
        signinButton = new JButton("SIGN IN");
        signupButton = new JButton("SIGN UP");
        
        // Gender radio button
        maleRadio = new JRadioButton("Male ");  
        femaleRadio = new JRadioButton("Female ");
        
        // ATM card type radio buttons
        cardTypeMaster = new JRadioButton("Master ");
        cardTypeVerve = new JRadioButton("Verse ");
        
        // Account type radio buttons
        accountTypeCurrent = new JRadioButton("Current ");
        accountTypeSavings = new JRadioButton("Savings ");
        
        Font font = new Font("SansSerif", Font.BOLD, 25);
        JLabel isAccount = new JLabel("Already have an account?");
        
        //Setting the font size
        sText.setFont(font);
        
        // Positioning the items in the frame
        sText.setBounds(150, 30, 300, 60);
        //FirstName
        firstNameLabel.setBounds(140, 100, 80, 20);
        firstNameField.setBounds(230, 100, 300, 30);
        
        //Secind Name
        secondNameLabel.setBounds(140, 150, 100, 20);
        secondNameField.setBounds(230, 150, 300, 30);
        
        // Phone number
        phoneNumberLabel.setBounds(140, 200, 62, 20);
        phoneNumberField.setBounds(230, 200, 300, 30);
        
        // Email Address
        emailAddressLabel.setBounds(140, 250, 50, 20);
        emailAddressField.setBounds(230, 250, 300, 30);
        
        // Pin Number
        pinNoLabel.setBounds(140, 300, 50, 20);
        pinNoField.setBounds(230, 300, 300, 30);
        
        // Gender 
        genderLabel.setBounds(140, 350, 50, 20);
        maleRadio.setBounds(250, 350, 60, 20);
        femaleRadio.setBounds(350, 350, 70, 20);

        // Account type
        accountTypeLabel.setBounds(140, 380, 140, 20);
        accountTypeCurrent.setBounds(250, 380, 100, 20);
        accountTypeSavings.setBounds(350, 380, 100, 20);
        
        // ATM card type
        cardTypeLabel.setBounds(140, 420, 100, 20);
        cardTypeMaster.setBounds(250, 420, 85, 20);
        cardTypeVerve.setBounds(350, 420, 76, 20);
        
        // Sign in / Sign up buttons
        signupButton.setBounds(300, 470, 90, 30);
        
        isAccount.setBounds(140, 530, 150, 20);
        signinButton.setBounds(300, 530, 90, 30);

//        signupButton.setBounds(260, 270, 90, 30);
//        signinButton.setBounds(290, 400, 90, 30);
     
        
        
        
        maleRadio.addItemListener( new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                // If male radio button is checked, then uncheck the female button
                // if it's already checked before
                if(ie.getStateChange() == 1) {
                    if(femaleRadio.isSelected()) {
                        femaleRadio.setSelected(false);
                    }
                }
            }
        });
        
        femaleRadio.addItemListener(new ItemListener() {
            // If the female button is checked and the male button was previously
            // checked, then uncheck it
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange() == 1) {
                    if(maleRadio.isSelected()) {
                        maleRadio.setSelected(false);
                    }
                }
            }
        });
        
        accountTypeCurrent.addItemListener( new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                if(accountTypeCurrent.isSelected()) {
                    if(accountTypeSavings.isSelected()) {
                        accountTypeSavings.setSelected(false);
                    }
                }
            }
        });
        
        accountTypeSavings.addItemListener( new ItemListener() {
           public void itemStateChanged(ItemEvent ie) {
               if(accountTypeSavings.isSelected()) {
                   if(accountTypeCurrent.isSelected()) {
                       accountTypeCurrent.setSelected(false);
                   }
               }
           } 
        });
        
        
        cardTypeMaster.addItemListener( new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                if(cardTypeMaster.isSelected()) {
                    if(cardTypeVerve.isSelected()) {
                        cardTypeVerve.setSelected(false);
                    }
                }
            }
        });
        
        cardTypeVerve.addItemListener( new ItemListener() {
           public void itemStateChanged(ItemEvent ie) {
               if(cardTypeVerve.isSelected()) {
                   if(cardTypeMaster.isSelected()) {
                       cardTypeMaster.setSelected(false);
                   }
               }
           } 
        });

        
        // Add all the elements to the frame
        add(sText);
        add(firstNameLabel);
        add(firstNameField);
        add(secondNameLabel);
        add(secondNameField);
        add(pinNoLabel);
        add(pinNoField);
        add(signinButton);
        add(signupButton);
        add(maleRadio);
        add(femaleRadio);
        add(emailAddressLabel);
        add(emailAddressField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(genderLabel);
        add(accountTypeLabel);
        add(accountTypeCurrent);
        add(accountTypeSavings);
        add(cardTypeLabel);
        add(cardTypeMaster);
        add(cardTypeVerve);
        add(isAccount);
        
        // Set the frame size, bound, layout and visibility.
        setBounds(350, 75, 500, 500);
        setSize(750, 620);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//    
//    public void actionPerformed(ActionEvent actionEvent) {
//        
//        if(actionEvent.getSource() == signupButton) {
//            String pin = pinNoField.getText();
//            if((firstNameField.getText().length() < 1) ||
//               (secondNameField.getText().length() < 1) || (!maleRadio.isSelected() && !femaleRadio.isSelected())
//                || (phoneNumberField.getText().length() < 1) || (emailAddressField.getText().length() < 1)
//                || (!accountTypeCurrent.isSelected() && !accountTypeSavings.isSelected())
//                || (!cardTypeMaster.isSelected() && !cardTypeVerve.isSelected())) {
//                    JOptionPane.showMessageDialog(this, "Please complete filling in the form!");
//                
//                        /**
//                        * Validating the pin number
//                        * pin number must be 4 in length and must not contain a alphabet or
//                        * any special character
//                       */
//            } else if(!emailAddressField.getText().contains("@") || ! emailAddressField.getText().contains(".")) {
//                
//                JOptionPane.showMessageDialog(this, "Invalid email address\nPlease double check it!!");
//            } else if(!Pattern.matches("[0-9]{4}", pin)) {
//                JOptionPane.showMessageDialog(this, "Pin must not contain any special character(s)\n or alphabet(s) and must be 4 in length.");
//            } else {
//                
//                // Create an ATM card number for the account created
//                String cardNumber = new ATMAccount().newATMCardNumber();
//                
//                // Create a new account number for the newly account
//                String accountNumber = new ATMAccount().newAccountNumber();
//                
//                final String accountType, atmCardType;
//                
//                if(accountTypeCurrent.isSelected())
//                    accountType = "Current Account";
//                else
//                    accountType = "Savings Account";
//                
//                if(cardTypeMaster.isSelected())
//                     atmCardType = "Master Card";
//                else
//                    atmCardType = "Verve Card";
//                
//                final int gender;
//                if(maleRadio.isSelected())
//                    gender = 0;
//                else
//                    gender = 1;
//                
//                ATMAccount account = new ATMAccount(firstNameField.getText(), secondNameField.getText(), pinNoField.getText(),
//                cardNumber, phoneNumberField.getText(), emailAddressField.getText(), accountNumber, accountType, atmCardType, gender);
//                
//                if(account.createNewAccountRecord()) {
//                    JOptionPane.showMessageDialog(this, "Account created successfully!!\nYour Account Number is " + accountNumber +
//                    "\nYour ATM Card Number is "+ cardNumber);
//                    successStatus = true;
//                } else {
//                    JOptionPane.showMessageDialog(this, "An Error occured\nAccount not created.\nTry again later");
//                }
//                
//            }
//        }
//    }
    
}
