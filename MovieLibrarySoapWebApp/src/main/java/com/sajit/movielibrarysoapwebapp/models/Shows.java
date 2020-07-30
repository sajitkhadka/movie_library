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
@Table(name = "SHOWS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shows.findAll", query = "SELECT s FROM Shows s"),
    @NamedQuery(name = "Shows.findByShowsId", query = "SELECT s FROM Shows s WHERE s.showsId = :showsId"),
    @NamedQuery(name = "Shows.findByTitle", query = "SELECT s FROM Shows s WHERE s.title = :title"),
    @NamedQuery(name = "Shows.findByReleasedOn", query = "SELECT s FROM Shows s WHERE s.releasedOn = :releasedOn"),
    @NamedQuery(name = "Shows.findByNoSeasons", query = "SELECT s FROM Shows s WHERE s.noSeasons = :noSeasons"),
    @NamedQuery(name = "Shows.findBySynopsys", query = "SELECT s FROM Shows s WHERE s.synopsys = :synopsys"),
    @NamedQuery(name = "Shows.findByProducer", query = "SELECT s FROM Shows s WHERE s.producer = :producer"),
    @NamedQuery(name = "Shows.findByDirector", query = "SELECT s FROM Shows s WHERE s.director = :director")})
public class Shows implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHOWS_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal showsId;
    @Size(max = 200)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releasedOn;
    @Column(name = "NO_SEASONS")
    private BigInteger noSeasons;
    @Size(max = 3000)
    @Column(name = "SYNOPSYS")
    private String synopsys;
    @Lob
    @Column(name = "THUMBNAIL")
    private byte[] thumbnail;
    @Size(max = 200)
    @Column(name = "PRODUCER")
    private String producer;
    @Size(max = 200)
    @Column(name = "DIRECTOR")
    private String director;
    @JoinColumn(name = "GENRE_ID", referencedColumnName = "GENRE_ID")
    @ManyToOne(optional = false)
    private Genre genreId;

    public Shows() {
    }

    public Shows(BigDecimal showsId) {
        this.showsId = showsId;
    }

    public BigDecimal getShowsId() {
        return showsId;
    }

    public void setShowsId(BigDecimal showsId) {
        this.showsId = showsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    public BigInteger getNoSeasons() {
        return noSeasons;
    }

    public void setNoSeasons(BigInteger noSeasons) {
        this.noSeasons = noSeasons;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
        hash += (showsId != null ? showsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shows)) {
            return false;
        }
        Shows other = (Shows) object;
        if ((this.showsId == null && other.showsId != null) || (this.showsId != null && !this.showsId.equals(other.showsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sajit.movielibrarysoapwebapp.models.Shows[ showsId=" + showsId + " ]";
    }
    
}
