/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.entities;

import entities.BinaryFiles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fred
 */
@Stateless
public class BinaryFilesFacade extends AbstractFacade<BinaryFiles> {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BinaryFilesFacade() {
        super(BinaryFiles.class);
    }
    
}
