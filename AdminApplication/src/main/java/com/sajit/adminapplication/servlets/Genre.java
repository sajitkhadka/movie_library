/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.adminapplication.servlets;

import genrewebservices.Exception_Exception;
import genrewebservices.GenreService;
import genrewebservices.GenreServiceService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moviewebservices.MovieService;
import moviewebservices.MovieServiceService;

/**
 *
 * @author Sajit
 */
@WebServlet(name = "Genre", urlPatterns = {"/genre"})
public class Genre extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                RequestDispatcher dispatcher = request.getRequestDispatcher("./addGenre.jsp");
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
       
        String genre = request.getParameter("genre");  
        
         GenreServiceService service = new GenreServiceService();
        GenreService port = service.getGenreServicePort();
        
        try {
            port.addGenre(genre);
              
            request.setAttribute("success", "Successfully added a genre.");
            processRequest(request, response);
        } catch (Exception_Exception ex) {
              
                request.setAttribute("error", "Couldn't add a genre.");
                processRequest(request, response);
            Logger.getLogger(Genre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
