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
import tvwebservices.Exception_Exception;
import genrewebservices.GenreService;
import genrewebservices.GenreServiceService;
import tvwebservices.ShowService;
import tvwebservices.ShowServiceService;
import tvwebservices.Shows;

/**
 *
 * @author Sajit
 */
@WebServlet(name = "ShowServlet", urlPatterns = {"/shows"})
@MultipartConfig 
public class ShowServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        ShowServiceService service = new ShowServiceService();
        ShowService port = service.getShowServicePort();
        
        List<Shows> shows = port.getShows();
        request.setAttribute("shows", shows);
        
        request.setAttribute("page", "shows");
        RequestDispatcher dispatcher = request.getRequestDispatcher("./shows.jsp");
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
            ShowServiceService showservice = new ShowServiceService();
            ShowService port2 = showservice.getShowServicePort();
            int id = Integer.parseInt(request.getParameter("id"));
            //change
            //Shows show = port2.getShowById(id);
            Shows show = port2.getMovieById(id);
            request.setAttribute("show", show);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./newShow.jsp");
            dispatcher.forward(request, response);
        }else if(request.getParameter("delete")!=null){
             ShowServiceService service = new ShowServiceService();
            ShowService port = service.getShowServicePort();
            try{
            int id = Integer.parseInt(request.getParameter("id"));
            port.deleteShowById(id);
            request.setAttribute("success", "Successfully deleted.");
            }catch(Exception ex){
             request.setAttribute("error", "Error deleting record.");
            }
            processRequest(request, response);
        }else if(request.getParameter("update")!=null){
             String title = request.getParameter("title"); 
             int id = Integer.parseInt(request.getParameter("id"));
             if(title.equals("") || request.getParameter("noSeasons").equals("") || request.getParameter("genre").equals("")){
                  request.setAttribute("error", "Please fill title, duration and genre.");
                  
                RequestDispatcher dispatcher = request.getRequestDispatcher("./newShow.jsp");
                dispatcher.forward(request, response);
             }
            String released = request.getParameter("released");
            
            
            int noSeasons = Integer.parseInt(request.getParameter("noSeasons"));
            int genreId = Integer.parseInt(request.getParameter("genre"));
            
            //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            
            byte[] image = ImageUtility.ImagePartToByte64(request.getPart("thumbnail"));
            String producer = request.getParameter("producer");  
            String director = request.getParameter("director");
            String synopsis = request.getParameter("synopsis");
                 
              ShowServiceService service = new ShowServiceService();
              ShowService port = service.getShowServicePort();
            try {
                if(port.editShows(id,title,noSeasons, genreId, director, producer, image, synopsis, released)){
                    request.setAttribute("success", "Successfully updated the show.");
                    processRequest(request, response);
                }else{
                     request.setAttribute("error", "Couldn't updade the show.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./newShow.jsp");
                dispatcher.forward(request, response);
                }
            } catch (Exception_Exception ex) {
                request.setAttribute("error", "Couldn't updade the show.");
                    processRequest(request, response);
                Logger.getLogger(AddShowServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

