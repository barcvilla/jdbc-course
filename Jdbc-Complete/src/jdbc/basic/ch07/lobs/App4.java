/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class App4 {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        PersonService service = new PersonServiceImpl();
        System.out.println("Ingrese nombe del archivo a recuperar");
        String name = input.next();
        String title = service.getCitiesFile(name);
        System.out.println("El archivo es: " + title);
    }
}
