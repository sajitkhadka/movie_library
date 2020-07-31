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
import com.sajit.restserviceclient.services.models.Show;
import com.sajit.restserviceclient.tools.ClassConversion;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import showwebservice.ShowService;
import showwebservice.ShowServiceService;
import showwebservice.Shows;

/**
 *
 * @author Sajit
 */
@Path("show")
public class ClientShowService {
    
    @GET
    @Produces("application/json")
    public Response allshows(){
         ShowServiceService service = new ShowServiceService();
        ShowService port = service.getShowServicePort();
         List<Shows> shows = port.getShows();
        //Instead of directly converting passing the movie data that comes from webservice to json data 
        // I have converted it to another movie class. the reason is the original movie data has image as byte.
        //which i have converted to base64 string before serving to api calls.
        
        List<Show> modifiedShowList = new ArrayList();
        for(Shows movie:shows){
            //The ClassConversion is a utility class I created to easily convert the incoming class to the data I want.
            modifiedShowList.add(ClassConversion.ShowConvert(movie));
        }
        if(shows!= null){
            //String output = response.readEntity(String.class);
            Gson gson = new Gson();
            //Comment [] commentList = gson.fromJson(output, Comment[].class);
           // List <Comment> commentsArray = Arrays.asList(commentList);
            //commentsArray = commentsArray.stream().limit(count).collect(Collectors.toList());
            return Response.ok(gson.toJson(modifiedShowList)).build();
        }else{
            return Response.noContent().build();
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("id/{id}")
    public Response movidById(@PathParam("id") int id){
         ShowServiceService service = new ShowServiceService();
        ShowService port = service.getShowServicePort();
         
        //Change 
        // Show movie = ClassConversion.ShowConvert(port.getShowsById(id));
         Show movie = ClassConversion.ShowConvert(port.getMovieById(id));
        if(movie!= null){
            Gson gson = new Gson();
            return Response.ok(gson.toJson(movie)).build();
        }else{
            return Response.noContent().build();
        }
    }
}
