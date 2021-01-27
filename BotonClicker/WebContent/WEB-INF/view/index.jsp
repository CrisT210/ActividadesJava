<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Clicker</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-2 p-5">
				<form action="/BotonClicker/Contador" method="get">
					<button name="count" value="1" type="submit" class="btn btn-info">Clickeame</button>
				</form>
			</div>
		</div>
		<div class="row justify-content-center">
			<h5 class="display-4">Haz hecho click en este boton <c:out value="${conteo}"/> veces.</h5>
		</div>
	</div>
	
</body>
</html>