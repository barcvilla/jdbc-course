/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch06.batchupdates;

import java.util.List;
import jdbc.basic.ch05.storeproc.domain.Employee;

/**
 *
 * @author PC
 */
public interface EmployeeService {
    public void employeeBatchUpdate(Employee e);
}
