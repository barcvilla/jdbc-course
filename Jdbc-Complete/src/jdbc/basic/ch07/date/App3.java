/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class App3 {
    public static void main(String[] args) {
        UserService service = new UserImpl();
        List<User> users = new ArrayList<User>();
        System.out.println("Listado de Usuarios");
        users = service.getAllUser();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        for(User u : users)
        {
            System.out.println("Nombre: " + u.getName()+ " fecha: " + sdf.format(u.getDop()));
            
        }
    }
}
