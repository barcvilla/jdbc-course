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
    public int withDraw(UserBalance user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deposit(UserBalance user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
