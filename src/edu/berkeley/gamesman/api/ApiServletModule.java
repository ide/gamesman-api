package edu.berkeley.gamesman.api;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * A Guice module that registers the resource classes used to handle requests to
 * the Gamesman API. The base URI of the services provided by the resource
 * classes is {@value #BASE_URI}.
 *
 * @author James Ide
 */
public class ApiServletModule extends ServletModule {

    private static final String BASE_URI = "/api/";

    @Override
    protected void configureServlets() {
        bind(GamesmanApi.class).to(MockGamesmanApi.class);
        bind(GamesmanService.class);
        bind(AuthenticationService.class);

        serve(BASE_URI + "*").with(GuiceContainer.class);
    }
}
