/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.restserviceclient.tools;

import com.sajit.restserviceclient.services.models.Movie;
import webservice.Movies;

/**
 *
 * @author Sajit
 */
public class ClassConversion {
    
    public static Movie MovieConvert(Movies movie){
            Movie m = new Movie();
            m.setTitle(movie.getTitle());
            m.setGenre(movie.getGenreId());
            m.setLength(movie.getLength());
            m.setDirector(movie.getDirector());
            m.setImage(new String(movie.getThumbnail()));
            m.setProducer(movie.getProducer());
            m.setReleased(movie.getReleasedDate());
          
             m.setId(movie.getMoviesId());
            m.setSynonsis(movie.getSynopsys());
            return m;
    }
}
