/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    private ResultSet rs = null;
    private Persons p = null;
    private InputStream is = null;
    private FileOutputStream fos = null;
    private List<Persons> persons = null;
    int rc = 0;

    @Override
    public int insertPerson(Persons p) {
        try(Connection cnn = oracleConn.getConnection())
        {
            pstmt = cnn.prepareStatement("insert into persons values(?, ?)");
            pstmt.setString(1, p.getName());
            pstmt.setBinaryStream(2, p.getPic()); //guardamos la imagen
            rc = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rc;
    }

    @Override
    public void getPersonsImage(String name) throws Exception{
        try(Connection cnn = oracleConn.getConnection())
        {
           pstmt = cnn.prepareCall("select * from persons where name = ?");
           pstmt.setString(1, name);
           rs = pstmt.executeQuery();
           byte[] buffer = new byte[1024];
           if(rs.next())
           {
               is = rs.getBinaryStream(2);
               fos = new FileOutputStream(rs.getString(1) + ".jpg");
               while(is.read(buffer) > 0)
               {
                    fos.write(buffer);
               }
               fos.flush();
           }
        }
        catch (SQLException ex) {
            Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
