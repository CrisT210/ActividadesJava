<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<h1 class="col-md display-4 p-5">Welcome</h1>
		</div>
		<div class="row p-5">
			<div class="col px-5 py-3 bg-light border mr-5">
				<h1>Register</h1>
				<form:form class="mt-5" action="/registered" method="post" modelAttribute="register">
					<div class="form-group row">
   						<form:label class="col-sm-5" path="firstName">First Name:</form:label>
   						<div class="col-sm-7">
       						<form:input class="form-control" path="firstName"/>
       						<form:errors class="text-danger" path="firstName"/>
      					</div>
    				</div>
    				<div class="form-group row">
   						<form:label class="col-sm-5" path="lastName">Last Name:</form:label>
   						<div class="col-sm-7">
       						<form:input class="form-control" path="lastName"/>
       						<form:errors class="text-danger" path="lastName"/>
      					</div>
    				</div>
    				<div class="form-group row">
   						<form:label class="col-sm-5" path="email">Email:</form:label>
   						<div class="col-sm-7">
       						<form:input type="email" class="form-control" path="email"/>
       						<form:errors class="text-danger" path="email"/>
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
    				<div class="form-group row">
   						<form:label class="col-sm-5" path="password">Password:</form:label>
   						<div class="col-sm-7">
       						<form:password class="form-control" path="password"/>
       						<form:errors class="text-danger" path="password"/>
      					</div>
    				</div>
    				<div class="form-group row">
   						<form:label class="col-sm-5" path="pswconf">Password confirm:</form:label>
   						<div class="col-sm-7">
       						<form:password class="form-control" path="pswconf"/>
       						<form:errors path="pswconf"/>
      					</div>
    				</div>					
    				<button type="submit" class="btn btn-success">Register</button>
				</form:form>
			</div>
			<div class="col px-5 py-3 bg-light border ml-5">
				<h1>Login</h1>
				<form class="mt-5" action="/login" method="post">
					<p class="text-danger"><c:out value="${error}"/></p>
					<div class="form-group row">
   						<label class="col-sm-5">Email:</label>
   						<div class="col-sm-7">
       						<input class="form-control" name="email"/>
      					</div>
    				</div>
   					<div class="form-group row">
   						<label class="col-sm-5">Password:</label>
   						<div class="col-sm-7">
       						<input type="password" class="form-control" name="password"/>
      					</div>
    				</div>
    				<button type="submit" class="btn btn-success">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>