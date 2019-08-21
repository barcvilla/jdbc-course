/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch07.lobs;

import java.io.File;

/**
 *
 * @author PC
 */
public class Ini {
    private static final String PROPERTY_FILE1 = "Java_Developer_profile.jpg";
    private static final String PROPERTY_FILE2 = "Admiral.properties";
    private static final String PROPERTY_FILE3 = "javatestfile.txt";
    private static String path = "";
    
    public static String getPropertyFile1()
    {
        path = System.getProperty("user.home");
        path += File.separator;
        return path += PROPERTY_FILE1;
    }
    
    public static String getPropertyFile2()
    {
        path = System.getProperty("user.home");
        path += File.separator;
        return path += PROPERTY_FILE2;
    }
    
    public static String getPropertyFile3()
    {
        path = System.getProperty("user.home");
        path += File.separator;
        return path += PROPERTY_FILE3;
    }
}
