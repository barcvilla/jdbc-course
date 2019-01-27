/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch01.DB;

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
public class PostgresConnection {
    
    Connection cnn = null;
    
    public Connection getConnection()
    {
        String url = "jdbc:postgresql://localhost:5432/jdbcfundamentals";
        String user = "postgres";
        String pass = "postgres";
        try
        {
            Class.forName("org.postgresql.Driver");
            cnn = DriverManager.getConnection(url, user, pass);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(PostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(PostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnn;
    }
    
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
                Logger.getLogger(PostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(cnn != null)
        {
            try {
                cnn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
