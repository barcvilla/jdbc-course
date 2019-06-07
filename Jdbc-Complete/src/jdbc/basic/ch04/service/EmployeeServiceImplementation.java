/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private PreparedStatement pstmt = null;
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

    @Override
    public void insertEmployee(Employee employee) {
        sqlQuery = "insert into employees values(?, ?, ?, ?)";
        try(Connection cnn = mysqlCon.getConnection())
        {
            pstmt = cnn.prepareStatement(sqlQuery);
            pstmt.setInt(1, employee.getEno());
            pstmt.setString(2, employee.getEname());
            pstmt.setDouble(3, employee.getEsal());
            pstmt.setString(4, employee.getEaddr());
            pstmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(EmployeeServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int deleteEmployee(int id) {
        sqlQuery = "delete from employees where eno = ?";
        try(Connection cnn = mysqlCon.getConnection())
        {
            pstmt = cnn.prepareStatement(sqlQuery);
            pstmt.setInt(1, id);
            updateCount = pstmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(EmployeeServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateCount;
    }
    
}
