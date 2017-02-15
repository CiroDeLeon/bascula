/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bascula.hardware;

import giovynet.serial.Parameters;



/**
 *
 * @author Usuario1
 */
public class ParametrosDeBascula{
    private Parameters parametros;    

    public ParametrosDeBascula(Parameters parametros) {
        this.parametros = parametros;        
    }
    private ParametrosDeBascula(){        
    }

    /**
     * @return the parametros
     */
    public Parameters getParametros() {
        return parametros;
    }

    /**
     * @param parametros the parametros to set
     */
    public void setParametros(Parameters parametros) {
        this.parametros = parametros;
    }
}
