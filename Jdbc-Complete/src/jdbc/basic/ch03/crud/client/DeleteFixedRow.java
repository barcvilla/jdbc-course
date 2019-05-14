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
public class DeleteFixedRow {
    public static void main(String[] args) {
        System.out.println("Delete fixed Employee record");
        CrudImplementation crud = new CrudImplementation();
        int updateCount = crud.deleteFixedEmployee();
        System.out.println("Se ha eliminado " + updateCount + " registo(s)");
    }
}
