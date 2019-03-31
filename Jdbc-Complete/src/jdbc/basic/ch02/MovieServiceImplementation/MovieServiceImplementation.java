/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch02.MovieServiceImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.basic.ch02.DB.OracleConnection;
import jdbc.basic.ch02.domain.Movie;
import jdbc.basic.ch02.service.MovieService;

/**
 *
 * @author PC
 */
public class MovieServiceImplementation implements MovieService{
    private OracleConnection ocon = new OracleConnection();
    private Connection cnn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    //Utilizamos executeUpdate() para queries como insert into, update, delete
    @Override
    public int updateMovie(String sql)
    {
        int count = 0;
        try
        {
            cnn = ocon.getConnection();
            stmt = cnn.createStatement();
            count = stmt.executeUpdate(sql);
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(MovieServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ocon.disconnect(rs, stmt);
        }
        return count;
    }
    
    // utilizamos executeQuery() para operaciones de tipo select
    @Override
    public List<Movie> getAllMovies()
    {
        String sql = "select * from movies";
        List<Movie> movies = new ArrayList<Movie>();
        try
        {
            cnn = ocon.getConnection();
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                Movie m = new Movie();
                m.setNo(rs.getInt("mno"));
                m.setName(rs.getString("mname"));
                m.setHero(rs.getString("hero"));
                m.setHeroine(rs.getString("heroine"));
                movies.add(m);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(MovieServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ocon.disconnect(rs, stmt);
        }
        return movies;
    }
}
