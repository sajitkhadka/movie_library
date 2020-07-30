/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.movielibrarysoapwebapp.services;

import com.sajit.movielibrarysoapwebapp.jpacontoller.GenreJpaController;
import com.sajit.movielibrarysoapwebapp.jpacontoller.MoviesJpaController;
import com.sajit.movielibrarysoapwebapp.jpacontoller.exceptions.NonexistentEntityException;
import com.sajit.movielibrarysoapwebapp.models.Genre;
import com.sajit.movielibrarysoapwebapp.models.Movies;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            @WebParam(name="synopsys") String synopsis, @WebParam(name="releasedDate") String released) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MOVIE_SHOW_PU");
        MoviesJpaController movieRepo = new MoviesJpaController(emf);
        
        GenreJpaController genreRepo = new GenreJpaController(emf);
        try{
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        Date date = in.parse(released);
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
            movies.setReleasedDate(date);
            try{
                movieRepo.create(movies);
                return true;
            }
            catch(Exception ex){
                return false;
            }
        }
        }
        catch(ParseException ex){
            return false;
        }
        return false;
        
    }
    
    @WebMethod(operationName="editMovie")
    public boolean editMovie(@WebParam(name="id") int id, @WebParam(name="title") String title, @WebParam(name="duration") int length, 
            @WebParam(name="genre") int genre,@WebParam(name="director") String director,
            @WebParam(name="producer") String producer, @WebParam(name="thumbnail") byte[] thumbnail, 
            @WebParam(name="synopsys") String synopsis, @WebParam(name="releasedDate") String released) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MOVIE_SHOW_PU");
        MoviesJpaController movieRepo = new MoviesJpaController(emf);
        
        GenreJpaController genreRepo = new GenreJpaController(emf);
        try{
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        Date date = in.parse(released);
        Genre g = genreRepo.findGenre(BigDecimal.valueOf(genre));
        if(g != null){
            Movies movies = new Movies();
            movies.setMoviesId(BigDecimal.valueOf(id));
            movies.setTitle(title);
            movies.setLength(BigInteger.valueOf(length));
            movies.setGenreId(g);
            movies.setDirector(director);
            movies.setProducer(producer);
            movies.setThumbnail(thumbnail);
            movies.setSynopsys(synopsis);
            movies.setReleasedDate(date);
            try{
                movieRepo.edit(movies);
                return true;
            }
            catch(Exception ex){
                return false;
            }
        }
        }
        catch(ParseException ex){
            return false;
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
    
    @WebMethod(operationName="deleteMovieById")
    public boolean deleteMovieById(@WebParam(name = "id") int id){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("MOVIE_SHOW_PU");
        MoviesJpaController movieRepo = new MoviesJpaController(emf);
        try {
            movieRepo.destroy(BigDecimal.valueOf(id));
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MovieService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
