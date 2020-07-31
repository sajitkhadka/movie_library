/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.restserviceclient.services.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import showwebservice.Genre;

/**
 *
 * @author Sajit
 */
public class Show {
    

/**
 *
 * @author Sajit
 */

//    id: "5",
//    title: "Forrest Gump",
//    image:
//      "https://images.freeimages.com/images/large-previews/8a1/small-waterfall-1376352.jpg",
//    released: "2019",
//    synopsis: "It is one of the best movie",
//    length: 100,
//    genre: "Adventure",
//    director: "Sajit Khadka",
//    producer: "Sajit Khadka",

    private BigDecimal id;
    private String title;
    private String image;
    private XMLGregorianCalendar released;
    private String synopsis; 
    protected BigInteger noSeasons;
    private Genre genre;
    private String director;
    private String producer;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public XMLGregorianCalendar getReleased() {
        return released;
    }

    public void setReleased(XMLGregorianCalendar released) {
        this.released = released;
    }

    public String getSynonsis() {
        return synopsis;
    }

    public void setSynonsis(String synonsis) {
        this.synopsis = synonsis;
    }

    public BigInteger getNoSeasons() {
        return noSeasons;
    }

    public void setNoSeasons(BigInteger length) {
        this.noSeasons = length;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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
    
            
    
}
