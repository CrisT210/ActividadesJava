<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script type="text/javascript" src="js/funciones.js"></script>
<meta charset="UTF-8">
<title>Hora</title>
</head>
<body onload="alertTime()">
	<div class="jumbotron text-center">
		<h1>Tablero del tiempo</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col text-center mt-5">
				<p class="display-4 green"><c:out value="${hora}"/></p>
			</div>
		</div>
	</div>
</body>
</html>