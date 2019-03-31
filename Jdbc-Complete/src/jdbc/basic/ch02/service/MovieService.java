/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch02.service;

import java.util.List;
import jdbc.basic.ch02.domain.Movie;

/**
 *
 * @author PC
 */
public interface MovieService {
    public List<Movie> getAllMovies();
    public int updateMovie(String sql);
}
