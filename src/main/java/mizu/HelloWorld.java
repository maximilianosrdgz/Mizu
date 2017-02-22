package mizu;
import mizu.jpaModel.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {
        return input;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) {
        input.setVal2(input.getVal1());
        return Response.ok().entity(input).build();
    }

    @POST
    @Produces("text/plain")
    @Path("/persist")
    public String persist() {

        EntityManagerFactory factory = null;
        EntityManager em = null;
        Product product = new Product();

        try{
            factory = Persistence.createEntityManagerFactory("unit");
            em = factory.createEntityManager();

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(product);
            transaction.commit();
        }
        catch(Exception e){e.printStackTrace();}


        return product.toString();
    }
}

