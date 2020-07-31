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
                   
             <p style="color:green"><c:out value="${success}" ></c:out> </p>
             <p style="color:red"><c:out value="${error}" ></c:out> </p>
            <div class="container color-primary text-center mt-4">
              <div class="d-flex justify-content-center">
                 <h3>Add a new Genre</h3>
              </div>    
              <div class="d-flex justify-content-center">
                  <div class="my-card">
                 <form  action="genre" method="post" >
                 
                    
                    <div class="form-group row">
                      <label for="genre" class="col-sm-4 col-form-label">Genre</label>
                      <div class="col-sm-8">
                          <input type="text" name="genre" class="form-control" id="genre" required="true">
                      </div>
                    </div>
                    
                      <div class="form-group row">
                          <div class="col-sm-12">
                            <button type="submit" class="btn btn-primary">Add Genre</button>
                          </div>
                      </div>
                     
                  </form>
                 </div>
              </div>
            </div>  
            
    </body>
</html>
