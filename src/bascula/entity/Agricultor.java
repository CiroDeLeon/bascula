/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "agricultor")
public class Agricultor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id    
    @Basic(optional = false)
    @Column(name = "idAgricultor")
    private Long idAgricultor;
    @Column(name = "Nombres")
    private String nombres;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Naturaleza")
    private String naturaleza;
    @Column(name = "RazonSocial")
    private String razonSocial;

    public Agricultor() {
    }

    public Agricultor(Long idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public Long getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(Long idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgricultor != null ? idAgricultor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agricultor)) {
            return false;
        }
        Agricultor other = (Agricultor) object;
        if ((this.idAgricultor == null && other.idAgricultor != null) || (this.idAgricultor != null && !this.idAgricultor.equals(other.idAgricultor))) {
            return false;
        }
        return true;
    }
    public String getSimpleName(){
        if(this.getNaturaleza().toLowerCase().equals("Persona Natural".toLowerCase())){
           return this.nombres+" "+this.apellidos;
        }else{
           return this.razonSocial; 
        }
    }
    @Override
    public String toString() {
        return "bascula.entity.Agricultor[ idAgricultor=" + idAgricultor + " ]";
    }
    
}
