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
    @Column(name = "id_comic")
    private int idComic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_serie")
    private int idSerie;

    public ComicHasSeriePK() {
    }

    public ComicHasSeriePK(int idComic, int idSerie) {
        this.idComic = idComic;
        this.idSerie = idSerie;
    }

    public int getIdComic() {
        return idComic;
    }

    public void setIdComic(int idComic) {
        this.idComic = idComic;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idComic;
        hash += (int) idSerie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComicHasSeriePK)) {
            return false;
        }
        ComicHasSeriePK other = (ComicHasSeriePK) object;
        if (this.idComic != other.idComic) {
            return false;
        }
        if (this.idSerie != other.idSerie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.ComicHasSeriePK[ idComic=" + idComic + ", idSerie=" + idSerie + " ]";
    }
    
}
