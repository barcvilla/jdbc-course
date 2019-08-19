/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.date;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class User {
    private String name;
    private Date dop;
    
    public User(String name, Date dop)
    {
        this.name = name;
        this.dop = dop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDop() {
        return dop;
    }

    public void setDop(Date dop) {
        this.dop = dop;
    }
    
    
}
