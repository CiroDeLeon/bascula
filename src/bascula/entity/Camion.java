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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "camion")
public class Camion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCamion")
    private String idCamion;

    
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name = "idConductor")
    private Conductor conductor;

    public Camion() {
    }

    public Camion(String idCamion) {
        this.idCamion = idCamion;
    }

    public Camion(String idCamion, Conductor conductor) {
        this.idCamion = idCamion;
        this.conductor = conductor;
    }

    public String getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(String idCamion) {
        this.idCamion = idCamion;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCamion != null ? idCamion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.idCamion == null && other.idCamion != null) || (this.idCamion != null && !this.idCamion.equals(other.idCamion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bascula.entity.Camion[ idCamion=" + idCamion + " ]";
    }

    /**
     * @return the conductor
     */
    public Conductor getConductor() {
        return conductor;
    }

    /**
     * @param conductor the conductor to set
     */
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    
}
