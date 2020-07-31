/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.adminapplication.servlets;

import com.sajit.adminapplication.utilities.ImageUtility;
import genrewebservices.Genre;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import moviewebservices.Exception_Exception;
import genrewebservices.GenreService;
import genrewebservices.GenreServiceService;
import moviewebservices.MovieService;
import moviewebservices.MovieServiceService;
import moviewebservices.Movies;

/**
 *
 * @author Sajit
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/movies"})
@MultipartConfig 
public class MovieServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        MovieServiceService service = new MovieServiceService();
        MovieService port = service.getMovieServicePort();
        
        List<Movies> movies = port.getMovies();
        request.setAttribute("shows", movies);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("./movies.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("edit")!= null){
            GenreServiceService service = new GenreServiceService();
            GenreService port = service.getGenreServicePort();
            List<Genre> list = port.getGenre();
           request.setAttribute("genres", list);
            request.setAttribute("edit", true);
            MovieServiceService movieservice = new MovieServiceService();
            MovieService port2 = movieservice.getMovieServicePort();
            int id = Integer.parseInt(request.getParameter("id"));
            Movies movie = port2.getMovieById(id);
            request.setAttribute("movie", movie);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./newMovie.jsp");
            dispatcher.forward(request, response);
        }else if(request.getParameter("delete")!=null){
             MovieServiceService service = new MovieServiceService();
            MovieService port = service.getMovieServicePort();
            try{
            int id = Integer.parseInt(request.getParameter("id"));
            port.deleteMovieById(id);
            request.setAttribute("success", "Successfully deleted.");
            }catch(Exception ex){
             request.setAttribute("error", "Error deleting record.");
            }
            processRequest(request, response);
        }else if(request.getParameter("update")!=null){
             String title = request.getParameter("title"); 
             int id = Integer.parseInt(request.getParameter("id"));
             if(title.equals("") || request.getParameter("length").equals("")){
                  request.setAttribute("error", "Please fill title, duration.");
                  
                RequestDispatcher dispatcher = request.getRequestDispatcher("./newMovie.jsp");
                dispatcher.forward(request, response);
             }
            String released = request.getParameter("released");
            
            
            int length = Integer.parseInt(request.getParameter("length"));
             if(request.getParameter("genre")== null){
              request.setAttribute("error", "Please choose a genre");
                RequestDispatcher dispatcher = request.getRequestDispatcher("./newMovie.jsp");
                dispatcher.forward(request, response);
             }
            int genreId = Integer.parseInt(request.getParameter("genre"));
            
            
            //custom created utility class to convert image path to byte
            byte[] image = ImageUtility.ImagePartToByte64(request.getPart("thumbnail"));
            
            String producer = request.getParameter("producer");  
            String director = request.getParameter("director");
            String synopsis = request.getParameter("synopsis");
            if(length<=0){
                request.setAttribute("error", "Movie length cannot be 0 or less.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("./newMovie.jsp");
                dispatcher.forward(request, response);
           }
                 
              MovieServiceService service = new MovieServiceService();
              MovieService port = service.getMovieServicePort();
            try {

                if(port.editMovie(id,title,length, genreId, director, producer, image, synopsis, released)){
                    request.setAttribute("success", "Successfully updated the movie.");
                    processRequest(request, response);
                }
            } catch (Exception_Exception ex) {
                request.setAttribute("error", "Error adding movie. If you have put disney in any string please try agiain removing disney.");
                  RequestDispatcher dispatcher = request.getRequestDispatcher("./newMovie.jsp");
                dispatcher.forward(request, response);
                Logger.getLogger(AddMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
