package edu.berkeley.gamesman.api;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * A Guice module that registers the resource classes used to handle requests
 * to the Gamesman API.
 * 
 * @author ide
 */
public class ApiServletModule extends ServletModule {
    
    @Override
    protected void configureServlets() {
        bind(GamesmanService.class);
        bind(AuthenticationService.class);
        
        serve("/api/*").with(GuiceContainer.class);
    }
}
