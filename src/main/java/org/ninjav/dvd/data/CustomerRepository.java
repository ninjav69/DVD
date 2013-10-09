package org.ninjav.dvd.data;

import org.ninjav.dvd.model.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ninjav
 * Date: 2013/10/08
 * Time: 10:21 PM
 * A DAO object to manage customer entities.
 */
@ApplicationScoped
public class CustomerRepository {
    @Inject
    private EntityManager em;

    public Customer findById(int id) {
        return em.find(Customer.class, id);
    }

    public Customer findByFirstName(String name) {
        TypedQuery<Customer> q = em.createQuery(
                "select c from Customer c where c.firstName = :firstName", Customer.class);
        q.setParameter("firstName", name);
        return q.getSingleResult();
    }

    public Customer findByLastName(String surname) {
        TypedQuery<Customer> q = em.createQuery(
                "select c from Customer c where c.lastName = :lastName", Customer.class);
        q.setParameter("lastName", surname);
        return q.getSingleResult();
    }

    public List<Customer> findAllOrderByName() {
        return em.createQuery(
                "select c from Customer c order by c.lastName, c.firstName", Customer.class).getResultList();
    }
}
