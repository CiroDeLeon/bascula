/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.table_models;

import bascula.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario1
 */
public class ProductoTableModel extends AbstractTableModel{
    List<Producto> lista;
     String columns[]={"Codigo","Descripcion"};
     

    public ProductoTableModel() {
        lista=new ArrayList <Producto>();
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p=lista.get(rowIndex);
        switch(columnIndex){
            case 0 : return ""+p.getIdProducto();
            case 1 : return p.getDescripcion();
            default  : return "";    
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return String.class;
            case 1: return String.class;    
            default: return String.class;    
        }
    }    
    @Override
    public String getColumnName(int column) {
        return this.columns[column];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Producto getRow(int rowIndex){
        return lista.get(rowIndex);
    }
    public void setLista(List <Producto> lista) {
        this.lista = lista;
    }
}
