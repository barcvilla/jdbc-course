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
public class DropTableApp {
    public static void main(String[] args) {
        System.out.println("Programa: Eliminacion Table Employee");
        CrudImplementation crud = new CrudImplementation();
        String msg = crud.dropEmployeeTable();
        System.out.println(msg);
    }
}
