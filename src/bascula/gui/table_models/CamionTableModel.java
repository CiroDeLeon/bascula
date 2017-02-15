/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.table_models;

import bascula.entity.Camion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario1
 */
public class CamionTableModel extends AbstractTableModel{
     List<Camion> lista;
    String columns[]={"Placa","Conductor"};    

    public CamionTableModel() {
        lista=new ArrayList<Camion>();
    }
    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Camion a=lista.get(rowIndex);
        switch(columnIndex){
            case 0:return ""+a.getIdCamion();
            case 1:return a.getConductor().getNombres()+" "+a.getConductor().getApellidos();            
            default : return "";    
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return String.class;
            case 1: return String.class;    
            case 2: return Boolean.class;        
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
    
    public Camion getRow(int rowIndex){
        return lista.get(rowIndex);
    }
    public void setLista(List <Camion> lista) {
        this.lista = lista;
    } 
}
