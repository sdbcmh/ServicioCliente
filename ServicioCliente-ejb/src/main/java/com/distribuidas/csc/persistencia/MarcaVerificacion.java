/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "marca_verificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaVerificacion.findAll", query = "SELECT m FROM MarcaVerificacion m"),
    @NamedQuery(name = "MarcaVerificacion.findByIdMarcaverificacion", query = "SELECT m FROM MarcaVerificacion m WHERE m.idMarcaverificacion = :idMarcaverificacion"),
    @NamedQuery(name = "MarcaVerificacion.findByNombreMarcaverificacion", query = "SELECT m FROM MarcaVerificacion m WHERE m.nombreMarcaverificacion = :nombreMarcaverificacion"),
    @NamedQuery(name = "MarcaVerificacion.findByEstadoMarcaverificacion", query = "SELECT m FROM MarcaVerificacion m WHERE m.estadoMarcaverificacion = :estadoMarcaverificacion"),
    @NamedQuery(name = "MarcaVerificacion.findByFechaMarcaverificacion", query = "SELECT m FROM MarcaVerificacion m WHERE m.fechaMarcaverificacion = :fechaMarcaverificacion")})
public class MarcaVerificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MARCAVERIFICACION")
    private Integer idMarcaverificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE_MARCAVERIFICACION")
    private String nombreMarcaverificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO_MARCAVERIFICACION")
    private boolean estadoMarcaverificacion;
    @Column(name = "FECHA_MARCAVERIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMarcaverificacion;
    @ManyToMany(mappedBy = "marcaVerificacionCollection")
    private Collection<ParteServicio> parteServicioCollection;

    public MarcaVerificacion() {
    }

    public MarcaVerificacion(Integer idMarcaverificacion) {
        this.idMarcaverificacion = idMarcaverificacion;
    }

    public MarcaVerificacion(Integer idMarcaverificacion, String nombreMarcaverificacion, boolean estadoMarcaverificacion) {
        this.idMarcaverificacion = idMarcaverificacion;
        this.nombreMarcaverificacion = nombreMarcaverificacion;
        this.estadoMarcaverificacion = estadoMarcaverificacion;
    }

    public Integer getIdMarcaverificacion() {
        return idMarcaverificacion;
    }

    public void setIdMarcaverificacion(Integer idMarcaverificacion) {
        this.idMarcaverificacion = idMarcaverificacion;
    }

    public String getNombreMarcaverificacion() {
        return nombreMarcaverificacion;
    }

    public void setNombreMarcaverificacion(String nombreMarcaverificacion) {
        this.nombreMarcaverificacion = nombreMarcaverificacion;
    }

    public boolean getEstadoMarcaverificacion() {
        return estadoMarcaverificacion;
    }

    public void setEstadoMarcaverificacion(boolean estadoMarcaverificacion) {
        this.estadoMarcaverificacion = estadoMarcaverificacion;
    }

    public Date getFechaMarcaverificacion() {
        return fechaMarcaverificacion;
    }

    public void setFechaMarcaverificacion(Date fechaMarcaverificacion) {
        this.fechaMarcaverificacion = fechaMarcaverificacion;
    }

    @XmlTransient
    public Collection<ParteServicio> getParteServicioCollection() {
        return parteServicioCollection;
    }

    public void setParteServicioCollection(Collection<ParteServicio> parteServicioCollection) {
        this.parteServicioCollection = parteServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarcaverificacion != null ? idMarcaverificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaVerificacion)) {
            return false;
        }
        MarcaVerificacion other = (MarcaVerificacion) object;
        if ((this.idMarcaverificacion == null && other.idMarcaverificacion != null) || (this.idMarcaverificacion != null && !this.idMarcaverificacion.equals(other.idMarcaverificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.distribuidas.csc.persistencia.MarcaVerificacion[ idMarcaverificacion=" + idMarcaverificacion + " ]";
    }
    
}