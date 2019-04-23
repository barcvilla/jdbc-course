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
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch02.DB.OracleConnection;
import jdbc.basic.ch03.crud.service.CrudService;

/**
 *
 * @author PC
 */
public class CrudImplementation implements CrudService{
    
    private OracleConnection oCon = new OracleConnection();
    private Statement stmt = null;
    private ResultSet rs = null;
    private String sqlQuery = "";
    private String msg = "";
    private int updateCount = 0;

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
    
}
