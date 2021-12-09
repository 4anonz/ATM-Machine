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

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

/**
 *
 * @author Mohammed Zayyad
 */
public class ATMBalance extends JFrame {
    JButton backButton;
    JTextField balanceField;
            
    public void displayFrame() {
        
        JLabel headLabel = new JLabel("ACCOUNT BALANCE");
        balanceField = new JTextField();
        backButton = new JButton("Back");
        
//        backButton.addActionListener(this);
        balanceField.setEditable(false);
        
        headLabel.setBounds(240, 40, 300, 50);
        balanceField.setBounds(207, 210, 300, 30);
        backButton.setBounds(500, 490, 100, 30);
        Font font = new Font("SansSerif", Font.ITALIC, 25);
        
        // Setting the font style for the head
        headLabel.setFont(font);
        
        add(headLabel);
        add(balanceField);
        add(backButton);
        
//        setTitle("Account Balance: " + account.getFullName());
        setBounds(350, 75, 500, 500);
        setSize(750, 620);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
}
