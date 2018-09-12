/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.backend.persistence.facade;

import co.bussean.backend.persistence.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "busseanProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    //Iniciar Sesión
    public Usuario iniciarSesion(Usuario user) {
        Usuario usuario = null;
        //String rta;
        try {
            //rta = "FROM Usuarios u WHERE u.cedula = ?1 and u.clave = ?2";
            Query query = em.createQuery("FROM Usuarios u WHERE u.cedula = ?1 and u.clave = ?2");
            query.setParameter(1, user.getCedula());
            query.setParameter(2, user.getClave());
            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
            System.out.println(usuario);
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }
    //Iniciar Sesión
    
    //Capturar un solo usuario / Cedula
    public Usuario capturarUsuario(Usuario usu) {
        return getEntityManager().createNamedQuery("Usuario.findByCedula", Usuario.class).setParameter("cedula", usu.getCedula()).getSingleResult();
    }
    //Capturar un solo usuario / Cedula



}
