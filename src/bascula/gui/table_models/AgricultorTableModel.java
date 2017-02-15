/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.gui.table_models;

import bascula.entity.Agricultor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario1
 */
public class AgricultorTableModel extends AbstractTableModel{
    List<Agricultor> lista;
    String columns[]={"Nit/Cedula","Agricultor","Naturaleza"};    

    public AgricultorTableModel() {
        lista=new ArrayList<Agricultor>();
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
        Agricultor a=lista.get(rowIndex);
        switch(columnIndex){
            case 0:return a.getIdAgricultor();
            case 1:return a.getSimpleName();
            case 2:return a.getNaturaleza();
            default : return "";    
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
    
    public Agricultor getRow(int rowIndex){
        return lista.get(rowIndex);
    }
    public void setLista(List <Agricultor> lista) {
        this.lista = lista;
    }
}
