<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-8 py-3 border">
				<h2 class="display-4 text-center">New Person</h2>
				<form:form class="mt-3" action="/persons/new" method="post" modelAttribute="person">
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="firstName">First Name</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="firstName"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="lastName">Last Name</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="lastName"/>
    					</div>
    				</div>
    				<button type="submit" class="btn btn-success float-right">Create</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>