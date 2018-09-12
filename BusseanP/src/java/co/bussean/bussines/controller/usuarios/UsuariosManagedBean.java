/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.bussines.controller.usuarios;

import co.bussean.backend.persistence.entity.Cliente;
import co.bussean.backend.persistence.facade.UsuarioFacade;
import co.bussean.backend.persistence.entity.Usuario;
import co.bussean.backend.persistence.facade.ClienteFacade;
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
@Named(value = "usuariosManagedBean")
@RequestScoped
public class UsuariosManagedBean implements Serializable, ManagedBean<Usuario> {

    private Usuario usuario;

    private Cliente cliente;

    @EJB
    private UsuarioFacade usufc;
    
    @EJB
    private ClienteFacade clifc;


    public UsuariosManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        cliente = new Cliente();

    }

    public List<Usuario> listarUsuarios() {
        return usufc.findAll();
    }

    public void eliminarUsuario(Usuario usuario) {
        try {
            //usufc.remoe(usuario);
        } catch (Exception e) {
        }
    }

    public void seleccionarUsu(Usuario leer) {
        usuario = leer;
        usufc.find(leer.getIdUsuario());
    }

    public void modificarUsuario() {
        try {
            usufc.edit(usuario);
        } catch (Exception e) {
            System.out.println("ERROR - MODIFICAR USUARIO ! ");
        }
    }
    
   public void seleccionarUser(Usuario leer){
        clifc.find(leer.getCliente().getIdClienteUsuario());
   }

    public void modificarCliente() {
        try {
            System.out.println(getUsuario().getIdUsuario()+"OOO");
            System.out.println("lolololo - " + getCliente().getIdClienteUsuario());
            clifc.edit(cliente);
        } catch (Exception e) {
            System.out.println("SORRRYYY SORRRY SOORRRYYYY");
        }
    }


    @Override
    public Usuario getObject(Integer i) {
        return usufc.find(i);
    }

}
