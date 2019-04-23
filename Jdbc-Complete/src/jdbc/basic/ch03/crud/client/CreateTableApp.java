/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.client;

import jdbc.basic.ch03.crud.serviceimplementation.CrudImplementation;

/**
 *
 * @author PC
 */
public class CreateTableApp {
    public static void main(String[] args) {
        System.out.println("Programa: Creacion Table Employee");
        CrudImplementation crud = new CrudImplementation();
        String msg = crud.createEmployeeTable();
        System.out.println(msg);
    }
}
