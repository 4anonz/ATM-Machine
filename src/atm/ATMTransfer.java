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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
//import java.util.regex.Pattern;


/**
 *
 * @author Mohammed Zayyad
 */
public class ATMTransfer extends JFrame {
   
    public JTextField accountNoField, transferAmountField;
    public JButton backButton, transferButton;

    public void displayFrame() {
        
        JLabel headLabel = new JLabel("TRANSFER MONEY");
        JLabel accountNoLabel = new JLabel("Account No: ");
        JLabel transferAmountLabel = new JLabel("Transfer Amount: ");
        
        accountNoField = new JTextField();
        transferAmountField = new JTextField();
        transferButton = new JButton("Tranfer");
        backButton = new JButton("Back");
        
        Font font = new Font("SansSerif", Font.ITALIC, 25);
        
        // Setting the font style for the head
        headLabel.setFont(font);
        
        headLabel.setBounds(240, 40, 300, 50);
        accountNoLabel.setBounds(105, 110, 83, 20);
        accountNoField.setBounds(207, 110, 300, 30);
        transferAmountLabel.setBounds(105, 160, 120, 20);
        transferAmountField.setBounds(207, 160, 300, 30);
        transferButton.setBounds(240, 210, 120, 30);
        backButton.setBounds(500, 490, 100, 30);
        
//        transferButton.addActionListener(this);
//        backButton.addActionListener(this);
        
        add(headLabel);
        add(accountNoLabel);
        add(accountNoField);
        add(transferAmountLabel);
        add(transferAmountField);
        add(transferButton);
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
//        String amountStr = transferAmountField.getText();
//        account.setBalance(1500.00);
//        double amount;
//        if(ae.getSource() == transferButton) {
//            // Validate amount
//            if(!Pattern.matches("[0-9]*", amountStr)) {
//                JOptionPane.showMessageDialog(this, "Invalid withdraw amount provided.!");
//                
//            } else {
//                amount = Double.parseDouble(amountStr);
//                if(account.transfer(amount, accountNoField.getText())) {
//                    JOptionPane.showMessageDialog(this, "Transfer completed successfully!\nNew account balance " +
//                    account.getBalance());
//                } else
//                    JOptionPane.showMessageDialog(this, "Insufficient account balance");
//              
//            }
//        }
//    }
}
