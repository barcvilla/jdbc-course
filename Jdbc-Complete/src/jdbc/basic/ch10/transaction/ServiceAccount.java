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
    public List<UserBalance> getAllBalances();
    public int withDraw(UserBalance user);
    public int deposit(UserBalance user);
}
