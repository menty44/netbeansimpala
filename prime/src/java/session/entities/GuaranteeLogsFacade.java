/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.entities;

import entities.GuaranteeLogs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fred
 */
@Stateless
public class GuaranteeLogsFacade extends AbstractFacade<GuaranteeLogs> {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuaranteeLogsFacade() {
        super(GuaranteeLogs.class);
    }
    
}