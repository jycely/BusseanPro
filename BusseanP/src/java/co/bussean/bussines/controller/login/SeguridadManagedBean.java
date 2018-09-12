/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.login;

import co.bussean.backend.persistence.entity.Permiso;
import co.bussean.backend.persistence.entity.Rol;
import co.bussean.backend.persistence.entity.Usuario;
import co.bussean.backend.persistence.facade.RolFacade;
import co.bussean.backend.persistence.facade.UsuarioFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@Named(value = "seguridadManagedBean")
@RequestScoped
public class SeguridadManagedBean implements Serializable {

    private Usuario usuario;

    @EJB
    private UsuarioFacade usufc;

    @EJB
    private RolFacade rf;

    public SeguridadManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public void verificarSesion() {
        try {
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (user == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../faces/permisos.xhtml?faces-redirect=true");
            }
            //Filter
            Usuario u = usufc.find(Integer.valueOf(user.getId()));
            if (!verificarPermisos(rf.find(Integer.valueOf(u.getIdRol().getId())))) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../faces/permisos.xhtml?faces-redirect=true");
            }
        } catch (Exception e) {

        }
    }

//Filter
    private boolean verificarPermisos(Rol r) {
        boolean perm = false;
        System.out.println("Rol: " + r.getNombreRol());
        FacesContext fc = FacesContext.getCurrentInstance();
        String url = "/expochick" + fc.getExternalContext().getRequestPathInfo();
        for (Permiso p : r.getPermisoList()) {
            if (p.getNombrePermiso() != null && p.getUrl() != null && p.getUrl().equals(url)) {
                perm = true;
                break;
            }
        }
        return perm;
    }

    public String cerrarSesion() {
        //usuario = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/faces/index.xhtml?faces-redirect=true";
    }

}
