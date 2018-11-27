/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities.service;

import app.entities.ComicHasSerie;
import app.entities.ComicHasSeriePK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author rafaelpernil
 */
@Stateless
@Path("app.entities.comichasserie")
public class ComicHasSerieFacadeREST extends AbstractFacade<ComicHasSerie> {

    @PersistenceContext(unitName = "B3servidorRESTPU")
    private EntityManager em;

    private ComicHasSeriePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;comicidComic=comicidComicValue;serieIdserie=serieIdserieValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        app.entities.ComicHasSeriePK key = new app.entities.ComicHasSeriePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> comicidComic = map.get("comicidComic");
        if (comicidComic != null && !comicidComic.isEmpty()) {
            key.setComicidComic(new java.lang.Integer(comicidComic.get(0)));
        }
        java.util.List<String> serieIdserie = map.get("serieIdserie");
        if (serieIdserie != null && !serieIdserie.isEmpty()) {
            key.setSerieIdserie(new java.lang.Integer(serieIdserie.get(0)));
        }
        return key;
    }

    public ComicHasSerieFacadeREST() {
        super(ComicHasSerie.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ComicHasSerie entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ComicHasSerie entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        app.entities.ComicHasSeriePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ComicHasSerie find(@PathParam("id") PathSegment id) {
        app.entities.ComicHasSeriePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ComicHasSerie> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ComicHasSerie> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
