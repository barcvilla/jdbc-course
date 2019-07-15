/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch05.storeproc.client;

import java.util.List;
import jdbc.basic.ch05.storeproc.domain.Employee;
import jdbc.basic.ch05.storeproc.service.EmployeeService;
import jdbc.basic.ch05.storeproc.service.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class spGetEmployeeWithCursor {
    public static void main(String[] args) {
        boolean flag = false;
        System.out.println("Get all Employee using Oracle Cursor");
        EmployeeService service = new EmployeeServiceImplementation();
        List<Employee> employees = service.getEmployees();
        for(Employee e : employees)
        {
            flag = true;
            System.out.println("id: " + e.getEno() + " name: " + e.getEname() + " salary: " + e.getEsal());
        }
        
        if(flag == false)
        {
            System.out.println("No records available");
        }
    }
}
