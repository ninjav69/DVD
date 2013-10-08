package org.ninjav.dvd.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: ninjav
 * Date: 2013/10/08
 * Time: 10:43 PM
 * Factory for a logger.
 */
public class LoggerFactory {
    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
