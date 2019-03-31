/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch02.client;

import java.util.Scanner;
import jdbc.basic.ch02.MovieServiceImplementation.MovieServiceImplementation;

/**
 *
 * @author PC
 */
public class NonSelectedQueryTest {
    public static void main(String[] args) {
        MovieServiceImplementation movieService = new MovieServiceImplementation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el Update Query");
        String sqlQuery = sc.nextLine();
        int row = movieService.updateMovie(sqlQuery);
        System.out.println("El numero de filas afectadas: " + row);
    }
}
