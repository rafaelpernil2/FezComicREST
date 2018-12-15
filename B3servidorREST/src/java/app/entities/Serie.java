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
@Table(name = "serie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s")
    , @NamedQuery(name = "Serie.findById", query = "SELECT s FROM Serie s WHERE s.id = :id")
    , @NamedQuery(name = "Serie.findByNombre", query = "SELECT s FROM Serie s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Serie.findByAnotacionPrivada", query = "SELECT s FROM Serie s WHERE s.anotacionPrivada = :anotacionPrivada")
    , @NamedQuery(name = "Serie.findByGenero", query = "SELECT s FROM Serie s WHERE s.genero = :genero")})
public class Serie implements Serializable {

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
    @Size(max = 200)
    @Column(name = "anotacion_privada")
    private String anotacionPrivada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "genero")
    private String genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serie")
    private Collection<ComicHasSerie> comicHasSerieCollection;

    public Serie() {
    }

    public Serie(Integer id) {
        this.id = id;
    }

    public Serie(Integer id, String nombre, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
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

    public String getAnotacionPrivada() {
        return anotacionPrivada;
    }

    public void setAnotacionPrivada(String anotacionPrivada) {
        this.anotacionPrivada = anotacionPrivada;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.Serie[ id=" + id + " ]";
    }
    
}
