/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.suscripciones;

import bascula.entity.Conductor;

/**
 *
 * @author Usuario1
 */
public interface ISuscripcionBuscarConductor extends Modulo{
    public void EventoDeSeleccionDeConductor();
    public void AsignarConductor(Conductor c);
}
