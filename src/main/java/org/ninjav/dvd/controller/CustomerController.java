package org.ninjav.dvd.controller;

import org.ninjav.dvd.model.Customer;
import org.primefaces.event.SelectEvent;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ninjav
 * Date: 2013/10/08
 * Time: 10:51 PM
 * Controller for the customer selection UI.
 */
@Named
@SessionScoped
public class CustomerController implements Serializable {

    @Inject
    private FacesContext facesContext;

    private Customer selectedCustomer;

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage(
                "Customer Selected", ((Customer) event.getObject()).getFirstName());
        facesContext.addMessage(null, msg);
    }
}
