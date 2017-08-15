<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Main Info</title>
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
            
           				
	   </br>

                   

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Book Name</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${XXX}" var="mainInfo">
					<tr>
		    <td><c:out value="${mainInfo.title}" /></td>
                    <td><c:out value="${mainInfo.author}" /></td>
                    <td><c:out value="${mainInfo.publisher}" /></td>
                    <td><c:out value="${mainInfo.price}" /></td>
                    
					
				</c:forEach>
			</tbody>
		</table>
                

             
		
</body>
</html>