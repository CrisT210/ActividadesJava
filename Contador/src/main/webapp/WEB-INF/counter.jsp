<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Recuento de Visitas Actual</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col mt-5">
				<p class="display-4 mb-5">Haz visitado <a href="http://localhost:8080/">http://localhost:8080/</a> <c:out value="${conteo}" default="0"/> veces.</p>
				<h5 class="mb-3"><a href="http://localhost:8080/">¿Quieres registrar otra visita?</a></h5>
				<h5 class="mb-5"><a href="http://localhost:8080/counter-doble">¿Quieres registrar una visita doble?</a></h5>
				<a href="http://localhost:8080/counter?c=0" class="btn btn-success" role="button">Resetear</a>
			</div>
		</div>
	</div>
</body>
</html>