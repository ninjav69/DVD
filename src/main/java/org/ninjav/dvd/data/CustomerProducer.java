package org.ninjav.dvd.data;

import org.ninjav.dvd.model.Customer;
import org.primefaces.model.SelectableDataModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ninjav
 * Date: 2013/10/08
 * Time: 10:29 PM
 * Provides a model for UI controls.
 */
@RequestScoped
public class CustomerProducer {
    @Inject
    private CustomerRepository customerRepository;

    private CustomerDataModel customerModel;

    @Produces
    @Named
    public CustomerDataModel getCustomers() {
        return customerModel;
    }

    @PostConstruct
    public void retrieveAllCustomersOrderedByName() {
        customerModel = new CustomerDataModel(customerRepository);
    }
}
