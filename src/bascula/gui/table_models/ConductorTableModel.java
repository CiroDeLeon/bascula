/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.table_models;

import bascula.entity.Conductor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario1
 */
public class ConductorTableModel extends AbstractTableModel{
     List<Conductor> lista;
    String columns[]={"Nit/Cedula","Descripcion","Reportado"};    

    public ConductorTableModel() {
        lista=new ArrayList<Conductor>();
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
        Conductor a=lista.get(rowIndex);
        switch(columnIndex){
            case 0:return ""+a.getIdConductor();
            case 1:return a.getNombres()+" "+a.getApellidos();
            case 2:return a.getReportado();
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
    
    public Conductor getRow(int rowIndex){
        return lista.get(rowIndex);
    }
    public void setLista(List <Conductor> lista) {
        this.lista = lista;
    } 
}
