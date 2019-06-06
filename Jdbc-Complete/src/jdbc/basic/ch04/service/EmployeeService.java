/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch04.service;

import java.util.List;
import jdbc.basic.ch04.domain.Employee;

/**
 *
 * @author PC
 */
public interface EmployeeService {
    public List<Employee> getAllEmployees();
}
