/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Mohammed Zayyad
 */
public interface ATMOperation {
    boolean withdraw(double amount);
    boolean transfer(double amount, String accountNumber);
    void deposite(double amount);
//    void displayBalance();
//    void displayHistory();
}
