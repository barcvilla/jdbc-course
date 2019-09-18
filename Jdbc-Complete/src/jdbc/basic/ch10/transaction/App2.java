/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch10.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class App2 {
    static ServiceAccount service = new ServiceAccountImpl();
    static UserBalance user = null;
    static boolean rpt = false;
    
    public static void getBalance()
    {
       System.out.println("Datos antes de la transaccion");
        List<UserBalance> users = new ArrayList<>();
        users = service.getAllBalances();
        for(UserBalance u : users)
        {
            System.out.println(u);
        } 
    }
    
    public static void withDraw()
    {
        System.out.println("La Transaccion de Retiro Inicia...");
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre");
        String name = input.next();
        System.out.println("Ingrese monto a retirar");
        int amount = input.nextInt();
        user = new UserBalance(name, amount);
        System.out.println("Confirma la transaccion de retiro de " + amount + "[Si/No]");
        String opt = input.next();
        rpt = opt.equalsIgnoreCase("si");
        
        UserBalance user1 = service.withDraw(user, rpt);
        System.out.println("Datos luego de la transaccion");
        System.out.println(user1);
    }
    
    public static void deposit()
    {
       System.out.println("La Transaccion de deposito Inicia...");
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre");
        String name = input.next();
        System.out.println("Ingrese monto a depositar");
        int amount = input.nextInt();
        user = new UserBalance(name, amount);
        System.out.println("Confirma la transaccion de deposito de " + amount + "[Si/No]");
        String opt = input.next();
        rpt = opt.equalsIgnoreCase("si");
        
        UserBalance user1 = service.deposit(user, rpt);
        System.out.println("Datos luego de la transaccion");
        System.out.println(user1); 
    }
    
    public static void main(String[] args) {
        getBalance();
        deposit();
        //withDraw();
    }
}
