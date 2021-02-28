<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Palabras Aleatorias</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-8 d-flex align-items-center flex-column">
				<h3 class="my-3">Haz generado una palabra aleatoria <c:out value="${conteo}"/> veces.</h3>
				<span class="rounded-lg border border-info p-2 bg-secondary text-white"><c:out value="${str}"/></span>
				<form class="mt-3" method="get">
					<button type="submit" name="count" value="1" class="btn btn-success">Generar</button>
				</form>
				<h3 class="my-3">La última vez que se generó una palabra fue:</h3>
				<span class="rounded-lg border border-info p-2 bg-secondary text-white"><c:out value="${date}"/></span>
			</div>
		</div>	
	</div>
</body>
</html>