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
import jdbc.basic.ch03.crud.service.CrudService;
import jdbc.basic.ch03.crud.serviceimplementation.CrudImplementation;

/**
 *
 * @author PC
 */
public class EmployeeListSelectQuery {
    public static void main(String[] args) {
        CrudService crud = new CrudImplementation();
        List<Employee> employees = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the select query");
        String query = input.nextLine();
        employees = crud.runSelectEmployeeQuery(query);
        for(Employee e : employees)
        {
            System.out.println("id: " + e.getEno() + " nom: " + e.getEname() + " salario: " + e.getEsal() + " direccion: " + e.getEaddr());
        }
    }
}
