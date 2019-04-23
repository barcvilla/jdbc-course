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
public class InsertSingleRow {
    public static void main(String[] args) {
        System.out.println("Insert fixed Employee record");
        CrudImplementation crud = new CrudImplementation();
        int updateCount = crud.insertFixedEmployee();
        System.out.println("Se ha registrado " + updateCount + " Employee");
    }
}
