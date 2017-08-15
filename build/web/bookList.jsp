<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Books</title>
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
  
                    </br>
	<div class="container">
            <td><a href="AuthorController?action=listAuthors" class="btn btn-info" role="button" >Authors</a></td>
            <td><a href="PublisherController?action=listPublisher" class="btn btn-info" role="button" >Publishers</a></td>
		    <td><a href="BookController?action=listBooks" class="btn btn-info" role="button" >Books</a></td>
		<td><a href="MainInfo?action=listBooks" class="btn btn-info" role="button" >Main Info</a></td>
          
            
            <a href="BookController?action=insert" class="btn btn-info" role="button"  style="float: right;">Insert</a>		
					
	   </br>

                   

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Book ID</th>
					<th>Publisher</th>
                                        <th>Author</th>
					<th>Title</th>
					<th>Num of page</th>
					<th>Price</th>
					<th>Description</th>
					
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${books}" var="book">
					<tr>
		    <td><c:out value="${book.bookId}" /></td>
                        <c:forEach items="${publishers}" var="publisher">
                               <c:if test='${book.publisherId == publisher.publisherId}' >
                                    <td><c:out value="${publisher.name}" /></td>
                               </c:if>
                                   </c:forEach>
                    
                                       <c:forEach items="${authors}" var="autor">
                               <c:if test='${autor.id == book.bookId}' >
                                    <td><c:out value="${autor.autorsString}" /></td>
                               </c:if>
                        </c:forEach>           
                                    
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.numOfPage}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td><c:out value="${book.description}" /></td>
                    
					<td><a href="BookController?action=edit&bookId=<c:out value="${book.bookId}"/>"
										class="btn btn-info" role="button" >Update</a></td>
					
                    <td><a href="BookController?action=delete&bookId=<c:out value="${book.bookId}"/>"
										class="btn btn-info" role="button" >Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
                

             
		
</body>
</html>