/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.restserviceclient.services;

/**
 *
 * @author Sajit
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.sajit.restserviceclient.services.models.Movie;
import com.sajit.restserviceclient.tools.ClassConversion;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import webservice.MovieService;
import webservice.MovieServiceService;
import webservice.Movies;

/**
 *
 * @author Sajit
 */
@Path("movie")
public class ClientMovieService {
    
    @GET
    @Produces("application/json")
    public Response allmovies(){
         MovieServiceService service = new MovieServiceService();
        MovieService port = service.getMovieServicePort();
         List<Movies> movies = port.getMovies();
        //Instead of directly converting passing the movie data that comes from webservice to json data 
        // I have converted it to another movie class. the reason is the original movie data has image as byte.
        //which i have converted to base64 string before serving to api calls.
        
        List<Movie> modifiedMovieList = new ArrayList();
        for(Movies movie:movies){
            //The ClassConversion is a utility class I created to easily convert the incoming class to the data I want.
            modifiedMovieList.add(ClassConversion.MovieConvert(movie));
        }
        if(movies!= null){
            //String output = response.readEntity(String.class);
            Gson gson = new Gson();
            //Comment [] commentList = gson.fromJson(output, Comment[].class);
           // List <Comment> commentsArray = Arrays.asList(commentList);
            //commentsArray = commentsArray.stream().limit(count).collect(Collectors.toList());
            return Response.ok(gson.toJson(modifiedMovieList)).build();
        }else{
            return Response.noContent().build();
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("id/{id}")
    public Response movidById(@PathParam("id") int id){
         MovieServiceService service = new MovieServiceService();
        MovieService port = service.getMovieServicePort();
         
         Movie movie = ClassConversion.MovieConvert(port.getMovieById(id));
        if(movie!= null){
            Gson gson = new Gson();
            return Response.ok(gson.toJson(movie)).build();
        }else{
            return Response.noContent().build();
        }
    }
}
