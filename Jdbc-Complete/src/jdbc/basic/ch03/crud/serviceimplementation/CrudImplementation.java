/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.serviceimplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch02.DB.OracleConnection;
import jdbc.basic.ch03.crud.domain.Employee;
import jdbc.basic.ch03.crud.service.CrudService;

/**
 *
 * @author PC
 */
public class CrudImplementation implements CrudService{
    
    private OracleConnection oCon = new OracleConnection();
    private Statement stmt = null;
    private ResultSet rs = null;
    private List<Employee> employees;
    private String sqlQuery = "";
    private String msg = "";
    private int updateCount = 0;
    
    public CrudImplementation()
    {
        employees = new ArrayList<Employee>();
    }

    @Override
    public String createEmployeeTable() {
        sqlQuery = "create table employee(eno number, ename varchar2(10), esal number(10,2), eaddr varchar2(10))";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            stmt.executeUpdate(sqlQuery);
            msg = "Tabla Employee creada exitosamente";
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    @Override
    public String dropEmployeeTable() {
        sqlQuery = "drop table employee";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            stmt.executeUpdate(sqlQuery);
            msg = "Tabla Employee eliminada exitosamente";
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    @Override
    public int insertFixedEmployee() {
        sqlQuery = "insert into employee values(300, 'Juan', 3000, 'BSAS')";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            updateCount = stmt.executeUpdate(sqlQuery);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateCount;
    }

    @Override
    public void insertDynamicalEmployee(int eno, String ename, double esal, String eaddr) {
        sqlQuery = "insert into employee values(" + eno + ", '" + ename + "', " + esal + ", '" + eaddr + "')";
        //sqlQuery = String.format("insert into employee values(%d, '%s', %f, '%s')", eno, ename, esal, eaddr);
        System.out.println("query: " + sqlQuery);
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            stmt.executeUpdate(sqlQuery);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int insertMultipleRows(int eno, String ename, double esal, String eaddr) {
        String query = "insert into employee values(" + eno + ", '" + ename + "', " + esal + ", '" + eaddr + "')";
        //String query = String.format("insert into employee values(%d, '%s', %f,'%s')", eno, ename, esal, eaddr);
        System.out.println("sql query: " + query);
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            updateCount = stmt.executeUpdate(query);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateCount;
    }

    @Override
    public int updateFixedEmployee() {
        sqlQuery = "update employee set esal = 777 where eno = 100";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            updateCount = stmt.executeUpdate(sqlQuery);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateCount;
    }

    @Override
    public int updateMultipleRows(double increment, double range) {
        sqlQuery = "update employee set esal = esal + " + increment + " where esal <= " + range +" ";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            updateCount = stmt.executeUpdate(sqlQuery);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateCount;
    }

    @Override
    public int deleteFixedEmployee() {
        sqlQuery = "delete from employee where eno = 101";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            updateCount = stmt.executeUpdate(sqlQuery);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateCount;
    }

    @Override
    public int deleteMultipleRows(double salary) {
        sqlQuery = "delete from employee where esal >= " + salary +" ";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            updateCount = stmt.executeUpdate(sqlQuery);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updateCount;
    }

    @Override
    public List<Employee> getAllEmployees() {
        sqlQuery = "select * from employee";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while(rs.next())
            {
                Employee emp = new Employee();
                emp.setEno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setEsal(rs.getDouble(3));
                emp.setEaddr(rs.getString(4));
                employees.add(emp);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    @Override
    public List<Employee> getAllEmployeeOrderBySalary() {
        sqlQuery = "select * from employee order by esal DESC";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while(rs.next())
            {
                Employee emp = new Employee();
                emp.setEno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setEsal(rs.getDouble(3));
                emp.setEaddr(rs.getString(4));
                employees.add(emp);
            }
        }
        catch(SQLException ex)
        {
           Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return employees;
    }

    @Override
    public List<Employee> getEmployeesByAddress(String eaddr) {
        sqlQuery = "select * from employee where eaddr = '" + eaddr + "' ";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while(rs.next())
            {
                Employee emp = new Employee();
                emp.setEno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setEsal(rs.getDouble(3));
                emp.setEaddr(rs.getString(4));
                employees.add(emp);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return employees;
    }

    @Override
    public List<Employee> getEmployeesBySalaryRange(double beginSalary, double endSalary) {
        sqlQuery = "select * from employee where esal >= " + beginSalary +" and esal <= "+ endSalary +" ";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while(rs.next())
            {
                Employee emp = new Employee();
                emp.setEno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setEsal(rs.getDouble(3));
                emp.setEaddr(rs.getString(4));
                employees.add(emp);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return employees;
    }

    @Override
    public List<Employee> getEmployeesBasedInitialCharacter(String initialChar) {
        sqlQuery = "select * from employee where ename like '"+initialChar+"' ";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while(rs.next())
            {
                Employee emp = new Employee();
                emp.setEno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setEsal(rs.getDouble(3));
                emp.setEaddr(rs.getString(4));
                employees.add(emp);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return employees;
    }

    @Override
    public List<Employee> getNameAndAddressEmployees() {
        sqlQuery = "select ename, eaddr from employee";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            while(rs.next())
            {
                Employee emp = new Employee();
                emp.setEname(rs.getString(1));
                emp.setEaddr(rs.getString(2));
                employees.add(emp);
            }
        }
        catch(SQLException ex)
        {
           Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return employees;
    }

    @Override
    public int getEmployeeCount() {
        int count = 0;
        sqlQuery = "select count(*) from employee";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            // cuando usamos aggregate function como count(*), MAX, MIN, AGV etc en lugar de usar while, usamos if
            // porque un aggregate function siempre retorna un valor, es decir un resultset de una columna/fila
            if(rs.next())
            {
                count = rs.getInt(1);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return count;
    }
    
    @Override
    public Employee getEmployeeMaxSalary()
    {
        Employee employee = null;
        sqlQuery = "select eno, ename, eaddr, esal from employee where esal = (select max(esal) from employee)";
        try(Connection cnn = oCon.getConnection())
        {
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            if(rs.next())
            {
                employee = new Employee();
                employee.setEno(rs.getInt(1));
                employee.setEname(rs.getString(2));
                employee.setEaddr(rs.getString(3));
                employee.setEsal(rs.getDouble(4));
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(CrudImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
}
