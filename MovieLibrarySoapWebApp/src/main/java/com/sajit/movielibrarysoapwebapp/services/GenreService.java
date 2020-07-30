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
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sajit
 */

@WebService
public class GenreService {
    
    @WebMethod(operationName="getGenre")
    public List<Genre> getAllGenre(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("MOVIE_SHOW_PU");
        GenreJpaController genreRepo = new GenreJpaController(emf);
        List<Genre> genreList = genreRepo.findGenreEntities();
        return genreList;
    }
    
}
