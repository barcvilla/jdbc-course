/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch05.storeproc.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdbc.basic.ch05.storeproc.domain.Employee;
import jdbc.basic.ch05.storeproc.service.EmployeeService;
import jdbc.basic.ch05.storeproc.service.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class functionDeleteEmployee {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImplementation();
        List<Employee> employees = new ArrayList<Employee>();
        System.out.println("Delete Employee Using Functions");
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese id employee a eliminar");
        int id = input.nextInt();
        employees = service.deleteEmployee(id);
        int count = employees.size();
        for(Employee e : employees)
        {
            System.out.println("id: " + e.getEno() + " name: " + e.getEname() + " salary: " + e.getEsal() + " address: " + e.getEaddr());
        }
        System.out.println("Numero de empleados eliminados: " + count);
    }
}
