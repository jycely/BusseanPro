/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.usuarios;

import co.bussean.backend.persistence.entity.Ciudad;
import co.bussean.backend.persistence.facade.CiudadFacade;
import co.bussean.frontend.converter.util.ManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author User
 */
@Named(value = "ciudadManagedBean")
@RequestScoped
public class CiudadManagedBean implements Serializable, ManagedBean<Ciudad>{

    private Ciudad ciu;
    
    @EJB
    private CiudadFacade facadeciudad;

    public CiudadManagedBean() {
    }

    public Ciudad getCiu() {
        return ciu;
    }

    public void setCiu(Ciudad ciu) {
        this.ciu = ciu;
    }
    
    public List<Ciudad> listarCiudades(){
        return facadeciudad.findAll();
    }

    
    @Override
    public Ciudad getObject(Integer i) {
        return facadeciudad.find(i);
    }

    
}
