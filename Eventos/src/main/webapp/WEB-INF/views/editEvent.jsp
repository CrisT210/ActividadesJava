<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Events</title>
</head>
<body>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-8">
				<h1 class="display-4 mb-5"><c:out value="${event.name}"/></h1>
				<h1>Edit Event</h1>
				<form:form class="mt-5" action="/events/${event.id}/edit" method="post" modelAttribute="event">
					<input type="hidden" name="_method" value="put"/>
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
    				<button type="submit" class="btn btn-success">Edit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>