/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.suscripciones;

import bascula.entity.Camion;

/**
 *
 * @author Usuario1
 */
public interface ISuscripcionBuscarCamion extends Modulo{
    public void EventoDeSeleccionDeCamion();
    public void AsignarCamion(Camion c);
}
