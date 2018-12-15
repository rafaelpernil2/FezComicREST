package app.entities;

import app.entities.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-15T16:36:52")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile CollectionAttribute<Rol, User> userCollection;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile SingularAttribute<Rol, String> nombre;

}