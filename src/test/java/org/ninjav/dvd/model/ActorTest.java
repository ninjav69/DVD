package org.ninjav.dvd.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apickard
 * Date: 10/8/13
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class ActorTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Actor.class.getPackage())
                .addAsWebInfResource("test-ds.xml")
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    @Before
    public void startTransaction() throws Exception {
        utx.begin();
        em.joinTransaction();
    }

    @After
    public void stopTransaction() throws Exception {
        utx.commit();
    }

    @Test
    public void shouldRunTest() {
        System.out.println("Running test...");
    }

    @Test
    public void shouldGetAllActors() {
        System.out.println("Selecting all actors...");

        List<Actor> actors = em.createQuery("select a from Actor a").getResultList();
        for (Actor a : actors) {
            System.out.println(a);
        }

        System.out.println("Done selecting actors.");
    }
}
