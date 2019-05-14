/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch03.crud.client;

import java.util.Scanner;
import jdbc.basic.ch03.crud.serviceimplementation.CrudImplementation;

/**
 *
 * @author PC
 */
public class DeleteMultipleRows {
    public static void main(String[] args) {
        CrudImplementation crud = new CrudImplementation();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cutOff salary");
        double cutOff = input.nextDouble();
        int updateCount = crud.deleteMultipleRows(cutOff);
        System.out.println("The number of rows deleted: " + updateCount);
    }
}
