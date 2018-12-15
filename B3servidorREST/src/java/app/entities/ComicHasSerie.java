/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaelpernil
 */
@Entity
@Table(name = "comic_has_serie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComicHasSerie.findAll", query = "SELECT c FROM ComicHasSerie c")
    , @NamedQuery(name = "ComicHasSerie.findByIdComic", query = "SELECT c FROM ComicHasSerie c WHERE c.comicHasSeriePK.idComic = :idComic")
    , @NamedQuery(name = "ComicHasSerie.findByIdSerie", query = "SELECT c FROM ComicHasSerie c WHERE c.comicHasSeriePK.idSerie = :idSerie")
    , @NamedQuery(name = "ComicHasSerie.findByAnotacionPublica", query = "SELECT c FROM ComicHasSerie c WHERE c.anotacionPublica = :anotacionPublica")})
public class ComicHasSerie implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComicHasSeriePK comicHasSeriePK;
    @Size(max = 200)
    @Column(name = "anotacion_publica")
    private String anotacionPublica;
    @JoinColumn(name = "id_comic", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comic comic;
    @JoinColumn(name = "id_serie", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Serie serie;

    public ComicHasSerie() {
    }

    public ComicHasSerie(ComicHasSeriePK comicHasSeriePK) {
        this.comicHasSeriePK = comicHasSeriePK;
    }

    public ComicHasSerie(int idComic, int idSerie) {
        this.comicHasSeriePK = new ComicHasSeriePK(idComic, idSerie);
    }

    public ComicHasSeriePK getComicHasSeriePK() {
        return comicHasSeriePK;
    }

    public void setComicHasSeriePK(ComicHasSeriePK comicHasSeriePK) {
        this.comicHasSeriePK = comicHasSeriePK;
    }

    public String getAnotacionPublica() {
        return anotacionPublica;
    }

    public void setAnotacionPublica(String anotacionPublica) {
        this.anotacionPublica = anotacionPublica;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comicHasSeriePK != null ? comicHasSeriePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComicHasSerie)) {
            return false;
        }
        ComicHasSerie other = (ComicHasSerie) object;
        if ((this.comicHasSeriePK == null && other.comicHasSeriePK != null) || (this.comicHasSeriePK != null && !this.comicHasSeriePK.equals(other.comicHasSeriePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.ComicHasSerie[ comicHasSeriePK=" + comicHasSeriePK + " ]";
    }
    
}
