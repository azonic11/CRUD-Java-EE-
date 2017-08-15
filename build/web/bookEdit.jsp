<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add new contact</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

	
                 <h3>Update/Edit</h3>
                                  </br>

            <form method="post" action="BookController">
					<div class="form-group">
						<label>ID:</label> <input type="text" readonly
							class="form-control"  type="hidden" name="bookId" 
                                                        value="<c:out value="${book.bookId}" />"
							placeholder="id">
					</div>
                                                          
                                        <div class="form-group">
                                            <label>Publisher</label>
						   <select class="form-control" name="publisherId">
                                                         
                                                    
                                                    <c:forEach items="${publishers}" var="publisher">
                                                        <option <c:if test="${book.publisherId==publisher.publisherId}">selected</c:if> value="${publisher.publisherId}" > ${publisher.name}</option>
                                                   
                                                    </c:forEach>
                                               
                                                      </select>
					</div>          
                                                      
                                                       
                                                            
                                                                         
                                                        <div class="form-group">
                                                            
                                                             <label>Author 1</label>
                                                            
                                                              <c:out value="${default[0]}"> </c:out>
                                                                            <select class="form-control" name="autor1">
                                                                            <c:set var="comeVal" value="${default[0]}" />
                                                                                  <option selected="selected" value="0"  >select autor </option>
                                                                                <c:forEach items="${autors1}" var="aut">
                                                                                
                                                                                    <option  value="${aut.authorId}" > ${aut.firstName}</option>
                                                                                        <c:if test="${comeVal == aut.authorId}">
                                                                                            <option selected="selected" value="${aut.authorId}"  > ${aut.firstName} ${aut.lastName}</option>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    
                                                                            </select>
                                                            
                                                        </div>
                                                        
                                                        
                                                         <div class="form-group">
                                                            
                                                             <label>Author 2</label>
                                                              <c:out value="${default[1]}"> </c:out>
                                                                            <select class="form-control" name="autor2">
                                                                              <c:set var="comeVal" value="${default[1]}" />
                                                                                <option selected="selected" value="0"  >select autor</option>
                                                                                <c:forEach items="${autors1}" var="aut">
                                                                                
                                                                                    <option  value="${aut.authorId}" > ${aut.firstName}</option>
                                                                                     <c:if test="${comeVal == aut.authorId}">
                                                                                            <option selected="selected" value="${aut.authorId}"  > ${aut.firstName} ${aut.lastName}</option>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                            </select>
                                                            
                                                        </div>
                                                        
                                                        
                                                        
                                                              
					<div class="form-group">
						<label>Title</label> <input type="text"
							class="form-control"  name="title" required="required"
                                                        value="<c:out value="${book.title}" />"
							placeholder="Enter title">
					</div>
					         
                                                        <div class="form-group">
						<label >Number of page</label> <input type="number"
							class="form-control" name="numOfPage" required="required"
                                                        value="<c:out value="${book.numOfPage}" />"
							placeholder="Enter number of page">
					</div>
                                                        
                                                        <div class="form-group">
						<label >Price</label> <input type="number" pattern="^\d+\.\d{2}$" step="0.01" 
							class="form-control" name="price" required="required"
                                                        value="<c:out value="${book.price}" />"
							placeholder="Enter price">
					</div>
                                                        
                                                        
                                                        <div class="form-group">
						<label >Description</label> <input type="textarea" 
							class="form-control" name="description" required="required"
                                                        value="<c:out value="${book.description}" /> "
							placeholder="Enter description">
					</div>
                                                        
                                                        
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
                             </br>
		
</body
</html>