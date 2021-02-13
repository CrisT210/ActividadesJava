<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-8 py-3 border">
				<h2 class="display-4 text-center">New License</h2>
				<form:form class="mt-3" action="/licenses/new" method="post" modelAttribute="license">
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="person">Person</form:label>
    					<div class="col-sm-7">
        					<form:select class="form-control" id="sel1" path="person">
        						<form:option value = "NONE" label = "Select"/>
        						<c:forEach items="${persons}" var="person">
        							<form:option path="person" value="${person.id}" label="${person.firstName} ${person.lastName}"/>
        						</c:forEach>
  							</form:select>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="state">State</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="state"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="expirationDate">Expiration Date</form:label>
    					<div class="col-sm-7">
        					<form:input type="date" class="form-control" path="expirationDate"/>
        					<form:errors class="text-danger" path="expirationDate"/>
    					</div>
    				</div>
    				<button type="submit" class="btn btn-success float-right">Create</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>