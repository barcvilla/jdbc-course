/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.date;

import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class App2 {
    public static void main(String[] args) {
        UserService service = new UserImpl();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre: ");
        String name = input.next();
        System.out.println("Ingrese DOP (dd-MM-yyyy)");
        String dop = input.next();
        
        Date sdate = Date.valueOf(dop);
        User user = new User(name, sdate);
        int rc = service.insertUser2(user);
        
        if(rc == 0)
        {
            System.out.println("Usuario no registrado");
        }
        else
        {
            System.out.println("Usuario registrado");
        }
    }
}
