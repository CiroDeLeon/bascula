/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula;

import bascula.hardware.strategy.BasculaStandard;



/**
 *
 * @author Usuario1
 */
public class Bascula {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args){
        // TODO code application logic here        
        if(new bascula.OneInstanceManagerAplication().comprobar()){
            BasculaStandard.CargarDLL();     
            bascula.gui.Principal p=new bascula.gui.Principal();
            p.setVisible(true);
        }else{
            System.exit(0);
        }
       
       
} 
    
    
}
