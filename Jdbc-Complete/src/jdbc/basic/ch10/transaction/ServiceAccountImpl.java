/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch10.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch08.connectionpolling.MyOracleDataSource;

/**
 *
 * @author PC
 */
public class ServiceAccountImpl implements ServiceAccount{
    List<UserBalance> users = null;
    UserBalance user = null;
    int amount = 0;
    private MyOracleDataSource oracleConn = new MyOracleDataSource();
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    @Override
    public List<UserBalance> getAllBalances() {
        try(Connection cnn = oracleConn.getConnection())
        {
            pstmt = cnn.prepareStatement("select * from accounts");
            rs = pstmt.executeQuery();
            users = new ArrayList<>();
            while(rs.next())
            {
                user = new UserBalance(rs.getString(1), rs.getInt(2));
                users.add(user);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(ServiceAccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public UserBalance withDraw(UserBalance user, boolean opt) {
        try(Connection cnn = oracleConn.getConnection())
        {
            cnn.setAutoCommit(false);
            pstmt = cnn.prepareStatement("update accounts set balance = balance - '" + user.getAmount() +"' where name = '" + user.getName() + "' ");
            pstmt.executeUpdate();
            pstmt = cnn.prepareStatement("select * from accounts where name = '" + user.getName() + "' ");
            rs = pstmt.executeQuery();
            if(opt)
            {
                cnn.commit();
            }
            else
            {
                cnn.rollback();
            }
            while(rs.next())
            {
                user = new UserBalance(rs.getString(1), rs.getInt(2));
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(ServiceAccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public UserBalance deposit(UserBalance user, boolean opt) {
        try(Connection cnn = oracleConn.getConnection())
        {
            cnn.setAutoCommit(false);
            pstmt = cnn.prepareStatement("update accounts set balance = balance + '" + user.getAmount() + "' where name = '"+ user.getName() + "' ");
            pstmt.executeUpdate();
            
            if(opt)
            {
                cnn.commit();
            }
            else
            {
                cnn.rollback();
            }
            user = getBalance(user.getName());
        }
        catch(SQLException ex)
        {
            Logger.getLogger(ServiceAccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public UserBalance getBalance(String name) {
        try(Connection cnn = oracleConn.getConnection())
        {
            pstmt = cnn.prepareStatement("select * from accounts where name = ?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                user = new UserBalance(rs.getString(1), rs.getInt(2));
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(ServiceAccountImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
