/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.DAO;

import com.distribuidas.persistencia.Modelo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sbenalcazar
 */
@Stateless
public class ModeloFacade extends AbstractFacade<Modelo> {
    @PersistenceContext(unitName = "com.distribuidas_ServicioCliente-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloFacade() {
        super(Modelo.class);
    }
    
}
