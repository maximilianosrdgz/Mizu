package mizu.rest;


import mizu.proxy.ProductJsonMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by ms.rodriguez on 20/2/2017.
 */
public abstract class AbstractFacade <T> {

    protected abstract EntityManager getEntityManager();

    public Response create(T entity, String json){
        doCreate(entity);
        return Response.ok().build();
    }

    @Transactional
    private void doCreate(T entity){
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        //entityManager.flush();
        //entityManager.refresh(entity);
    }

}
