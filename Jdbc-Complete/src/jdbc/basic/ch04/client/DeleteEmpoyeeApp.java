/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch04.client;

import java.util.Scanner;
import jdbc.basic.ch04.service.EmployeeService;
import jdbc.basic.ch04.service.EmployeeServiceImplementation;

/**
 *
 * @author PC
 */
public class DeleteEmpoyeeApp 
{
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImplementation();
        Scanner input = new Scanner(System.in);
        System.out.println("Id employee to delete");
        int id = input.nextInt();
        int updateCount = service.deleteEmployee(id);
        System.out.println("# of rows deleted is: " + updateCount);
    }
}
