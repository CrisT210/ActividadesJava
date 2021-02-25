<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/funciones.js"></script>
<meta charset="UTF-8">
<title>Events</title>
</head>
<body>
	<div class="container-fluid p-5">
		<div class="row">
			<div class="col-md-10">
				<h1 class="display-4">Welcome, <c:out value="${user.firstName}"/></h1>
			</div>
			<div class="col-md-2">
				<a href="/logout" type="button" class="btn btn-info">Logout</a>
			</div>
		</div>
		<div class="row justify-content-start">
			<div class="col-md-10 p-5">
				<h1>Here are some of the events in your state:</h1>
				<table class="table border">
					<thead class="thead-light">
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Location</th>
							<th>Host</th>
							<th>Action/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${eventsState}" var="event">
							<tr>
								<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
								<td><c:out value="${event.date}"/></td>
								<td><c:out value="${event.location}"/></td>
								<td><c:out value="${event.host.firstName}"/></td>
								<td>
									<div class="row">
										<c:if test="${event.host == user}">
											<div class="col-md-2 mr-1">
												<a href="/events/${event.id}/edit" type="button" class="btn btn-info">Edit</a>
											</div>
											<div class="col-md-2">
												<form action="/delete/${event.id}" method="post">
													<input type="hidden" name="_method" value="delete"/>
													<button class="btn btn-danger">Delete</button>
												</form>
											</div>
										</c:if>
										<c:if test="${event.users.contains(user)}">
												<form class="col-md-2" action="/cancel/${user.id}" method="post">
													<input type="hidden" name="_method" value="delete"/>
													<button name="idEvent" value="${event.id}" class="btn btn-danger">Cancel</button>
												</form>
										</c:if>
										<c:if test="${!event.users.contains(user)}">
											<form class="col-md-2 mr-1 join" action="/join" method="post">
												<input type="hidden" name="idEvent" value="${event.id}"/>
												<input type="hidden" name="idUser" value="${user.id}"/>
												<button type="submit" class="btn btn-success">Join</button>
											</form>
										</c:if>
									</div>						
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row justify-content-start">
			<div class="col-md-10 p-5">
				<h1>Here are some of the events in other states:</h1>
				<table class="table border">
					<thead class="thead-light">
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Location</th>
							<th>State</th>
							<th>Host</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${eventsOutState}" var="event">
							<tr>
								<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
								<td><c:out value="${event.date}"/></td>
								<td><c:out value="${event.location}"/></td>
								<td><c:out value="${event.state.state}"/></td>
								<td><c:out value="${event.host.firstName}"/></td>
								<td>
									<div class="row">
										<c:if test="${event.host == user}">
											<div class="col-md-2 mr-1">
												<a href="/events/${event.id}/edit" type="button" class="btn btn-info">Edit</a>
											</div>
											<div class="col-md-2">
												<form action="/delete/${event.id}" method="post">
													<input type="hidden" name="_method" value="delete"/>
													<button class="btn btn-danger">Delete</button>
												</form>
											</div>
										</c:if>
										<c:if test="${event.host != user}">
											<form class="col-md-2 mr-1 join" action="/join" method="post">
												<input type="hidden" name="idEvent" value="${event.id}"/>
												<input type="hidden" name="idUser" value="${user.id}"/>
												<button type="submit" class="btn btn-success">Join</button>
											</form>
										</c:if>
										<c:forEach items="${event.users}" var="e">
											<c:if test="${e == user}">
												<form class="col-md-2" action="/cancel/${user.id}" method="post">
													<input type="hidden" name="_method" value="delete"/>
													<button name="idEvent" value="${event.id}" class="btn btn-danger">Cancel</button>
												</form>
											</c:if>
										</c:forEach>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row justyfy-content-start">
			<div class="col-md-4 px-5">
				<h1>Create an Event</h1>
				<form:form class="mt-5" action="/events" method="post" modelAttribute="event">
					<div class="form-group row">
   						<form:label class="col-sm-5" path="name">Name:</form:label>
   						<div class="col-sm-7">
       						<form:input class="form-control" path="name"/>
       						<form:errors class="text-danger" path="name"/>
      					</div>
    				</div>
    				<div class="form-group row">
   						<form:label class="col-sm-5" path="date">Date</form:label>
   						<div class="col-sm-7">
       						<form:input type="date" class="form-control" path="date"/>
       						<form:errors class="text-danger" path="date"/>
      					</div>
    				</div>
    				<div class="form-group row">
   						<form:label class="col-sm-5" path="location">Location:</form:label>
   						<div class="col-sm-4">
       						<form:input class="form-control" path="location"/>
       						<form:errors class="text-danger" path="location"/>
      					</div>
      					<div class="col-sm-3">
      						<form:select class="form-control" id="sel1" path="state">
      							<c:forEach items="${states}" var="state">
      								<form:option path="state" value="${state.id}" label="${state.state}"/>
      							</c:forEach>
      						</form:select>
      						<form:errors path="state"/>
      					</div>
    				</div>
    				<button type="submit" class="btn btn-success">Create</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>