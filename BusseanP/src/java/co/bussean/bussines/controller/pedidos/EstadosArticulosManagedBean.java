/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.pedidos;

import co.bussean.backend.persistence.entity.TipoArticulo;
import co.bussean.backend.persistence.facade.TipoArticuloFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author User
 */
@Named(value = "estadosArticulosManagedBean")
@RequestScoped
public class EstadosArticulosManagedBean {

    private TipoArticulo tipoArt;
    
    @EJB
    private TipoArticuloFacade tArtfc;
    
    public EstadosArticulosManagedBean() {
    }

    public TipoArticulo getTipoArt() {
        return tipoArt;
    }

    public void setTipoArt(TipoArticulo tipoArt) {
        this.tipoArt = tipoArt;
    }
    
    @PostConstruct
    public void init (){
        tipoArt = new TipoArticulo();
    }
    
    
}
