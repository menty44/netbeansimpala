/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.entities;

import entities.SmsMailings;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fred
 */
@Stateless
public class SmsMailingsFacade extends AbstractFacade<SmsMailings> {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SmsMailingsFacade() {
        super(SmsMailings.class);
    }
    
}
