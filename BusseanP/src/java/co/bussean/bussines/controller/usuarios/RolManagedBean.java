/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.usuarios;

import co.bussean.backend.persistence.entity.Rol;
import co.bussean.backend.persistence.facade.RolFacade;
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
@Named(value = "rolManagedBean")
@RequestScoped
public class RolManagedBean implements Serializable, ManagedBean<Rol> {
    
    private Rol rol;
    
    @EJB
    private RolFacade rolfc;
    
    public RolManagedBean() {
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
     @PostConstruct
    public void init(){
        rol = new Rol();
    }
    
    public List<Rol> listarRol(){
        return rolfc.findAll();
    }

    @Override
    public Rol getObject(Integer i) {
        return rolfc.find(i);
    }
    
}
