/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.login;

import co.bussean.backend.persistence.entity.Rol;
import co.bussean.backend.persistence.entity.Usuario;
import co.bussean.backend.persistence.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Usuario usuario;
    private Rol rol;
    
    private String clave1;
    private String clave2;
    
    @EJB
    private UsuarioFacade usufc;
    
    
    public LoginManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getClave1() {
        return clave1;
    }

    public void setClave1(String clave1) {
        this.clave1 = clave1;
    }

    public String getClave2() {
        return clave2;
    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }
 
    @PostConstruct
    public void init() {
        rol = new Rol();
        usuario = new Usuario();
        clave1 = new String();
        clave2 = new String();
    }

    //Método Iniciar Sesión y Direccionamiento Pages
    public String iniciarSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();

        try {
            usuario = usufc.iniciarSesion(usuario);
            if (usuario != null) {
                rol = usuario.getIdRol();
                System.out.println(usuario.getIdRol());
                fc.getExternalContext().getSessionMap().put("user", usuario);
                fc.getExternalContext().getSessionMap().put("rol", rol); //Objeto de la sesion ROL!

                Usuario user = usufc.capturarUsuario(usuario);
                switch (user.getIdRol().getIdRol()) {
                    case 1:
                        System.out.println("ROL ADMINISTRADOR");
                        return "Accedio";
                    case 2:
                        System.out.println("ROL CLIENTE");
                           return "/busseanPro/protegido/cliente/inicio.xhtml?faces-redirect=true";
                    default:
                        System.out.println("ROL ______");
                        return "/busseanPro/protegido/rol/inicio.xhtml?faces-redirect=true";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario y/o Contraseña Incorrectos"));
                usuario = new Usuario();
                rol = new Rol();
                return "";
            }
        } catch (Exception e) {
            System.out.println("NO INGRESO AL SISTEMA");
            return "";
        }
//        return null;
    }

    
}
