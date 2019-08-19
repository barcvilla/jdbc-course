/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch05.storeproc.db.OracleConnection;

/**
 *
 * @author PC
 */
public class UserImpl implements UserService{
    
    private OracleConnection oracleConn = new OracleConnection();
    private PreparedStatement pstmt = null;

    @Override
    public void insertUser(User user) {
        try(Connection cnn = oracleConn.getConnection())
        {
            pstmt = cnn.prepareStatement("insert into usuarios values(?, ?)");
            pstmt.setString(1, user.getName());
            pstmt.setDate(2, user.getDop());
            pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
