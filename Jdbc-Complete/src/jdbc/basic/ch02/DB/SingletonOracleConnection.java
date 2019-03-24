/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch02.DB;

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
public class SingletonOracleConnection 
{
    private static SingletonOracleConnection instance;
    private Connection conn = null;
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String driver = "oracle.jdbc.OracleDriver";
    String user = "developer";
    String password = "developer";
    
    private SingletonOracleConnection()
    {
        try
        {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(SingletonOracleConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection()
    {
        return conn;
    }
    
    public static SingletonOracleConnection getInstance()
    {
        try
        {
            if(instance == null)
            {
                instance = new SingletonOracleConnection();
            }
            else if(instance.getConnection().isClosed())
            {
                instance = new SingletonOracleConnection();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(SingletonOracleConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
    
    public static void disconnect(ResultSet rs, Statement stmt)
    {
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException ex)
            {
                Logger.getLogger(SingletonOracleConnection.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SingletonOracleConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
