<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Codigo Secreto</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center text-center">
			<div class="col-6 mt-5">
				<span class="text-danger font-weight-bold"><c:out value="${error}"></c:out></span>
				<form class="text-center mt-3" action="/validar" method="POST">
					<div class="form-group">
    					<label for="uname">¿Cuál es el código?</label>
    					<input type="text" class="form-control" name="codigo" required>
  					</div>
  					<button type="submit" class="btn btn-primary">Enviar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>