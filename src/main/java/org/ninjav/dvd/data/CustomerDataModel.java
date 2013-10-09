package org.ninjav.dvd.data;

import org.ninjav.dvd.model.Customer;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ninjav
 * Date: 2013/10/08
 * Time: 11:26 PM
 * JSF and Primefaces needs this to be able to handle selections on tables.
 */
public class CustomerDataModel extends ListDataModel<Customer> implements SelectableDataModel<Customer> {
    private CustomerRepository customerRepository;

    public CustomerDataModel(CustomerRepository customerRepository) {
        super(customerRepository.findAllOrderByName());
        this.customerRepository = customerRepository;
    }

    @Override
    public Object getRowKey(Customer customer) {
        return customer.getCustomerId();
    }

    @Override
    public Customer getRowData(String s) {
        return customerRepository.findById(Integer.parseInt(s));
    }
}
