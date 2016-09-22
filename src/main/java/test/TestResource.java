package test;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/message")
@Produces("application/json")
@Service
public class TestResource {

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {
        return Response.status(200).entity(null).build();
    }

}