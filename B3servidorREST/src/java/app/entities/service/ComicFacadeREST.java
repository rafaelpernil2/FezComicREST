/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities.service;

import app.entities.Comic;
import app.entities.ComicHasSerie;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rafaelpernil
 */
@Stateless
@Path("app.entities.comic")
public class ComicFacadeREST extends AbstractFacade<Comic> {

    @PersistenceContext(unitName = "B3servidorRESTPU")
    private EntityManager em;

    public ComicFacadeREST() {
        super(Comic.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void create(Comic entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void edit(@PathParam("id") Integer id, Comic entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Comic find(@PathParam("id") Integer id) {
        return super.find(id);
    }
     @GET
    @Path("nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Comic findComics(@PathParam("nombre") String nombre) {
        //app.entities.ComicHasSeriePK key = getPrimaryKey(id);
        
         Query q = em.createNamedQuery("Comic.findByNombre");
         q.setParameter("nombre", nombre);
         
         List<Comic> resultadoQuery = q.getResultList();
         
         return resultadoQuery.get(0);  
    }
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Comic> findAll() {
       
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Comic> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
