/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities.service;

import app.authutils.GoogleUtils;
import app.authutils.Usuario;
import app.entities.Rol;
import app.entities.User;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author rafaelpernil
 */
@Stateless
@Path("app.entities.user")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "B3servidorRESTPU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public void create(User entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public void edit(@PathParam("id") String id, User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public User find(@PathParam("id") String id) {
        return super.find(id);
    }
     @GET
    @Path("userbytoken/{token}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public User findByToken(@PathParam("token") String token) {
         User result = new User();
        try {
            Usuario u = null;
            if (!token.equals(""))
            u = GoogleUtils.validateToken(token);
            if (u!=null)
                result = super.find(u.getUserId());
        } catch (IOException ex) {
            Logger.getLogger(UserFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(UserFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    @GET
    @Path("/rol/{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Rol getRol(@PathParam("id") String id) {
        return super.find(id).getRolId();
        
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
