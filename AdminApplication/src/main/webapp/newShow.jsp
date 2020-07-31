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
            <div class="container color-primary text-center">
              <div class="d-flex justify-content-center">
                 <h3><c:out value="${edit?'Update Show':'Add new Show'}" ></c:out></h3>
              </div>    
              <div class="d-flex justify-content-center">
                  <div class="my-card">
                 <form  action="<c:out value="${edit?'shows':'add-shows'}" ></c:out>" method="post" enctype="multipart/form-data">
                 
                    <input type="hidden" value="<c:out value="${show.showsId}"></c:out>" name="id" required>
                    <div class="form-group row">
                      <label for="title" class="col-sm-4 col-form-label">Title</label>
                      <div class="col-sm-8">
                        <input type="text" name="title" class="form-control" id="title" placeholder="title" required value="<c:out value="${show.title}" ></c:out>">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="released" class="col-sm-4 col-form-label">First Episode Released: </label>
                      <div class="col-sm-8">
                        <input type="date" name="released" class="form-control" id="released"  val="<c:out value="${show.releasedOn}" ></c:out>">
                      </div>
                    </div>
                     <div class="form-group row">
                      <label for="seasons" class="col-sm-4 col-form-label">Number of Seasons</label>
                      <div class="col-sm-8">
                          <input type="number" class="form-control" id="seasons" name="noSeasons" required placeholder="" value="<c:out value="${show.noSeasons}" ></c:out>">
                      </div>
                    </div>
                      <div class="form-group row">
                        <label for="genre" class="col-sm-4 col-form-label">Genre</label>
                        <div class="col-sm-8">
                            <select id="genre" name="genre" class="form-control" required value="<c:out value="${show.genreId.genreId}"></c:out>">   
                          <option selected disabled>Choose...</option>
                           <c:forEach var="genre" items="${genres}">
                          <option <c:out value="${show.genreId.genreId eq genre.genreId?'selected':''}"></c:out> value=${genre.genreId}>${genre.genre}</option>
                          </c:forEach>
                        </select>
                        </div>
                      </div>
                     <div class="form-group row">
                          <label for="thumbnail" class="col-sm-4 col-form-label">Upload Movie Image</label>
                        <div class="col-sm-8">
                            <input type="file" name="thumbnail" class="form-control" id="thumbnail" accept="image/*"/>
                          </div>
                     </div>
                     
                     <div class="form-group row">
                      <label for="director" class="col-sm-4 col-form-label">Director</label>
                      <div class="col-sm-8">
                          <input type="text" name="director" class="form-control" id="director" value="<c:out value="${show.director}"></c:out>">
                      </div>
                    </div>
                     
                     <div class="form-group row">
                      <label for="producer" class="col-sm-4 col-form-label">Producer</label>
                      <div class="col-sm-8">
                          <input type="text" name="producer" class="form-control" id="director"  value="<c:out value="${show.producer}"></c:out>">
                      </div>
                    </div>
                     
                      
                     <div class="form-group row">
                        <label for="synopsis" class="col-sm-4 col-form-label">Synopsis</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" id="synopsis" rows="3" name="synopsis"><c:out value="${show.synopsys}"></c:out></textarea>
                        </div>
                      </div>
                     
                      <div class="form-group row">
                          <div class="col-sm-12">
                            <button type="submit" class="btn btn-primary" name="<c:out value="${edit?'update':''}" ></c:out>"><c:out value="${edit?'Update':'Add new TV Show'}" ></c:out></button>
                          </div>
                      </div>
                     
                  </form>
                 </div>
              </div>
            </div>  
                          
                          <script>
                              (function(){
                              var dateDiv = document.getElementById("released");
                              var dateVal = dateDiv.valueOf().getAttribute("val");
                              if(!dateVal) return;
                              var d = new Date(dateVal);
                              var date = [
                                        d.getFullYear(),
                                        ('0' + (d.getMonth() + 1)).slice(-2),
                                        ('0' + d.getDate()).slice(-2)
                                      ].join('-');
                                dateDiv.value = date;
                            })();
                          </script>
    </body>
</html>
