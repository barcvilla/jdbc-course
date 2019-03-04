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
public class SingletonPostgresConnection {

    private static SingletonPostgresConnection instance;
    private Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/jdbcfundamentals";
    String user = "postgres";
    String pass = "postgres";

    private SingletonPostgresConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SingletonPostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static SingletonPostgresConnection getInstance() {
        try 
        {
            if (instance == null) 
            {
                instance = new SingletonPostgresConnection();
            } 
            else if (instance.getConnection().isClosed()) 
            {
                instance = new SingletonPostgresConnection();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(SingletonPostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }

    public static void disconnect(ResultSet rs, Statement stmt) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PostgresConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
