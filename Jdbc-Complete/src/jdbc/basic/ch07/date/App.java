/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class App {
    public static void main(String[] args)throws Exception  {
        UserImpl userService = new UserImpl();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre: ");
        String name = input.next();
        System.out.println("Ingrese DOP (dd-MM-yyyy)");
        String dop = input.next();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date udate = sdf.parse(dop);
        long dt = udate.getTime();
        java.sql.Date sDate = new java.sql.Date(dt);
        
        User user = new User(name, sDate);
        userService.insertUser(user);
    }
}
