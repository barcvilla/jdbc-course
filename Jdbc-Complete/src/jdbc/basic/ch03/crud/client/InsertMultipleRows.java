/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.client;

import java.util.Scanner;
import jdbc.basic.ch03.crud.serviceimplementation.CrudImplementation;

/**
 *
 * @author PC
 */
public class InsertMultipleRows {
    
    public static void main(String[] args) {
        int updateCount = 0;
        CrudImplementation crud = new CrudImplementation();
        Scanner input = new Scanner(System.in); 
        while(true)
        {
            System.out.println("Employee Number:");
            int eno = input.nextInt();
            System.out.println("Employee Name:");
            String ename = input.next();
            System.out.println("Employee Salary:");
            double esal = input.nextDouble();
            System.out.println("Employee Address:");
            String eaddr = input.next();
            crud.insertDynamicalEmployee(eno, ename, esal, eaddr);
            updateCount++;
            System.out.println("Number Record inserted successfully: " + updateCount);
            System.out.println("Do you want insert one more record [yes/no]");
            String option = input.next();
            if(option.equalsIgnoreCase("No"))
            {
                break;
            }
        }
    }
}
