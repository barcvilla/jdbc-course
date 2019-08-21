/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

import java.util.List;

/**
 *
 * @author PC
 */
public interface PersonService {
    public int insertPerson(Persons p);
    public void getPersonsImage(String name) throws Exception;
}
