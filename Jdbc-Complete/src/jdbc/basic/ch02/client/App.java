/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch02.client;

import java.util.List;
import jdbc.basic.ch02.MovieServiceImplementation.MovieServiceImplementation;
import jdbc.basic.ch02.domain.Movie;

/**
 *
 * @author PC
 */
public class App 
{
    public static void getAllMovies()
    {
        System.out.println("Recuperando datos de Movies");
        MovieServiceImplementation movieService = new MovieServiceImplementation();
        List<Movie> movies = movieService.getAllMovies();
        for(Movie m : movies)
        {
            System.out.println(m.toString());
        }
    }
    
    public static void main(String[] args) {
        getAllMovies();
    }
}
