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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rafaelpernil
 */
@Path("auth")
public class AuthenticationREST {

    RolFacadeREST rolFacadeREST = lookupRolFacadeRESTBean();

    UserFacadeREST userFacadeREST = lookupUserFacadeRESTBean();

    public AuthenticationREST() {
    }

    @POST
    @Path("tokensignin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void authenticate(@FormParam("idtoken") String idToken) {
        User result = new User();
        try {
            Usuario u = null;
            if (!idToken.equals("")) {
                u = GoogleUtils.validateToken(idToken);
            }
            if (u != null) {
                if ((result = lookupUserFacadeRESTBean().find(u.getUserId())) == null) {
                    
                    result = new User(u.getUserId(),u.getName(), lookupRolFacadeRESTBean().find(2));
                    lookupUserFacadeRESTBean().create(result);
                } else {
                    lookupUserFacadeRESTBean().edit(result);
                }
            }
        } catch (IOException | GeneralSecurityException ex) {
            Logger.getLogger(UserFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    private UserFacadeREST lookupUserFacadeRESTBean() {
        try {
            Context c = new InitialContext();
            return (UserFacadeREST) c.lookup("java:global/B3servidorREST/UserFacadeREST!app.entities.service.UserFacadeREST");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private RolFacadeREST lookupRolFacadeRESTBean() {
        try {
            Context c = new InitialContext();
            return (RolFacadeREST) c.lookup("java:global/B3servidorREST/RolFacadeREST!app.entities.service.RolFacadeREST");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
