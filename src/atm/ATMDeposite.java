/*
 * The MIT License
 *
 * Copyright 2021 Mohammed Zayyad.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package atm;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JOptionPane;
//import java.util.regex.Pattern;

/**
 *
 * @author Mohammed Zayyad
 */
public class ATMDeposite extends JFrame {
    
    // Take the account class from the constructor
    JTextField depositeAmountField;
    JButton depositeButton, backButton;

    public void displayFrame() {
        
        JLabel headLabel = new JLabel("DEPOSITE MONEY");
        JLabel withdrawAmountLabel = new JLabel("Amount: ");
        depositeAmountField = new JTextField();
        depositeButton = new JButton("Deposite");
        backButton = new JButton("Back");
        
        Font font = new Font("SansSerif", Font.ITALIC, 25);
        
        // Setting the font style for the head
        headLabel.setFont(font);
        
        headLabel.setBounds(240, 40, 300, 50);
        withdrawAmountLabel.setBounds(140, 110, 67, 20);
        depositeAmountField.setBounds(207, 110, 300, 30);
        depositeButton.setBounds(240, 190, 120, 30);
        backButton.setBounds(500, 490, 100, 30);
        
//        depositeButton.addActionListener(this);
//        backButton.addActionListener(this);
//        
//        setTitle("Deposite Money "+ account.getFullName());
        add(headLabel);
        add(withdrawAmountLabel);
        add(depositeAmountField);
        add(depositeButton);
        add(backButton);
        
        setBounds(350, 75, 500, 500);
        setSize(750, 620);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
//    public void actionPerformed(ActionEvent ae) {
//        
//        // If the withdraw button is pressed.
//        String amountStr = depositeAmountField.getText();
//        double amount;
//        if(ae.getSource() == depositeButton) {
//            // Validate amount
//            if(!Pattern.matches("[0-9]*", amountStr)) {
//                JOptionPane.showMessageDialog(this, "Invalid withdraw amount provided.!");
//                
//            } else {
//                amount = Double.parseDouble(amountStr);
//                account.deposite(amount);
//                JOptionPane.showMessageDialog(this, amountStr + " has been deposited to main account\nNew balance is " +
//                account.getBalance());
//              
//              
//            }
//        }
//    }
}
