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
public class spGetEmployeeSalary {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImplementation();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el Id del empleado");
        int id = input.nextInt();
        System.out.println("Su sueldo es: " + service.getEmployeeSalary(id));
    }
}
