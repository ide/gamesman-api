package edu.berkeley.gamesman;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import edu.berkeley.gamesman.api.ApiServletModule;

/**
 * A servlet listener that configures Guice bindings when the Web application
 * context is initialized. Guice's dependency injection encourages modularity
 * in our code and fewer hard-coded dependencies. This facilitates testing the
 * RESTful resource providers independently of the server back-end from which
 * game information is queried.
 * 
 * @author ide
 */
public class GamesmanGuiceServletContextListener extends
        GuiceServletContextListener {
    
    protected Injector getInjector() {
        return Guice.createInjector(new ApiServletModule());
    }
}
