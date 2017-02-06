/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.com.entities;

import com.entities.MockData;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fred
 */
@Stateless
public class MockDataFacade extends AbstractFacade<MockData> {

    @PersistenceContext(unitName = "kamauPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MockDataFacade() {
        super(MockData.class);
    }
    
}
