/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch04.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch04.DB.MysqlConnection;
import jdbc.basic.ch04.domain.Employee;

/**
 *
 * @author PC
 */
public class EmployeeServiceImplementation implements EmployeeService
{
    private Employee employee = null;
    private List<Employee> employees;
    private MysqlConnection mysqlCon = new MysqlConnection();
    private Statement stmt = null;
    private ResultSet rs = null;
    private String sqlQuery = "";
    private int updateCount = 0;
    
    public EmployeeServiceImplementation()
    {
        employees = new ArrayList<>();
    }
    
    @Override
    public List<Employee> getAllEmployees() {
        sqlQuery = "select * from employees";
        try(Connection cnn = mysqlCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while(rs.next())
            {
                employee = new Employee();
                employee.setEno(rs.getInt(1));
                employee.setEname(rs.getString(2));
                employee.setEsal(rs.getDouble(3));
                employee.setEaddr(rs.getString(4));
                employees.add(employee);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(EmployeeServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
}
