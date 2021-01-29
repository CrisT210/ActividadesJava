<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>El Gran Juego de los Numeros</title>
</head>
<body>
	<div class="container">
		<div class="row mb-3">
			<div class="col text-center">
				<h1 class="mt-3">Bienvenidos al Gran Juego de los Numeros</h1>
				<p>Estoy pensando en un numero entre 1 y 100</p>
				<h6>Adivina!!!</h6>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-3">
				<div style='display: <c:out value="${display}"/>' class="p-3 mb-3 <c:out value="${bg}"/> rounded-lg text-center">
					<h1><c:out value="${res}"/></h1>
					<form>
						<button style='display: <c:out value="${newGame}"/>' type="submit" class="btn btn-primary btn-block">Nuevo Juego</button>
					</form>
				</div>
				<form style='display: <c:out value="${form}"/>' action="/GreatNumber/ShowGame" method="POST">
					<input type="number" name="num" class="form-control mb-3" placeholder="Ingresa un Numero" required>
					<button type="submit" class="btn btn-info">Enviar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html> 