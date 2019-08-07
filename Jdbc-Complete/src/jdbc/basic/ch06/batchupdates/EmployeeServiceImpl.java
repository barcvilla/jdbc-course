/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch06.batchupdates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch05.storeproc.db.OracleConnection;
import jdbc.basic.ch05.storeproc.domain.Employee;

/**
 *
 * @author PC
 */
public class EmployeeServiceImpl implements EmployeeService {

    private OracleConnection oracleConn = new OracleConnection();
    private PreparedStatement pstmt = null;

    @Override
    public void employeeBatchUpdate(Employee e) {
        try (Connection cnn = oracleConn.getConnection()) {
            pstmt = cnn.prepareStatement("insert into employee values(?, ?, ?, ?)");

            pstmt.setInt(1, e.getEno());
            pstmt.setString(2, e.getEname());
            pstmt.setDouble(3, e.getEsal());
            pstmt.setString(4, e.getEaddr());
            pstmt.addBatch();

            pstmt.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
