/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.hardware;

import bascula.hardware.strategy.BasculaStandard;

/**
 *
 * @author Usuario1
 */
public class BasculaService {
    IBasculaStrategy strategy;
   public BasculaService() throws Exception {    
       strategy=new BasculaStandard();
   }   
   public double ObtenerPeso(){
       return strategy.ObtenerPeso();
   }
}
