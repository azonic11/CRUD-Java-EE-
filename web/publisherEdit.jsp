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

            <form method="post" action="PublisherController">
                
					<div class="form-group">
						<label>ID:</label> <input type="text" readonly 
							class="form-control"  type="hidden" name="publisherId" 
                                                        value="<c:out value="${publisher.publisherId}" />"
							placeholder="id">
					</div>
                                         <div class="form-group">
						<label for="poductname">Name:</label> <input type="text"
							class="form-control" name="name" required="required"
                                                       value="${publisher.name}"
							placeholder="Enter name">
					</div>
					<div class="form-group">
						<label for="address">Adress:</label> <input type="text"
							class="form-control"  name="adress" required="required"
                                                        value="<c:out value="${publisher.adress}" />"
							placeholder="Enter address">
					</div>
					<div class="form-group">
						<label for="phoneno">Phone:</label> <input type="text"
							class="form-control" name="phoneNumber" required="required"
                                                        value="<c:out value="${publisher.phoneNumber}" />"
							placeholder="Enter phone">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
                             </br>
		
</body
</html>