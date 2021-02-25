<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title><c:out value="${event.name}"/></title>
</head>
<body>
	<div class="container-fluid p-5">
		<div class="row">
			<h1 class="display-4 col p-3"><c:out value="${event.name}"/></h1>
		</div>
		<div class="row">
			<div class="col p-3">
				<h3>Host: <c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/></h3>
				<h3>Date: <c:out value="${event.date}"/></h3>
				<h3>Location: <c:out value="${event.location}"/></h3>
				<h3>People who are attending this event: <c:out value="${count}" default="0"/></h3>
				
				<table class="table border mt-5">
					<thead class="thead-light">
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${event.users}" var="user">
							<tr>
								<td><c:out value="${user.firstName}"/></td>
								<td><c:out value="${user.location}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
				<h1 class="display-4">Message Wall</h1>
				<div style="height: 200px;" class="border rounded-lg border-secondary overflow-auto bg-light p-1 mb-5">
					<c:forEach items="${comments}" var="comment">
							<p>${comment.comment}</p>
							<p>******************</p>
  					</c:forEach>
				</div>
				<form action="/events/${event.id}" method="post">
					<div class="form-group">
  						<label for="comment">Add Comment:</label>
  						<textarea class="form-control" rows="5" name="comment" required></textarea>
					</div>	
					<button type="submit" class="btn btn-success">Submit</button>		
				</form>
			</div>
		</div>
	</div>
</body>
</html>