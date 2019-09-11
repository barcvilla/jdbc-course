/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.basic.ch09.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class IniFile {
    private static final String PROPERTY_FILE = "db.properties";
    
    public static Properties getPropertyFile()
    {
        Properties prop = new Properties();
        try
        {
            FileInputStream fis = new FileInputStream(PROPERTY_FILE);
            prop.load(fis);
        }
        catch(IOException ex)
        {
            Logger.getLogger(IniFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop;
    }
}
