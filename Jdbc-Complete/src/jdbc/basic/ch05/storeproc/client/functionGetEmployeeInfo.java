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
public class functionGetEmployeeInfo {
    public static void main(String[] args) {
        boolean flag = false;
        System.out.println("Getting All Employee Information using Oracle Functions");
        EmployeeService service = new EmployeeServiceImplementation();
        List<Employee> employees = service.getAllEmployeeInfo();
        for(Employee e : employees)
        {
            System.out.println("id: " + e.getEno() + " name: " + e.getEname() + " salary: " + e.getEsal() + " address: " + e.getEaddr());
        }
        
        if(false == true)
        {
            System.out.println("No records available");
        }
    }
}
