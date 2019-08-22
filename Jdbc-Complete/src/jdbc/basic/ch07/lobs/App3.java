/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

import java.io.File;

/**
 *
 * @author PC
 */
public class App3 {
    public static void main(String[] args)throws Exception {
        PersonService service = new PersonServiceImpl();
        System.out.println("Insert cities");
        File file = new File("eeuu.txt");
        int rc = service.loadCityFile(file);
        if(rc == 1)
        {
            System.out.println("Registro insertado");
        }
        else
        {
            System.out.println("Registro no insertado");
        }
    }
}
