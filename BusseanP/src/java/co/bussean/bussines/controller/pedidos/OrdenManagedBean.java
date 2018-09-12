/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.pedidos;

import co.bussean.backend.persistence.entity.Orden;
import co.bussean.backend.persistence.facade.OrdenFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author User
 */
@Named(value = "ordenManagedBean")
@Dependent
public class OrdenManagedBean {

    private Orden orden;
    
    @EJB
    private OrdenFacade ordfc;
    
    
    public OrdenManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        orden = new Orden();
    }
    
    public List<Orden> listarOrden() {
        return ordfc.findAll();
    }
    
    public void eliminarOrden(Orden leer){
        try {
            ordfc.remove(leer);
        } catch (Exception e) {
        }
    }
    
    public void registrarOrden(){
        try {
            ordfc.create(orden);
        } catch (Exception e) {
        }
    }
    
    public void modificarOrden(){
        try {
            ordfc.edit(orden);
        } catch (Exception e) {
        }
    }
    
}
