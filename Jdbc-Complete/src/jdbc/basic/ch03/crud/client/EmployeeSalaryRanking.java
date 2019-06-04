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
public class EmployeeSalaryRanking 
{
    public static void main(String[] args) {
        boolean flag =  false;
        CrudImplementation crud = new CrudImplementation();
        Employee e = new Employee();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el # de empleados en el ranking de salarios");
        int rank = input.nextInt();
        e = crud.getEmployeeNThHighestSalaried(rank);
        
        System.out.println("id: " + e.getEno() + " nom: " + e.getEname() + "\t" + " salario: " + e.getEsal() + " ranking: " + e.getEaddr());
        
    }
}
