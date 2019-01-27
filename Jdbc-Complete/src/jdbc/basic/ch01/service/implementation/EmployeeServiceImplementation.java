/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch01.service.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch01.DB.PostgresConnection;
import jdbc.basic.ch01.domain.Employee;
import jdbc.basic.ch01.service.EmployeeService;

/**
 *
 * @author PC
 */
public class EmployeeServiceImplementation implements EmployeeService{
    
    private PostgresConnection pcon = new PostgresConnection();
    private Connection cnn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select * from employee";
        List<Employee> employees = new ArrayList<>();
        try
        {
            cnn = pcon.getConnection();
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                employees.add(emp);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(EmployeeServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            pcon.disconnect(rs, stmt);
        }
        return employees;
    }
    
}
