<%-- 
    Document   : movies
    Created on : Jul. 28, 2020, 10:30:19 a.m.
    Author     : Sajit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="container color-primary text-center padding-top-100">
              <h3 class="margin">Movie Library Admin Portal</h3>
              <div class="d-flex justify-content-center">
                  <a href="movies" type="button" class="btn btn-outline-secondary">Browse Movies</a>
                  <a href="shows" type="button" class="btn btn-outline-secondary ml-2">Browse TV Shows</a>                  
              </div>
            </div>            
    </body>
</html>
