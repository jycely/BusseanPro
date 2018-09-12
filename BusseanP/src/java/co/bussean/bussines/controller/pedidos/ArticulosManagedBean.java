/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.pedidos;

import co.bussean.backend.persistence.facade.ArticuloFacade;
import co.bussean.backend.persistence.entity.Articulo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author User
 */
@Named(value = "articulosManagedBean")
@RequestScoped
public class ArticulosManagedBean {

    private Articulo arti;

    @EJB
    private ArticuloFacade artfc;

    public ArticulosManagedBean() {
    }

    public Articulo getArti() {
        return arti;
    }

    public void setArti(Articulo arti) {
        this.arti = arti;
    }

    @PostConstruct
    public void init() {
        arti = new Articulo();
    }

    public List<Articulo> listarArticulo() {
        return artfc.findAll();
    }
    
    public void eliminarArticulo(Articulo leer){
        try {
            artfc.remove(leer);
        } catch (Exception e) {
        }
    }
    
    public void registrarArticulo(){
        try {
            artfc.create(arti);
        } catch (Exception e) {
        }
    }
    
    public void modificarArticulo(){
        try {
            artfc.edit(arti);
        } catch (Exception e) {
        }
    }
    
}
