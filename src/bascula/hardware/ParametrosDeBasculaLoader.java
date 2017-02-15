/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bascula.hardware;

import giovynet.serial.Baud;
import giovynet.serial.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Usuario1
 */
public class ParametrosDeBasculaLoader {    
    ParametrosDeBascula b;
    public ParametrosDeBasculaLoader() {
    }
    private Properties getProperties() {
        try
        {
            //se crea una instancia a la clase Properties
            Properties propiedades = new Properties();
            //se leen el archivo .properties 
            String curDir = System.getProperty("user.dir");
            FileInputStream fis=new FileInputStream(curDir+"\\Bascula.properties");
            propiedades.load(fis);
            //si el archivo de propiedades NO esta vacio retornan las propiedes leidas
            if (!propiedades.isEmpty()){                
                return propiedades;
            } else {//sino  retornara NULL
                return null;
            }
        } catch (IOException ex) {
            return null;
        }
   }
    public ParametrosDeBascula ObtenerBascula(){
       try {
           Properties pro=this.getProperties();
           Parameters p=new Parameters();
           p.setPort(pro.getProperty("port"));           
           Baud baud=Baud.valueOf("_"+pro.getProperty("baudrate"));                      
           p.setBaudRate(baud);         
           p.setParity(pro.getProperty("parity"));
           p.setStopBits(pro.getProperty("stop_bits"));
           p.setByteSize(pro.getProperty("data_bits"));           
           b=new ParametrosDeBascula(p);
           return b;
       } catch (Exception ex) {
           Logger.getLogger(BasculaService.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
   }
}
