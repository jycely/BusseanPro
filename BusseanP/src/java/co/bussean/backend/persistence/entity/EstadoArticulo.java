/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.backend.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "estadosarticulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoArticulo.findAll", query = "SELECT e FROM EstadoArticulo e")
    , @NamedQuery(name = "EstadoArticulo.findByIdEstadoArticulo", query = "SELECT e FROM EstadoArticulo e WHERE e.idEstadoArticulo = :idEstadoArticulo")
    , @NamedQuery(name = "EstadoArticulo.findByNombreEstadoArticulo", query = "SELECT e FROM EstadoArticulo e WHERE e.nombreEstadoArticulo = :nombreEstadoArticulo")})
public class EstadoArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoArticulo")
    private Integer idEstadoArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoArticulo")
    private String nombreEstadoArticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoArticulo", fetch = FetchType.LAZY)
    private List<Articulo> articuloList;

    public EstadoArticulo() {
    }

    public EstadoArticulo(Integer idEstadoArticulo) {
        this.idEstadoArticulo = idEstadoArticulo;
    }

    public EstadoArticulo(Integer idEstadoArticulo, String nombreEstadoArticulo) {
        this.idEstadoArticulo = idEstadoArticulo;
        this.nombreEstadoArticulo = nombreEstadoArticulo;
    }

    public Integer getIdEstadoArticulo() {
        return idEstadoArticulo;
    }

    public void setIdEstadoArticulo(Integer idEstadoArticulo) {
        this.idEstadoArticulo = idEstadoArticulo;
    }

    public String getNombreEstadoArticulo() {
        return nombreEstadoArticulo;
    }

    public void setNombreEstadoArticulo(String nombreEstadoArticulo) {
        this.nombreEstadoArticulo = nombreEstadoArticulo;
    }

    @XmlTransient
    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoArticulo != null ? idEstadoArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoArticulo)) {
            return false;
        }
        EstadoArticulo other = (EstadoArticulo) object;
        if ((this.idEstadoArticulo == null && other.idEstadoArticulo != null) || (this.idEstadoArticulo != null && !this.idEstadoArticulo.equals(other.idEstadoArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.bussean.backend.persistence.entity.EstadoArticulo[ idEstadoArticulo=" + idEstadoArticulo + " ]";
    }
    
}
