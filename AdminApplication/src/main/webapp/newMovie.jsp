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
             <p color="green"><c:out value="${success}" ></c:out> </p>
            <div class="container color-primary text-center padding-top-50">
              <div class="d-flex justify-content-center">
                 <h3>Add a new Movie</h3>
              </div>    
              <div class="d-flex justify-content-center">
                  <div class="my-card">
                 <form  action="add-movies" method="post" enctype="multipart/form-data">
                    <div class="form-group row">
                      <label for="title" class="col-sm-4 col-form-label">Title</label>
                      <div class="col-sm-8">
                        <input type="text" name="title" class="form-control" id="inputEmail3" placeholder="title">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="released" class="col-sm-4 col-form-label">Released Date</label>
                      <div class="col-sm-8">
                        <input type="date" name="released" class="form-control" id="inputPassword3" placeholder="">
                      </div>
                    </div>
                     <div class="form-group row">
                      <label for="length" class="col-sm-4 col-form-label">Length(hours)</label>
                      <div class="col-sm-8">
                        <input type="number" class="form-control" id="inputPassword3" name="length" placeholder="1.5">
                      </div>
                    </div>
                      <div class="form-group row">
                        <label for="genre" class="col-sm-4 col-form-label">Genre</label>
                        <div class="col-sm-8">
                        <select id="genre" name="genre" class="form-control">
                           
                          <option selected disabled>Choose...</option>
                           <c:forEach var="genre" items="${genres}">
                          <option value=${genre.id}>${genre.genre}</option>
                          </c:forEach>
                        </select>
                        </div>
                      </div>
                     <div class="form-group row">
                          <label for="thumbnail" class="col-sm-4 col-form-label">Upload Movie Thumbnail</label>
                        <div class="col-sm-8">
                            <input type="file" name="thumbnail" class="form-control" id="thumbnail" accept="image/*"/>
                          </div>

                     </div>
                     
                     <div class="form-group row">
                      <label for="producer" class="col-sm-4 col-form-label">Producer</label>
                      <div class="col-sm-8">
                        <input type="text" name="producer" class="form-control" id="director">
                      </div>
                    </div>
                     
                      <div class="form-group row">
                      <label for="director" class="col-sm-4 col-form-label">Director</label>
                      <div class="col-sm-8">
                        <input type="text" name="director" class="form-control" id="director">
                      </div>
                    </div>
                     
                      <div class="form-group row">
                          <div class="col-sm-12">
                            <button type="submit" class="btn btn-primary">Add new Movie</button>
                          </div>
                      </div>
                     
                  </form>
                 </div>
              </div>
            </div>            
    </body>
</html>
