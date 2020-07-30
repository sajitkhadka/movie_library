/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.adminapplication.servlets;

import com.sajit.adminapplication.models.Genre;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
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
import soapservices.Exception_Exception;
import soapservices.MovieService;
import soapservices.MovieServiceService;

/**
 *
 * @author Sajit
 */
@WebServlet(name = "AddMovieServlet", urlPatterns = {"/add-movies"})
@MultipartConfig 
public class AddMovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddMovieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddMovieServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         List<Genre> genres = new ArrayList<>();
        Genre genre1 = new Genre();
        genre1.setId(BigDecimal.valueOf(1));
        genre1.setGenre("Action");
        genres.add(genre1);
        Genre genre = new Genre();
        genre.setId(BigDecimal.valueOf(2));
        genre.setGenre("Adventure");
        genres.add(genre);
        
        request.setAttribute("genres", genres);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./newMovie.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");         
//            try {
//                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("released"));
//            } catch (ParseException ex) {
//                Logger.getLogger(AddMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Double length = Double.parseDouble(request.getParameter("length"));
//            int genreId = Integer.parseInt(request.getParameter("genre"));
            
            Part filePart = request.getPart("thumbnail"); // Retrieves <input type="file" name="file">
            //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            byte[] buffer = new byte[(int)filePart.getSize()];
            filePart.getInputStream().read(buffer,0,buffer.length);
            bytes.write(buffer);
            
            byte[] encoded = Base64.getEncoder().encode(buffer);
            String producer = request.getParameter("producer");  
            String director = request.getParameter("director");
                 
              MovieServiceService service = new MovieServiceService();
              MovieService port = service.getMovieServicePort();
              System.out.println("I am here");
        try {
            if(port.createMovie(title, 2, 3, director, producer, encoded, "This is the best movie")){
                 RequestDispatcher dispatcher = request.getRequestDispatcher("./newMovie.jsp");
                 
                request.setAttribute("success", "Successfully added a movie.");
                dispatcher.forward(request, response);
            }
        } catch (Exception_Exception ex) {
            Logger.getLogger(AddMovieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }

    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
