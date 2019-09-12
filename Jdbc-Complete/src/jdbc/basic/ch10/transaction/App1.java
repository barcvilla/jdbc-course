/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch10.transaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class App1 {
    public static void main(String[] args) {
        ServiceAccount service = new ServiceAccountImpl();
        List<UserBalance> users = new ArrayList<>();
        System.out.println("Balance de Cuentas");
        users = service.getAllBalances();
        
        for(UserBalance u : users)
        {
            System.out.println(u);
        }
    }
}
