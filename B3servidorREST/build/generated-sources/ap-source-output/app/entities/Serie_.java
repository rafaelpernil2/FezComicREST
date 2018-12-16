package app.entities;

import app.entities.ComicHasSerie;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-16T15:25:30")
@StaticMetamodel(Serie.class)
public class Serie_ { 

    public static volatile SingularAttribute<Serie, String> anotacionPrivada;
    public static volatile SingularAttribute<Serie, String> genero;
    public static volatile SingularAttribute<Serie, Integer> id;
    public static volatile SingularAttribute<Serie, String> nombre;
    public static volatile CollectionAttribute<Serie, ComicHasSerie> comicHasSerieCollection;

}