/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch06.batchupdates;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdbc.basic.ch05.storeproc.domain.Employee;

/**
 *
 * @author PC
 */
public class client {
    public static void main(String[] args) {
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        Scanner input = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("Employee number: ");
            int eno = input.nextInt();

            System.out.println("Employee Name: ");
            String ename = input.next();

            System.out.println("Employee salary: ");
            double esal = input.nextDouble();

            System.out.println("Employee address: ");
            String eaddr = input.next();
            
            Employee emp = new Employee(eno, ename, esal, eaddr);
            
            System.out.println("Do you want to insert one more record yes/no");
            String option = input.next();
            if(option.equalsIgnoreCase("No"))
            {
                service.employeeBatchUpdate(emp);
                break;
            }
            
            service.employeeBatchUpdate(emp);
            System.out.println("Records inserted Successfully");
        }
    }
}
