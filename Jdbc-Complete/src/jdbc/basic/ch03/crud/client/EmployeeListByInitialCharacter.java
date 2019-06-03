/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdbc.basic.ch03.crud.domain.Employee;
import jdbc.basic.ch03.crud.serviceimplementation.CrudImplementation;

/**
 *
 * @author PC
 */
public class EmployeeListByInitialCharacter 
{
    public static void main(String[] args) {
        boolean flag = false;
        CrudImplementation crud = new CrudImplementation();
        List<Employee> employees = new ArrayList<Employee>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter initial Character of Employee Name");
        String initial = input.nextLine()+"%";
        employees = crud.getEmployeesBasedInitialCharacter(initial);
        for(Employee e : employees)
        {
            flag = true;
            System.out.println(e.getEno() + "\t" + e.getEname() + "\t\t" + e.getEsal() + "\t" + e.getEaddr());
        }
        
        if(flag == false)
        {
            System.out.println("no more records found");
        }
    }
}
