/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch05.storeproc.client;

import jdbc.basic.ch05.storeproc.service.EmployeeService;
import jdbc.basic.ch05.storeproc.service.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class functionGetSalaryAvg {
    public static void main(String[] args) {
        System.out.println("Working with functions");
        EmployeeService service = new EmployeeServiceImplementation();
        System.out.println("Employee Salary Average: " + service.getEmployeeSalaryAvg());
    }
}
