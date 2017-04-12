package mizu.rest;

import mizu.jpaModel.Product;
import mizu.proxy.ProductJsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by ms.rodriguez on 20/2/2017.
 */
@Path("/product")
public class ProductFacadeREST extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    //@Autowired
    private ProductJsonMapper productJsonMapper = new ProductJsonMapper();

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
            factory = Persistence.createEntityManagerFactory("persistenceUnit");
            em = factory.createEntityManager();

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(product);
            transaction.commit();
        }
        catch(Exception e){e.printStackTrace();}


        return product.toString();
    }

    @POST
    @Consumes({"application/json"})
    public Response create(@RequestBody String json){
        Product entity = null;
        entity = productJsonMapper.mapProductFromJson(json);
        return super.create(entity, json);
    }

    @POST
    @Path("/test-create")
    @Consumes({"application/json"})
    @Produces("application/json")
    public String test(@RequestBody String json){
        Product entity = null;
        entity = productJsonMapper.mapProductFromJson(json);
        return entity.toString();
    }

    @Override
    protected EntityManager getEntityManager(){
        EntityManagerFactory factory = null;

        try{
            factory = Persistence.createEntityManagerFactory("persistenceUnit");
            em = factory.createEntityManager();
        }
        catch(Exception e){e.printStackTrace();}

        return em;
    }

}
