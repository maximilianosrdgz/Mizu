package mizu.rest;

import mizu.jpaModel.Category;
import mizu.jpaModel.Product;
import mizu.proxy.ProductJsonMapper;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by ms.rodriguez on 12/4/2017.
 */
@Path("/category")
public class CategoryFacadeREST extends AbstractFacade <Category> {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    private ProductJsonMapper productJsonMapper = new ProductJsonMapper();

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String echo(@PathParam("input") String input){
        return input;
    }

    @POST
    //@Consumes({"application/json"})
    public Response create(@RequestBody String json){
        Category entity = new Category();
        //entity = productJsonMapper.mapProductFromJson(json);
        entity.setCategoryDescription("Category test");
        entity.setCategoryId(2);
        return super.create(entity, json);
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
