/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
//import java.awt.event.*;
//import java.util.regex.Pattern;

/**
 *
 * @author Mohammed Zayyad
 */
public class ATMSignINWindow extends JFrame {
    // Global varaibles
    public JButton signinButton, signupButton;
    public JPasswordField pinNoField;
    public JTextField accountNoField;
    
    public void displayFrame() {
        
        setTitle("Automated Teller Machine: Sign In");
        // Initializing varaibles
        JLabel sText = new JLabel("ATM - SIGN IN");
        JLabel accountNoLabel = new JLabel("Account No: ");
        JLabel pinNoLabel = new JLabel("PIN No: ");
        pinNoField = new JPasswordField();
        accountNoField = new JTextField();
        signinButton = new JButton("SIGN IN");
        signupButton = new JButton("SIGN UP");
        Font font = new Font("SansSerif", Font.BOLD, 25);
        JLabel noAccount = new JLabel("Don't have an account");
        
        //Setting the font size
        sText.setFont(font);
        
        // Positioning the frame elements
        sText.setBounds(200, 100, 200, 60);
        accountNoLabel.setBounds(100, 170, 90, 20);
        accountNoField.setBounds(180, 170, 300, 30);
        
        pinNoLabel.setBounds(100, 210, 50, 20);
        pinNoField.setBounds(180, 210, 300, 30);
        
        signinButton.setBounds(260, 250, 90, 30);
        signupButton.setBounds(270, 400, 90, 30);
        noAccount.setBounds(100, 400, 130, 20);
        
        
        // Add all the elements to the frame
        add(sText); 
        add(accountNoLabel);
        add(accountNoField);
        add(pinNoLabel);
        add(pinNoField);
        add(signinButton);
        add(signupButton);
        add(noAccount);
        
        // Set the frame size, bound, layout and visibility.
        setBounds(450, 100, 600, 600);
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//    
//    public void actionPerformed(ActionEvent actionEvent) {
//        
//        if(actionEvent.getSource() == signinButton) {
//            String pin = new String(pinNoField.getPassword());
//            if((accountNoField.getText().length() < 1) || (pinNoField.getPassword().length < 1)) {
//                JOptionPane.showMessageDialog(this, "Please complte filling your details");
//            }else if(!Pattern.matches("[0-9]{4}", pin)) {
//                JOptionPane.showMessageDialog(this, "Incorrect Pin!!\nPin must not contain any special character(s)\nor alphabet(s) and must be 4 in length.");
//            }
//        }
//    }
}
