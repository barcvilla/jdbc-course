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
public class SingletonPostgresConnection 
{
    private static Connection conn = null;
    static Connection getConnection()
    {
        String url = "jdbc:postgresql://localhost:5432/jdbcfundamentals";
        String user = "postgres";
        String pass = "postgres";
        try
        {
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex)
        {
            Logger.getLogger(SingletonPostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return conn;
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
        
        if(conn != null)
        {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
