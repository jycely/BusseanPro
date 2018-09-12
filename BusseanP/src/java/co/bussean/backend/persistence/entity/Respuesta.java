/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.backend.persistence.entity;

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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "respuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findByIdRespuestaPqr", query = "SELECT r FROM Respuesta r WHERE r.idRespuestaPqr = :idRespuestaPqr")
    , @NamedQuery(name = "Respuesta.findByFecha", query = "SELECT r FROM Respuesta r WHERE r.fecha = :fecha")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRespuestaPqr")
    private Integer idRespuestaPqr;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idRespuestaPqr", referencedColumnName = "idPqr", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Pqr pqr;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuestaPqr) {
        this.idRespuestaPqr = idRespuestaPqr;
    }

    public Respuesta(Integer idRespuestaPqr, String descripcion, Date fecha) {
        this.idRespuestaPqr = idRespuestaPqr;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getIdRespuestaPqr() {
        return idRespuestaPqr;
    }

    public void setIdRespuestaPqr(Integer idRespuestaPqr) {
        this.idRespuestaPqr = idRespuestaPqr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pqr getPqr() {
        return pqr;
    }

    public void setPqr(Pqr pqr) {
        this.pqr = pqr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuestaPqr != null ? idRespuestaPqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespuestaPqr == null && other.idRespuestaPqr != null) || (this.idRespuestaPqr != null && !this.idRespuestaPqr.equals(other.idRespuestaPqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.bussean.backend.persistence.entity.Respuesta[ idRespuestaPqr=" + idRespuestaPqr + " ]";
    }
    
}
