/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.suscripciones;

import bascula.entity.Producto;

/**
 *
 * @author Usuario1
 */
public interface ISuscripcionBuscarProducto extends Modulo{
    public void EventoDeBusquedaDeProducto();
    public void AsignarProducto(Producto p);
}
