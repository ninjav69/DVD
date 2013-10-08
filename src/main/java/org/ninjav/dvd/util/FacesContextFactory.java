package org.ninjav.dvd.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * Created with IntelliJ IDEA.
 * User: ninjav
 * Date: 2013/10/08
 * Time: 10:44 PM
 * Factory for faces context.
 */
public class FacesContextFactory {
    @Produces
    @RequestScoped
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
