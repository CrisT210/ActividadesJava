<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-8 py-3 border">
				<h2 class="display-4 text-center"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h2>
				<div class="row">
					<div class="col">
						<p>License Number:</p>
					</div>
					<div class="col"><c:out value="${person.license.number}"/></div>
				</div>
				<div class="row">
					<div class="col">
						<p>State:</p>
					</div>
					<div class="col"><c:out value="${person.license.state}"/></div>
				</div>
				<div class="row">
					<div class="col">
						<p>Expiration Date:</p>
					</div>
					<div class="col"><c:out value="${person.license.expirationDate}"/></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>