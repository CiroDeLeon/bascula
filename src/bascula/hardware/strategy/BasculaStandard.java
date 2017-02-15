/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bascula.hardware.strategy;


import bascula.Bascula;
import bascula.hardware.IBasculaStrategy;
import bascula.hardware.ParametrosDeBascula;
import bascula.hardware.ParametrosDeBasculaLoader;
import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario1
 */
public class BasculaStandard implements IBasculaStrategy{
    Com com=null;
    public BasculaStandard(){
       
    }
    public void Init() throws Exception{
       com=null;
       ParametrosDeBascula b=new ParametrosDeBasculaLoader().ObtenerBascula();       
       Parameters params=b.getParametros();             
       System.out.println(params.getPort()+" "+params.getBaudRate()+" "+params.getParity());        
       Parameters param=new Parameters();
       param.setPort(params.getPort());
       param.setBaudRate(Baud._9600);
       
       System.out.println(param.getStopBits());
       
       com=new Com(param);        
    }
    
    @Override
    public double ObtenerPeso() {                       
        try {
            this.Init();
            String val="";
            String letra;            
            com.sendSingleData(80);            
            do{
                letra=com.receiveSingleString();                
            }while(letra.equals("")==true);            
            
            do{
                val=val+letra;
                letra=com.receiveSingleString();                
            }while(letra.equals("")==false);            
            String rta=val;
            double d=Double.parseDouble(rta);
            return d ;
        } catch (Exception ex) {
            Logger.getLogger(BasculaStandard.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }finally{
            try {
                com.close();
            } catch (Exception ex) {
                Logger.getLogger(BasculaStandard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
    public void VerPuertosSerialesLibres(){
        SerialPort free = new SerialPort(); 
       List<String> portList; 
        try {
            portList = free.getFreeSerialPort();            
       for (String string : portList) { 
         System.out.println(string); 
       }
       } catch (Exception ex) {
            Logger.getLogger(Bascula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void CargarDLL(){
      try {
          String curDir = System.getProperty("user.dir"); 
          String libpath = System.getProperty("java.library.path");
          System.out.println(libpath);          
    	  libpath =libpath+";"+curDir+"\\giovynet\\";    
          try {
              System.setProperty("java.library.path",libpath);                 
              Thread.sleep(500);
          } catch (InterruptedException ex) {
              Logger.getLogger(BasculaStandard.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          libpath = System.getProperty("java.library.path");
          System.load(curDir+"\\giovynet\\libSerialPort.dll");    
          System.out.println(libpath);          
         }catch (UnsatisfiedLinkError e) {
             System.err.println("Native code library failed to load.\n" + e);
             JOptionPane.showMessageDialog(null,e.getMessage());
         }
   } 
    
    
}
