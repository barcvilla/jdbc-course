/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.date;

import java.util.List;

/**
 *
 * @author PC
 */
public interface UserService {
    public int insertUser(User user);
    public int insertUser2(User u);
    public List<User> getAllUser();
}
