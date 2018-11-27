package app.entities;

import app.entities.ComicHasSerie;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T19:18:21")
@StaticMetamodel(Comic.class)
public class Comic_ { 

    public static volatile SingularAttribute<Comic, byte[]> foto;
    public static volatile SingularAttribute<Comic, String> anotacionPrivada;
    public static volatile SingularAttribute<Comic, Integer> idComic;
    public static volatile SingularAttribute<Comic, Integer> isbn;
    public static volatile SingularAttribute<Comic, String> nombre;
    public static volatile CollectionAttribute<Comic, ComicHasSerie> comicHasSerieCollection;

}