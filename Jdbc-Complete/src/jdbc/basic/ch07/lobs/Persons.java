/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

import java.io.FileInputStream;

/**
 *
 * @author PC
 */
public class Persons {
    private String name;
    private FileInputStream pic;

    public Persons() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileInputStream getPic() {
        return pic;
    }

    public void setPic(FileInputStream pic) {
        this.pic = pic;
    }
    
    
}
