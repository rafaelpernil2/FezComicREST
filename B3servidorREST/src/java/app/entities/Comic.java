/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities;

import java.io.Serializable;
import java.util.Base64;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;

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
    , @NamedQuery(name = "Comic.findById", query = "SELECT c FROM Comic c WHERE c.id = :id")
    , @NamedQuery(name = "Comic.findByNombre", query = "SELECT c FROM Comic c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Comic.findByIsbn", query = "SELECT c FROM Comic c WHERE c.isbn = :isbn")
    , @NamedQuery(name = "Comic.findByAnotacionPrivada", query = "SELECT c FROM Comic c WHERE c.anotacionPrivada = :anotacionPrivada")})
public class Comic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Column(name = "anotacion_privada")
    private String anotacionPrivada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comic")
    private Collection<ComicHasSerie> comicHasSerieCollection;

    public Comic() {
    }

    public Comic(Integer id) {
        this.id = id;
    }

    public Comic(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comic)) {
            return false;
        }
        Comic other = (Comic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.Comic[ id=" + id + " ]";
    }
    
}
