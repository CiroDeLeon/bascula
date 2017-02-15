/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.suscripciones;

import bascula.entity.Tiquete;

/**
 *
 * @author Usuario1
 */
public interface ISuscripcionBuscarTiquete extends Modulo{
    public void EventoDeSeleccionDeTiquete();
    public void AsignarTiquete(Tiquete t);
}
