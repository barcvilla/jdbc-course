/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch05.storeproc.client;

import java.util.Scanner;
import jdbc.basic.ch05.storeproc.domain.Employee;
import jdbc.basic.ch05.storeproc.service.EmployeeService;
import jdbc.basic.ch05.storeproc.service.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class spGetEmployeeInfo {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImplementation();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese id del Empleado: ");
        int id = input.nextInt();
        Employee emp = service.getEmployeeNameAndSalary(id);
        System.out.println("Employee name: " + emp.getEname());
        System.out.println("Employee salary: " + emp.getEsal());
    }
}
