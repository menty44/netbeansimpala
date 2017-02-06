/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.entities;

import entities.ExternalTransferImports;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fred
 */
@Stateless
public class ExternalTransferImportsFacade extends AbstractFacade<ExternalTransferImports> {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExternalTransferImportsFacade() {
        super(ExternalTransferImports.class);
    }
    
}
