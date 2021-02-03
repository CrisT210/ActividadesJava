<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Detalle Informacion</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-6 border border-dark p-3">
				<div class="row">
					<h5 class="col-md-12 mb-2">Detalle información enviada</h5>
					<label class="col-md-6 mb-2">Nombre:</label>
					<span class="col-md-6 mb-2"><c:out value="${nom}"/></span>
					<label class="col-md-6 mb-2">Ubicacion Dojo:</label>
					<span class="col-md-6 mb-2"><c:out value="${ubi}"/></span>
					<label class="col-md-6 mb-2">Lenguaje Favorito:</label>
					<span class="col-md-6 mb-2"><c:out value="${leng}"/></span>
					<label class="col-md-6 mb-2">Comentarios:</label>
					<span class="col-md-6 mb-2"><c:out value="${com}"/></span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>