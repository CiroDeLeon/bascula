/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario1
 */
@Entity
@Table(name = "tiquete")
public class Tiquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTiquete")
    private Integer idTiquete;
    
    @JoinColumn(name = "idconductor")
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    private Conductor conductor;
    
    @JoinColumn(name = "idCamion")
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    private Camion camion;
    
    @JoinColumn(name = "idAgricultor")
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    private Agricultor agricultor;
    
    
    @JoinColumn(name = "idProducto")
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    private Producto producto;
    @Column(name = "FechaEntrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PesoEntrada")
    private Double pesoEntrada=0.0;
    @Column(name = "FechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Column(name = "PesoSalida")
    private Double pesoSalida=0.0;

    @Column(name = "Humedad")
    private Double humedad;
    @Column(name = "Impureza")
    private Double impureza;
    @Column(name = "Empaques")
    private Double empaques;
    @Column(name = "Tipo")
    private String tipo;
    @Column(name = "Pendiente")
    private Boolean pendiente=false;

    public Tiquete() {
    }

    public Tiquete(Integer idTiquete) {
        this.idTiquete = idTiquete;
    }

    public Tiquete(Integer idTiquete, Conductor conductor,Camion camion,Producto producto,Agricultor agricultor) {
        this.idTiquete = idTiquete;
        this.conductor = conductor;
        this.camion = camion;
        this.producto = producto;
        this.agricultor=agricultor;
    }

    public Integer getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(Integer idTiquete) {
        this.idTiquete = idTiquete;
    }

    



    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Double getPesoEntrada() {
        return pesoEntrada;
    }

    public void setPesoEntrada(Double pesoEntrada) {
        this.pesoEntrada = pesoEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getPesoSalida() {
        return pesoSalida;
    }

    public void setPesoSalida(Double pesoSalida) {
        this.pesoSalida = pesoSalida;
    }

    public Double getPesoNeto() {
        return new Double(Math.abs(this.getPesoEntrada().doubleValue()-this.getPesoSalida().doubleValue()));
    }

  

    public Double getHumedad() {
        return humedad;
    }

    public void setHumedad(Double humedad) {
        this.humedad = humedad;
    }

    public Double getImpureza() {
        return impureza;
    }

    public void setImpureza(Double impureza) {
        this.impureza = impureza;
    }

    public Double getEmpaques() {
        return empaques;
    }

    public void setEmpaques(Double empaques) {
        this.empaques = empaques;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTiquete != null ? idTiquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.idTiquete == null && other.idTiquete != null) || (this.idTiquete != null && !this.idTiquete.equals(other.idTiquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bascula.entity.Tiquete[ idTiquete=" + idTiquete + " ]";
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

    /**
     * @return the camion
     */
    public Camion getCamion() {
        return camion;
    }

    /**
     * @param camion the camion to set
     */
    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    /**
     * @return the agricultor
     */
    public Agricultor getAgricultor() {
        return agricultor;
    }

    /**
     * @param agricultor the agricultor to set
     */
    public void setAgricultor(Agricultor agricultor) {
        this.agricultor = agricultor;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the pendiente
     */
    public Boolean getPendiente() {
        return pendiente;
    }

    /**
     * @param pendiente the pendiente to set
     */
    public void setPendiente(Boolean pendiente) {
        this.pendiente = pendiente;
    }
    
}
