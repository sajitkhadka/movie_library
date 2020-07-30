<%-- 
    Document   : movies
    Created on : Jul. 28, 2020, 10:30:19 a.m.
    Author     : Sajit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Library Admin portal | Home</title>
        <jsp:include page="./include/_declaration.html" />
    </head>
    <body>
        <jsp:include page="./include/_navbar.html" />
        <!-- First Container -->
         <div class="d-flex justify-content-center">
                    
             <p style="color:green"><c:out value="${success}" ></c:out> </p>
             <p style="color:red"><c:out value="${error}" ></c:out> </p>
          </div> 
            <div class="container color-primary text-center padding-top-50">
              <div class="d-flex justify-content-center">
                  <a href="add-movies" type="button" class="btn btn-outline-secondary">Add New Movie</a>
              </div>    
              <div class="d-flex justify-content-center padding-top-50">
                  <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                         <c:forEach var="show" items="${shows}">
                              <tr>
                                 <th scope="row">${show.moviesId}</th>
                                 <td>${show.title}</td>
                                   <form name='edit' method="POST" action="movies">
                                 <td>
                                                                          
                                         <input type="hidden" value=${show.moviesId} name="id">
                                        <button class="my-button" type="submit" name="edit"><i class="fa fa-pencil" aria-hidden="true"></i></button>

                                 </td>
                                 <td>
                                     
                                         <button class="my-button" type="submit" name="delete"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                 </td>
                                  </form>

                               </tr>
                          </c:forEach>
                      
                    </tbody>
                  </table>
              </div>
            </div>            
    </body>
</html>
