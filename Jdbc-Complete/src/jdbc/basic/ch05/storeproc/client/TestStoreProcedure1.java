/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch05.storeproc.client;

import java.util.Scanner;
import jdbc.basic.ch05.storeproc.service.EmployeeService;
import jdbc.basic.ch05.storeproc.service.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class TestStoreProcedure1 {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImplementation();
        Scanner input = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        System.out.println("Ingrese numero 1");
        num1 = input.nextInt();
        System.out.println("Ingrese numero 2");
        num2 = input.nextInt();
        System.out.println("La suma es: " + service.getSumNumberProcedure(num1, num2));
    }
            
}
