/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.restserviceclient.tools;

import com.sajit.restserviceclient.services.models.Movie;
import com.sajit.restserviceclient.services.models.Show;
import moviewebservice.Movies;
import showwebservice.Shows;

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
            if(movie.getThumbnail()!=null){
                 m.setImage(new String(movie.getThumbnail()));
            }
            m.setProducer(movie.getProducer());
            m.setReleased(movie.getReleasedDate());
          
             m.setId(movie.getMoviesId());
            m.setSynonsis(movie.getSynopsys());
            return m;
    }
    
    public static Show ShowConvert(Shows show){
            Show s = new Show();
            s.setTitle(show.getTitle());
            s.setGenre(show.getGenreId());
            s.setNoSeasons(show.getNoSeasons());
            s.setDirector(show.getDirector());
            if(show.getThumbnail()!=null){
                s.setImage(new String(show.getThumbnail()));
            }
            
            s.setProducer(show.getProducer());
            s.setReleased(show.getReleasedOn());
            s.setId(show.getShowsId());
            s.setSynonsis(show.getSynopsys());
            return s;
    }
}
