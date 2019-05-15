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
public class EmployeeListByAddress {
    public static void main(String[] args) {
        CrudImplementation crud = new CrudImplementation();
        List<Employee> employees = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter city name");
        String eaddr = input.nextLine();
        employees = crud.getEmployeesByAddress(eaddr);
        for(Employee e : employees)
        {
            System.out.println(e.getEno() + "\t" + e.getEname() + "\t\t" + e.getEsal() + "\t" + e.getEaddr());
        }
        System.out.println("no matched record found");
    }
}
