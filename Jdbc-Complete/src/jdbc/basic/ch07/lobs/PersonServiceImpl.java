/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

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
public class PersonServiceImpl implements PersonService{
    
    private OracleConnection oracleConn = new OracleConnection();
    private PreparedStatement pstmt = null;
    int rc = 0;

    @Override
    public int insertPerson(Persons p) {
        try(Connection cnn = oracleConn.getConnection())
        {
            pstmt = cnn.prepareStatement("insert into persons values(?, ?)");
            pstmt.setString(1, p.getName());
            pstmt.setBinaryStream(2, p.getPic());
            rc = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rc;
    }
    
}
