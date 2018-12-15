/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.authutils;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

/**
 *
 * @author rafaelpernil
 */
public class GoogleUtils {
    private static String CLIENT_ID="20997473920-opi6u7sbies9c4eket8tjr767l72j8q5.apps.googleusercontent.com";
     public static Usuario validateToken(String idTokenString) throws IOException, GeneralSecurityException {
        Usuario usuario = null;
        
        
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(getDefaultHttpTransport(),getDefaultJsonFactory())
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList(CLIENT_ID))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();

// (Receive idTokenString by HTTPS POST)
        
        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            
           
            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");
           
            // Use or store profile information
            // ...
             usuario = new Usuario(userId, email,name);
             usuario.setEmailVerified(emailVerified);
             usuario.setPictureUrl(pictureUrl);
             usuario.setLocale(locale);
             usuario.setFamilyName(familyName);
             usuario.setGivenName(givenName);
        } else {
            System.out.println("Invalid ID token.");
           
        }
        return usuario;
    }
     private static HttpTransport getDefaultHttpTransport() {
		return new NetHttpTransport();
	}

	/**
	 * @return
	 * 				Default Json factory
	 */
	private static JsonFactory getDefaultJsonFactory() {
		return JacksonFactory.getDefaultInstance();
	}
}
