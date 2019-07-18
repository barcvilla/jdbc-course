/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch05.storeproc.service;

import java.util.List;
import jdbc.basic.ch05.storeproc.domain.Employee;

/**
 *
 * @author PC
 */
public interface EmployeeService {
    public int getSumNumberProcedure(int num1, int num2);
    public double getEmployeeSalary(int id);
    public Employee getEmployeeNameAndSalary(int id);
    public List<Employee> getEmployees();
    public double getSalaryAvg(int id1, int id2);
    public double getEmployeeSalaryAvg();
    public List<Employee> getAllEmployeeInfo();
    public List<Employee> deleteEmployee(int id);
}
