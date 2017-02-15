/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.table_models;

import bascula.entity.Tiquete;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario1
 */
public class TiqueteTableModel extends AbstractTableModel{
     List<Tiquete> lista;
     String columns[]={"Tiquete","Agricultor","Camion","Conductor","Producto","Peso Neto","Humedad","Impureza","Pendiente"};
     public TiqueteTableModel() {
        lista=new ArrayList <Tiquete>();
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
        Tiquete t=lista.get(rowIndex);
        switch(columnIndex){
            case 0 : return ""+t.getIdTiquete();
            case 1 : return t.getAgricultor().getSimpleName();
            case 2 : return t.getCamion().getIdCamion();
            case 3 : return t.getConductor().getNombres()+" "+t.getConductor().getApellidos();
            case 4 : return t.getProducto().getDescripcion();
            case 5 : return t.getPesoNeto();
            case 6 : return t.getHumedad();
            case 7 : return t.getImpureza();
            case 8 : return t.getPendiente();
            default  : return "";    
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 5: return Double.class;
            case 6: return Double.class;    
            case 7: return Double.class;        
            case 8: return Boolean.class;            
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
    
    public Tiquete getRow(int rowIndex){
        return lista.get(rowIndex);
    }
    public void setLista(List <Tiquete> lista) {
        this.lista = lista;
    }
}
