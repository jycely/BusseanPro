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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdClienteUsuario", query = "SELECT c FROM Cliente c WHERE c.idClienteUsuario = :idClienteUsuario")
    , @NamedQuery(name = "Cliente.findByNombreLavanderia", query = "SELECT c FROM Cliente c WHERE c.nombreLavanderia = :nombreLavanderia")
    , @NamedQuery(name = "Cliente.findByNumeroLegal", query = "SELECT c FROM Cliente c WHERE c.numeroLegal = :numeroLegal")
    , @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClienteUsuario")
    private Integer idClienteUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreLavanderia")
    private String nombreLavanderia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroLegal")
    private long numeroLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente", fetch = FetchType.LAZY)
    private List<Orden> ordenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente", fetch = FetchType.LAZY)
    private List<Pqr> pqrList;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciudad idCiudad;
    @JoinColumn(name = "idEstadoCliente", referencedColumnName = "idEstadoCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoCliente idEstadoCliente;
    @JoinColumn(name = "idClienteUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(Integer idClienteUsuario) {
        this.idClienteUsuario = idClienteUsuario;
    }

    public Cliente(Integer idClienteUsuario, String nombreLavanderia, long numeroLegal, String direccion) {
        this.idClienteUsuario = idClienteUsuario;
        this.nombreLavanderia = nombreLavanderia;
        this.numeroLegal = numeroLegal;
        this.direccion = direccion;
    }

    public Integer getIdClienteUsuario() {
        return idClienteUsuario;
    }

    public void setIdClienteUsuario(Integer idClienteUsuario) {
        this.idClienteUsuario = idClienteUsuario;
    }

    public String getNombreLavanderia() {
        return nombreLavanderia;
    }

    public void setNombreLavanderia(String nombreLavanderia) {
        this.nombreLavanderia = nombreLavanderia;
    }

    public long getNumeroLegal() {
        return numeroLegal;
    }

    public void setNumeroLegal(long numeroLegal) {
        this.numeroLegal = numeroLegal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    @XmlTransient
    public List<Pqr> getPqrList() {
        return pqrList;
    }

    public void setPqrList(List<Pqr> pqrList) {
        this.pqrList = pqrList;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public EstadoCliente getIdEstadoCliente() {
        return idEstadoCliente;
    }

    public void setIdEstadoCliente(EstadoCliente idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteUsuario != null ? idClienteUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idClienteUsuario == null && other.idClienteUsuario != null) || (this.idClienteUsuario != null && !this.idClienteUsuario.equals(other.idClienteUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.bussean.backend.persistence.entity.Cliente[ idClienteUsuario=" + idClienteUsuario + " ]";
    }
    
}
