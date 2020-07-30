/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.movielibrarysoapwebapp.services;

import com.sajit.movielibrarysoapwebapp.jpacontoller.GenreJpaController;
import com.sajit.movielibrarysoapwebapp.jpacontoller.MoviesJpaController;
import com.sajit.movielibrarysoapwebapp.models.Genre;
import com.sajit.movielibrarysoapwebapp.models.Movies;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author Sajit
 */

@WebService
@MTOM(enabled = true, threshold = 0)
public class MovieService {
    
    @WebMethod(operationName="CreateMovie")
    public boolean AddMovie(@WebParam(name="title") String title, @WebParam(name="duration") int length, 
            @WebParam(name="genre") int genre,@WebParam(name="director") String director,
            @WebParam(name="producer") String producer, @WebParam(name="thumbnail") byte[] thumbnail, 
            @WebParam(name="synopsys") String synopsis) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MOVIE_SHOW_PU");
        MoviesJpaController movieRepo = new MoviesJpaController(emf);
        
        GenreJpaController genreRepo = new GenreJpaController(emf);
        
        Genre g = genreRepo.findGenre(BigDecimal.valueOf(genre));
        if(g != null){
            Movies movies = new Movies();
            movies.setTitle(title);
            movies.setLength(BigInteger.valueOf(length));
            movies.setGenreId(g);
            movies.setDirector(director);
            movies.setProducer(producer);
            movies.setThumbnail(thumbnail);
            movies.setSynopsys(synopsis);
            try{
                movieRepo.create(movies);
                return true;
            }
            catch(Exception ex){
                ex.printStackTrace();
                return false;
            }
        }
        return false;
        
    }
    
    @WebMethod(operationName="getMovies")
    public List<Movies> getAllMovies(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("MOVIE_SHOW_PU");
        MoviesJpaController movieRepo = new MoviesJpaController(emf);
        List<Movies> movieList = movieRepo.findMoviesEntities();
        return movieList;
    }
    
    @WebMethod(operationName="getMovieById")
    public Movies getMovie(@WebParam(name = "id") int id){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("MOVIE_SHOW_PU");
        MoviesJpaController movieRepo = new MoviesJpaController(emf);
        return movieRepo.findMovies(BigDecimal.valueOf(id));
    }
    
}
