/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch04.client;

import java.util.Scanner;
import jdbc.basic.ch04.domain.Employee;
import jdbc.basic.ch04.service.EmployeeService;
import jdbc.basic.ch04.service.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class InsertEmployeeApp {
    public static void main(String[] args) {
        Employee emp = new Employee();
        EmployeeService service = new EmployeeServiceImplementation();
        Scanner input = new Scanner(System.in);
        String option = "";
        while(true)
        {
            System.out.println("Employee Number:");
            int id = input.nextInt();
            System.out.println("Employee Name:");
            String name = input.next();
            System.out.println("Employee Salary:");
            double salary = input.nextDouble();
            System.out.println("Employee Address");
            String address = input.next();
            emp.setEno(id);
            emp.setEname(name);
            emp.setEsal(salary);
            emp.setEaddr(address);
            service.insertEmployee(emp);
            System.out.println("record inserted successfully");
            System.out.println("Do you want to insert one more record[yes/no]");
            option = input.next();
            if(option.equalsIgnoreCase("No"))
            {
                break;
            }
        }
    }
}
