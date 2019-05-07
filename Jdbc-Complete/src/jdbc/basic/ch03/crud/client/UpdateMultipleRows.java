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
public class UpdateMultipleRows {
    public static void main(String[] args) {
        int updateCount = 0;
        CrudImplementation crud = new CrudImplementation();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter increment amount");
        double increment = input.nextDouble();
        System.out.println("Enter Salary range");
        double range = input.nextDouble();
        updateCount += crud.updateMultipleRows(increment, range);
        System.out.println("El numero de filas actualizadas: " + updateCount);
    }
}
