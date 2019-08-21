/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class App {
    public static void main(String[] args) throws Exception{
        PersonService service = new PersonServiceImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre: ");
        String name = input.next();
        
        File file = new File(Ini.getPropertyFile1());
        FileInputStream fis = new FileInputStream(file);
        Persons p = new Persons();
        p.setName(name);
        p.setPic(fis);
        int rc = service.insertPerson(p);
        if(rc == 0)
        {
            System.out.println("record not inserted");
        }
        else
        {
            System.out.println("record inserted");
        }
    }
}
