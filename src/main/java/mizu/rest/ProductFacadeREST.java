package mizu.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by ms.rodriguez on 20/2/2017.
 */
@Path("/product")
public class ProductFacadeREST extends AbstractFacade {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String echo(@PathParam("input") String input){
        return input;
    }

}
