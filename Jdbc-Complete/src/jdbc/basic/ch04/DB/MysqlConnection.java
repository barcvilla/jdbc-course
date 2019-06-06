/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch04.DB;

import jdbc.basic.ch02.DB.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class MysqlConnection {
    Connection cnn = null;
    
    public Connection getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/durgadb?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "admin";
        try
        {
            //1. Load & Register Driver
            Class.forName(driver);
            // 2. Establish Connection between database
            cnn = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnn;
    }
    /**
    public void disconnect(ResultSet rs, Statement stmt)
    {
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException ex)
            {
                Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(stmt != null)
        {
            try
            {
                stmt.close();
            }
            catch(SQLException ex)
            {
                Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(cnn != null)
        {
            try {
                cnn.close();
            } catch (SQLException ex) {
                Logger.getLogger(OracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    * */
}
