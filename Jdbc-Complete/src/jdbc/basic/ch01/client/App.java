/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch01.client;

import java.util.List;
import jdbc.basic.ch01.domain.Employee;
import jdbc.basic.ch01.service.implementation.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class App {
    
    public static void getAllEmployees()
    {
        System.out.println("Recuperando datos de los empleados");
        EmployeeServiceImplementation employeeService = new EmployeeServiceImplementation();
        List<Employee> emps = employeeService.getAllEmployees();
        for(Employee e : emps)
        {
            System.out.println(e.toString());
        }
    }
    
    public static void main(String[] args) {
        getAllEmployees();
    }
}
