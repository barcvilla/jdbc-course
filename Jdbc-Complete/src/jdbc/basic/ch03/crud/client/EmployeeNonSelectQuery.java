/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.client;

import java.util.Scanner;
import jdbc.basic.ch03.crud.service.CrudService;
import jdbc.basic.ch03.crud.serviceimplementation.CrudImplementation;

/**
 *
 * @author PC
 */
public class EmployeeNonSelectQuery {
    public static void main(String[] args) {
        CrudService crud = new CrudImplementation();
        int updateCount = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the non select query");
        String query = input.nextLine();
        updateCount = crud.runNonSelectEmployeeQuery(query);
        System.out.println("El numero de filas afectadas: " + updateCount);
    }
}
