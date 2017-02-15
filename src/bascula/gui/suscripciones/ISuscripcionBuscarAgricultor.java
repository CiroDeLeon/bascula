/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.suscripciones;

import bascula.entity.Agricultor;


/**
 *
 * @author Usuario1
 */
public interface ISuscripcionBuscarAgricultor extends Modulo{
    public void EventoDeBusquedaDeAgricultor();
    public void AsignarAgricultor(Agricultor a);
}
