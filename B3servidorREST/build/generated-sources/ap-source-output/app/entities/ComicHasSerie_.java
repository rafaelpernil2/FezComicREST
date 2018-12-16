package app.entities;

import app.entities.Comic;
import app.entities.ComicHasSeriePK;
import app.entities.Serie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-16T15:25:30")
@StaticMetamodel(ComicHasSerie.class)
public class ComicHasSerie_ { 

    public static volatile SingularAttribute<ComicHasSerie, String> anotacionPublica;
    public static volatile SingularAttribute<ComicHasSerie, ComicHasSeriePK> comicHasSeriePK;
    public static volatile SingularAttribute<ComicHasSerie, Serie> serie;
    public static volatile SingularAttribute<ComicHasSerie, Comic> comic;

}