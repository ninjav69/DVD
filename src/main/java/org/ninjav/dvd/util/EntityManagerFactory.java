package org.ninjav.dvd.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: ninjav
 * Date: 2013/10/08
 * Time: 10:40 PM
 * Factory for the entity manager.
 */
public class EntityManagerFactory {
    @SuppressWarnings("unused")
    @Produces
    @PersistenceContext
    private EntityManager em;
}
