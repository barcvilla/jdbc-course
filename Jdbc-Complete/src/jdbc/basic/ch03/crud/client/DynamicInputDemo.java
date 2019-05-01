/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.client;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class DynamicInputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee number:");
        int eno = sc.nextInt();
        
        System.out.println("Enter employee name:");
        String ename = sc.next();
        
        System.out.println("Enter employee salary:");
        double esal = sc.nextDouble();
        
        System.out.println("Enter employee address:");
        String eaddr = sc.next();
        
        System.out.println("Informacion ingresada");
        System.out.println(eno + " " + ename + " " + esal + " " + eaddr);
        
        String sqlQuery = "insert into employee values(" + eno +", '" + ename +"', " + esal +". '" + eaddr + "')";
        System.out.println("Hello query with your fixed Input is:");
        System.out.println(sqlQuery);
        // %d significa decimal
        String sqlQuery1 = String.format("insert into employee values(%d, '%s', %f, '%s')", eno, ename, esal, eaddr);
        System.out.println("Hello query with your Dynamic Input is:");
        System.out.println(sqlQuery1);
    }
}
