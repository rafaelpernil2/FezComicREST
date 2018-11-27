package app.entities;

import app.entities.ComicHasSerie;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T19:18:21")
@StaticMetamodel(Serie.class)
public class Serie_ { 

    public static volatile SingularAttribute<Serie, Integer> idserie;
    public static volatile SingularAttribute<Serie, String> anotacionPrivada;
    public static volatile SingularAttribute<Serie, String> genero;
    public static volatile SingularAttribute<Serie, String> nombre;
    public static volatile CollectionAttribute<Serie, ComicHasSerie> comicHasSerieCollection;

}