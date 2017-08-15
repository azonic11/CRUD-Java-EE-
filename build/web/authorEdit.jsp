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

            <form method="post" action="AuthorController">
					<div class="form-group">
						<label>ID:</label> <input type="text" readonly
							class="form-control"  type="hidden" name="authorId" 
                                                        value="<c:out value="${author.authorId}" />"
							placeholder="id">
					</div>
                                         <div class="form-group">
						<label for="poductname">FirstName:</label> <input type="text"
							class="form-control" name="firstName" required="required"
                                                       value="<c:out value="${author.firstName}" />"
							placeholder="Enter name">
					</div>
					<div class="form-group">
						<label for="address">LastName</label> <input type="text"
							class="form-control"  name="lastName" required="required"
                                                        value="<c:out value="${author.lastName}" />"
							placeholder="Enter address">
					</div>
					<div class="form-group">
						<label for="phoneno">Date:</label> <input type="date"
							class="form-control" name="date" required="required"
                                                        value="<c:out value="${author.date}" />"
							placeholder="yyyy-mm-dd">
					</div>
                                             
                                                        
                                                        
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
                             </br>
		
</body
</html>