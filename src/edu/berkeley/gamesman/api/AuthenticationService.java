package edu.berkeley.gamesman.api;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;

@Path("authenticate")
public class AuthenticationService {

    @GET
    public String authenticate(@MatrixParam("username") String username,
                               @MatrixParam("password") String password) {
        return "Credentials[username=" + username + "; password=" + password +"]";
    }
}
