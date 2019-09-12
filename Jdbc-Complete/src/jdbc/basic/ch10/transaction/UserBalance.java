/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch10.transaction;

/**
 *
 * @author PC
 */
public class UserBalance {
    private String name;
    private int balance;
    
    public UserBalance(String name, int balance)
    {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserBalance{" + "name=" + name + ", balance=" + balance + '}';
    }
    
}
