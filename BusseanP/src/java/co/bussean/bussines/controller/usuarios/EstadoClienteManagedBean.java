/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.usuarios;

import co.bussean.backend.persistence.entity.EstadoCliente;
import co.bussean.backend.persistence.facade.EstadoClienteFacade;
import co.bussean.frontend.converter.util.ManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author User
 */
@Named(value = "estadoClienteManagedBean")
@RequestScoped
public class EstadoClienteManagedBean implements Serializable, ManagedBean<EstadoCliente> {

    private EstadoCliente estadcliente;
    
    @EJB
    private EstadoClienteFacade estadClifc;
    
    public EstadoClienteManagedBean() {
    }

    public EstadoCliente getEstadCliente() {
        return estadcliente;
    }

    public void setEstadCliente(EstadoCliente estadCliente) {
        this.estadcliente = estadCliente;
    }
    
    @PostConstruct
    public void init(){
        estadcliente = new EstadoCliente();
    }
    
    public List<EstadoCliente> listEstadoCli(){
        return estadClifc.findAll();
    }
    
    @Override
    public EstadoCliente getObject(Integer i) {
        return estadClifc.find(i);
    }

    
}
