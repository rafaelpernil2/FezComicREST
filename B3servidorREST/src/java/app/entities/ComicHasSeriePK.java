/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rafaelpernil
 */
@Embeddable
public class ComicHasSeriePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "comic_idComic")
    private int comicidComic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serie_idserie")
    private int serieIdserie;

    public ComicHasSeriePK() {
    }

    public ComicHasSeriePK(int comicidComic, int serieIdserie) {
        this.comicidComic = comicidComic;
        this.serieIdserie = serieIdserie;
    }

    public int getComicidComic() {
        return comicidComic;
    }

    public void setComicidComic(int comicidComic) {
        this.comicidComic = comicidComic;
    }

    public int getSerieIdserie() {
        return serieIdserie;
    }

    public void setSerieIdserie(int serieIdserie) {
        this.serieIdserie = serieIdserie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) comicidComic;
        hash += (int) serieIdserie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComicHasSeriePK)) {
            return false;
        }
        ComicHasSeriePK other = (ComicHasSeriePK) object;
        if (this.comicidComic != other.comicidComic) {
            return false;
        }
        if (this.serieIdserie != other.serieIdserie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.ComicHasSeriePK[ comicidComic=" + comicidComic + ", serieIdserie=" + serieIdserie + " ]";
    }
    
}
