/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.DAO;

import com.distribuidas.csc.persistencia.TipoServicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Santiago
 */
@Stateless
public class TipoServicioFacade extends AbstractFacade<TipoServicio> {
    @PersistenceContext(unitName = "com.distribuidas_ServicioCliente-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoServicioFacade() {
        super(TipoServicio.class);
    }
    
}