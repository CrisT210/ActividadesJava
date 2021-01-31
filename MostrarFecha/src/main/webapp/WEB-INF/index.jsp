<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Tablero del tiempo</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Tablero del tiempo</h1>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-6 text-center">
				<a href="/date" class="btn btn-info" role="button">Platilla Fecha</a>
			</div>
			<div class="col-6 text-center">
				<a href="/time" class="btn btn-info" role="button">Platilla Hora</a>
			</div>
		</div>
	</div>
</body>
</html>