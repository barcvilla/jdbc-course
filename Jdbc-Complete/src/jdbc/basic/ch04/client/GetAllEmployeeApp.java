/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch04.client;

import java.util.List;
import jdbc.basic.ch04.domain.Employee;
import jdbc.basic.ch04.service.EmployeeService;
import jdbc.basic.ch04.service.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class GetAllEmployeeApp {
    public static void main(String[] args) {
        System.out.println("Get all employees");
        EmployeeService empService = new EmployeeServiceImplementation();
        List<Employee> employees = empService.getAllEmployees();
        for(Employee e : employees)
        {
            System.out.println("id: " + e.getEno() + " nom: " + e.getEname() + "\tsalario: " + e.getEsal() + " dir:" + e.getEaddr());
        }
    }
}
