/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch08.connectionpolling;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch09.properties.IniFile;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

/**
 *
 * @author PC
 */
public class MyOracleDataSource {
    Connection cnn = null;
    OracleConnectionPoolDataSource ds = null;
    Properties prop = null;
    IniFile ini = null;
    
    public Connection getConnection()
    {
        /**
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String driver = "oracle.jdbc.OracleDriver";
        String user = "sys as sysdba";
        String password = "admin";
        */
        prop = new Properties();
        ini = new IniFile();
        prop = ini.getPropertyFile();
        
        String url = prop.getProperty("url");
        String driver = prop.getProperty("driver");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        
        try
        {
            ds = new OracleConnectionPoolDataSource();
            ds.setURL(url);
            ds.setUser(user);
            ds.setPassword(password);
            cnn = ds.getConnection();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(MyOracleDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnn;
    }
}
