/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafaelpernil
 */
@Entity
@Table(name = "comic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comic.findAll", query = "SELECT c FROM Comic c")
    , @NamedQuery(name = "Comic.findByIdComic", query = "SELECT c FROM Comic c WHERE c.idComic = :idComic")
    , @NamedQuery(name = "Comic.findByNombre", query = "SELECT c FROM Comic c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Comic.findByIsbn", query = "SELECT c FROM Comic c WHERE c.isbn = :isbn")
    , @NamedQuery(name = "Comic.findByAnotacionPrivada", query = "SELECT c FROM Comic c WHERE c.anotacionPrivada = :anotacionPrivada")})
public class Comic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComic")
    private Integer idComic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "isbn")
    private Integer isbn;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 200)
    @Column(name = "anotacionPrivada")
    private String anotacionPrivada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comic")
    private Collection<ComicHasSerie> comicHasSerieCollection;

    public Comic() {
    }

    public Comic(Integer idComic) {
        this.idComic = idComic;
    }

    public Comic(Integer idComic, String nombre) {
        this.idComic = idComic;
        this.nombre = nombre;
    }

    public Integer getIdComic() {
        return idComic;
    }

    public void setIdComic(Integer idComic) {
        this.idComic = idComic;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getAnotacionPrivada() {
        return anotacionPrivada;
    }

    public void setAnotacionPrivada(String anotacionPrivada) {
        this.anotacionPrivada = anotacionPrivada;
    }

    @XmlTransient
    public Collection<ComicHasSerie> getComicHasSerieCollection() {
        return comicHasSerieCollection;
    }

    public void setComicHasSerieCollection(Collection<ComicHasSerie> comicHasSerieCollection) {
        this.comicHasSerieCollection = comicHasSerieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComic != null ? idComic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comic)) {
            return false;
        }
        Comic other = (Comic) object;
        if ((this.idComic == null && other.idComic != null) || (this.idComic != null && !this.idComic.equals(other.idComic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.Comic[ idComic=" + idComic + " ]";
    }
    
}
