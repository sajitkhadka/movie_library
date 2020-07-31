/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.adminapplication.servlets;

import com.sajit.adminapplication.utilities.ImageUtility;
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
import tvwebservices.ShowServiceService;
import tvwebservices.ShowService;
import tvwebservices.Exception_Exception;
import genrewebservices.GenreServiceService;
import genrewebservices.GenreService;
import genrewebservices.Genre;

/**
 *
 * @author Sajit
 */
@WebServlet(name = "AddShowServlet", urlPatterns = {"/add-shows"})
@MultipartConfig 
public class AddShowServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenreServiceService service = new GenreServiceService();
         GenreService port = service.getGenreServicePort();
          
         List<Genre> list = port.getGenre();
             
        request.setAttribute("genres", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./newShow.jsp");
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
             String title = request.getParameter("title");   
        
              if(title.equals("")){
                  request.setAttribute("error", "Please fill title.");
                processRequest(request, response);
             }
            String released = request.getParameter("released");
            
            
            int noSeasons = Integer.parseInt(request.getParameter("noSeasons"));
             if(request.getParameter("genre")== null){
              request.setAttribute("error", "Please choose a genre");
                processRequest(request, response);
             }
             
            int genreId = Integer.parseInt(request.getParameter("genre"));
            
            //custom created utility class to convert image path to byte
            byte[] image = ImageUtility.ImagePartToByte64(request.getPart("thumbnail"));
            String producer = request.getParameter("producer");  
            String director = request.getParameter("director");
            String synopsis = request.getParameter("synopsis");
            
            if(noSeasons<=0){
                request.setAttribute("error", "No of seasons cannot be 0 or less.");
                processRequest(request, response);
           }
            
                 
              ShowServiceService service = new ShowServiceService();
              ShowService port = service.getShowServicePort();
        try {
            if(port.createShows(title,noSeasons, genreId, director, producer, image, synopsis, released)){
 
                request.setAttribute("success", "Successfully added a show.");
                processRequest(request, response);
            }
        } catch (Exception_Exception ex) {
              
                request.setAttribute("error", "Error adding the show. Please try again.");
                processRequest(request, response);
                
            Logger.getLogger(AddShowServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }

    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
