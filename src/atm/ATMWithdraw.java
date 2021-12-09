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
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
//import java.util.regex.Pattern;
//import java.awt.event.*;


/**
 *
 * @author Mohammed Zayyad
 */
public class ATMWithdraw extends JFrame {
   
    public JTextField withdrawAmountField;
    public JButton backButton, withdrawButton;
    
    public void displayFrame() {

        
        JLabel headLabel = new JLabel("WITHDRAW MONEY");
        JLabel withdrawAmountLabel = new JLabel("Amount: ");
        withdrawAmountField = new JTextField();
        withdrawButton = new JButton("Withdraw");
        backButton = new JButton("Back");
        
        Font font = new Font("SansSerif", Font.ITALIC, 25);
        
        // Setting the font style for the head
        headLabel.setFont(font);
        
        headLabel.setBounds(240, 40, 300, 50);
        withdrawAmountLabel.setBounds(140, 110, 67, 20);
        withdrawAmountField.setBounds(207, 110, 300, 30);
        withdrawButton.setBounds(240, 190, 120, 30);
        backButton.setBounds(500, 490, 100, 30);
        
        
        
        add(headLabel);
        add(withdrawAmountLabel);
        add(withdrawAmountField);
        add(withdrawButton);
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
//        String amountStr = withdrawAmountField.getText();
//        double amount;
//        if(ae.getSource() == withdrawButton) {
//            // Validate amount
//            if(!Pattern.matches("[0-9]*", amountStr)) {
//                JOptionPane.showMessageDialog(this, "Invalid withdraw amount provided.!");
//                
//            } else {
//                amount = Double.parseDouble(amountStr);
//                if(account.withdraw(amount)) {
//                    JOptionPane.showMessageDialog(this, "Successfuly withdrown " + amountStr + "\nNew account balance " +
//                    account.getBalance());
//                } else
//                    JOptionPane.showMessageDialog(this, "Insufficient account balance");
//              
//            }
//        }
//    }
}
