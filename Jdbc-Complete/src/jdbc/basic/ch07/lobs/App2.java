/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class App2 {
    public static void main(String[] args) throws Exception{
        PersonService service = new PersonServiceImpl();
        System.out.println("Ingrese name: ");
        Scanner input = new Scanner(System.in);
        String name =  input.next();
        service.getPersonsImage(name);
    }
}
