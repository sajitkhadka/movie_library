/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.movielibrarysoapwebapp.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sajit
 */
@Entity
@Table(name = "MOVIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByMoviesId", query = "SELECT m FROM Movies m WHERE m.moviesId = :moviesId"),
    @NamedQuery(name = "Movies.findByTitle", query = "SELECT m FROM Movies m WHERE m.title = :title"),
    @NamedQuery(name = "Movies.findByReleasedDate", query = "SELECT m FROM Movies m WHERE m.releasedDate = :releasedDate"),
    @NamedQuery(name = "Movies.findBySynopsys", query = "SELECT m FROM Movies m WHERE m.synopsys = :synopsys"),
    @NamedQuery(name = "Movies.findByLength", query = "SELECT m FROM Movies m WHERE m.length = :length"),
    @NamedQuery(name = "Movies.findByDirector", query = "SELECT m FROM Movies m WHERE m.director = :director"),
    @NamedQuery(name = "Movies.findByProducer", query = "SELECT m FROM Movies m WHERE m.producer = :producer")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "MOVIES_ID")
    private BigDecimal moviesId;
    @Size(max = 200)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releasedDate;
    @Size(max = 3000)
    @Column(name = "SYNOPSYS")
    private String synopsys;
    @Column(name = "LENGTH")
    private BigInteger length;
    @Lob
    @Column(name = "THUMBNAIL")
    private byte[] thumbnail;
    @Size(max = 200)
    @Column(name = "DIRECTOR")
    private String director;
    @Size(max = 200)
    @Column(name = "PRODUCER")
    private String producer;
    @JoinColumn(name = "GENRE_ID", referencedColumnName = "GENRE_ID")
    @ManyToOne(optional = false)
    private Genre genreId;

    public Movies() {
    }

    public Movies(BigDecimal moviesId) {
        this.moviesId = moviesId;
    }

    public BigDecimal getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(BigDecimal moviesId) {
        this.moviesId = moviesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public BigInteger getLength() {
        return length;
    }

    public void setLength(BigInteger length) {
        this.length = length;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviesId != null ? moviesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.moviesId == null && other.moviesId != null) || (this.moviesId != null && !this.moviesId.equals(other.moviesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sajit.movielibrarysoapwebapp.models.Movies[ moviesId=" + moviesId + " ]";
    }
    
}
