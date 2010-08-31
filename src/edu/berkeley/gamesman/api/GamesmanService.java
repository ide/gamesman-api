package edu.berkeley.gamesman.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

import com.google.inject.Inject;

@Path("{game}")
@Produces("text/plain")
public class GamesmanService {

    @PathParam("game")
    private String game;

    @PathParam("game")
    private PathSegment gameSegment;

    private final GamesmanApi api;

    @Inject
    public GamesmanService(GamesmanApi api) {
        this.api = api;
    }

    @GET
    @Path("move-value")
    public String getMoveValue(@Context UriInfo info) {
        MultivaluedMap<String, String> boardParameters =
            getMatrixParametersForSegment("move-value", info);
        return boardParameters.toString();
    }

    /**
     * Extracts the matrix parameters from the specified URI path segment.
     * Unfortunately, it is not possible to use {@code @PathParam} to extract
     * the path segment of an unnamed {@code @Path} (that is, a {@code @Path}
     * whose value is constant, not a variable).
     * <p>
     * If multiple path segments share the same value, it is not defined which
     * segment's matrix parameters are returned.
     * @param   path    the value of the path segment whose parameters to get
     * @param   info    context about the request URI
     * @return  the matrix parameters of the specified path segment
     * @throws  MissingPathSegmentException if there is no segment with the
     *          specified path in the given URI
     */
    private MultivaluedMap<String, String> getMatrixParametersForSegment(
            String path, UriInfo info) {
        // Search through each path segment in the URI for the specified one.
        List<PathSegment> pathSegments = info.getPathSegments();
        for (PathSegment segment : pathSegments) {
            if (segment.getPath().equals(path)) {
                return segment.getMatrixParameters();
            }
        }

        String error = "no path segment for \"%s\" found in URI \"%s\"";
        error = String.format(error, path, info.getPath());
        throw new MissingPathSegmentException(error);
    }

    protected MultivaluedMap<String, String> getGameParameters() {
        return getGameSegment().getMatrixParameters();
    }

    protected String getGame() {
        return game;
    }

    protected PathSegment getGameSegment() {
        return gameSegment;
    }

    protected GamesmanApi getApi() {
        return api;
    }
}
