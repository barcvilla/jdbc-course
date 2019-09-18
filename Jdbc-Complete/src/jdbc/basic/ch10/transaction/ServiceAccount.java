/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch10.transaction;

import java.util.List;

/**
 *
 * @author PC
 */
public interface ServiceAccount {
    public UserBalance getBalance(String name);
    public List<UserBalance> getAllBalances();
    public UserBalance withDraw(UserBalance user, boolean opt);
    public UserBalance deposit(UserBalance user, boolean opt);
}
