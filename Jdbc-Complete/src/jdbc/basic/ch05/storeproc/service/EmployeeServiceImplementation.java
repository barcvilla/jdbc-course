/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch05.storeproc.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch05.storeproc.db.OracleConnection;
import jdbc.basic.ch05.storeproc.domain.Employee;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author PC
 */
public class EmployeeServiceImplementation implements EmployeeService{
    private Employee employee = null;
    private List<Employee> employees;
    private ResultSet rs = null;
    private OracleConnection oracleCon = new OracleConnection();
    private CallableStatement cstmt = null;
    private int resultNum = 0;
    private double salary = 0.0;
    
    public EmployeeServiceImplementation()
    {
        employees = new ArrayList<Employee>();
    }

    @Override
    public int getSumNumberProcedure(int num1, int num2) {
        try(Connection cnn = oracleCon.getConnection())
        {
            // creamos el CallableStatement con la llamada al procedimiento
            cstmt = cnn.prepareCall("{call procedure1(?,?,?)}");
            // proveemos valores para cada parametro IN (indice/valor) correspondiente al metodo setter
            cstmt.setInt(1, num1);
            cstmt.setInt(2, num2);
            //register cada parametro OUT con el correspondiente JDBC types
            cstmt.registerOutParameter(3, Types.INTEGER);
            //execute
            cstmt.execute();
            return resultNum = cstmt.getInt(3);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(EmployeeServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public double getEmployeeSalary(int id) {
        try(Connection cnn = oracleCon.getConnection())
        {
            cstmt = cnn.prepareCall("{call getEmployeeSalary(?,?)}");
            cstmt.setInt(1, id);
            cstmt.registerOutParameter(2, Types.FLOAT);
            cstmt.execute();
            return salary = cstmt.getDouble(2);
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(EmployeeServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Employee getEmployeeNameAndSalary(int id) {
        try(Connection cnn = oracleCon.getConnection())
        {
            cstmt = cnn.prepareCall("{call getEmpInfo(?,?,?)}");
            cstmt.setInt(1, id);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.FLOAT);
            cstmt.execute();
            employee = new Employee();
            employee.setEno(id);
            employee.setEname(cstmt.getString(2));
            employee.setEsal(cstmt.getFloat(3));
            employee.setEaddr(null);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(EmployeeServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        try(Connection cnn = oracleCon.getConnection())
        {
            cstmt = cnn.prepareCall("call getEmployee(?)");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            rs = (ResultSet)cstmt.getObject(1);
            employees = new ArrayList<>();
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
