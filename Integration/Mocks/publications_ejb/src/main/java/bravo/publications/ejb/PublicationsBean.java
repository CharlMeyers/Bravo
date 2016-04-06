/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.publications.ejb;

import bravo.publications.entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class PublicationsBean {
    public void addPublication(String title, String staffNumber) {
        PublicationEntity publication = new PublicationEntity(title, staffNumber);
        em.persist(publication);
    }
    
    public List<String> getTitle(String staffNumber) {
        List<String> title = (List<String>) em.createNamedQuery("getTitle").getResultList();
        return title;
    }

    @PersistenceContext
    private EntityManager em;
}
