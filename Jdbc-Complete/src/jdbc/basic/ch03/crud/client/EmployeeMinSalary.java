/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.client;

import jdbc.basic.ch03.crud.domain.Employee;
import jdbc.basic.ch03.crud.serviceimplementation.CrudImplementation;

/**
 *
 * @author PC
 */
public class EmployeeMinSalary {
    public static void main(String[] args) {
        CrudImplementation crud = new CrudImplementation();
        System.out.println("Employee with min salary");
        Employee employee = crud.getEmployeeMinSalary();
        System.out.println("id: " + employee.getEno() + " nombre: " + employee.getEname() + " Salario: " + employee.getEsal());
    }
}
