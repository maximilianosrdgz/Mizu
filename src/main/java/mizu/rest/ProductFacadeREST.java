package mizu.rest;

import mizu.jpaModel.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.*;

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
