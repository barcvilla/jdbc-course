/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch05.storeproc.db.OracleConnection;
import jdbc.basic.ch08.connectionpolling.MyOracleDataSource;

/**
 *
 * @author PC
 */
public class UserImpl implements UserService{
    List<User> users = null;
    User user = null;
    int rc = 0;
    private MyOracleDataSource oracleConn = new MyOracleDataSource();
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public int insertUser(User user) {
        try(Connection cnn = oracleConn.getConnection())
        {
            pstmt = cnn.prepareStatement("insert into usuarios values(?, ?)");
            pstmt.setString(1, user.getName());
            pstmt.setDate(2, user.getDop());
            rc = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rc;
    }

    @Override
    public int insertUser2(User u) {
        try(Connection cnn = oracleConn.getConnection())
        {
            pstmt =  cnn.prepareStatement("insert into usuarios values(?, ?)");
            pstmt.setString(1, u.getName());
            pstmt.setDate(2, u.getDop());
            rc = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rc;
    }

    @Override
    public List<User> getAllUser() {
        try(Connection cnn = oracleConn.getConnection())
        {
            pstmt = cnn.prepareStatement("select * from usuarios");
            rs = pstmt.executeQuery();
            users = new ArrayList<User>();
            while(rs.next())
            {
                user = new User(rs.getString(1), rs.getDate(2));
                users.add(user);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
}
