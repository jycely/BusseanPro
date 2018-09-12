/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.bussean.backend.persistence.facade;

import co.bussean.backend.persistence.entity.EstadoArticulo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class EstadoArticuloFacade extends AbstractFacade<EstadoArticulo> {

    @PersistenceContext(unitName = "busseanProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoArticuloFacade() {
        super(EstadoArticulo.class);
    }
    
}
