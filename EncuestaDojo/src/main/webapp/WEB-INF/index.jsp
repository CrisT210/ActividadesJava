<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Indice de encuestas de Dojo</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-6 border border-dark p-3">
				<form class="form" action="/result" method="POST">
					<div class="form-group row">
    					<label class="col-sm-6 col-form-label">Nombre:</label>
    					<div class="col-sm-6">
      						<input type="text" class="form-control" name="nom">
    					</div>
  					</div>
					<div class="form-group row">
    					<label class="col-sm-6 col-form-label">Ubicacion Dojo:</label>
    					<div class="col-sm-6">
      						<!-- <input type="text" class="form-control" name="ubi"> -->
      						<select name="ubi" class="custom-select">
    							<option selected></option>
    							<c:forEach items="${ciudades}" var="ciudad">
    							<option>${ciudad}</option>
  								</c:forEach>
  							</select>
    					</div>
  					</div>
					<div class="form-group row">
    					<label class="col-sm-6 col-form-label">Lenguaje Favorito:</label>
    					<div class="col-sm-6">
      						<!-- <input type="text" class="form-control" name="leng"> -->
      						<select name="leng" class="custom-select">
    							<option selected></option>
    							<c:forEach items="${lenguajes}" var="lenguaje">
    							<option>${lenguaje}</option>
  								</c:forEach>
  							</select>
    					</div>
  					</div>
					<div class="form-group">
    					<label for="exampleFormControlTextarea1">Comentarios(opcional):</label>
    					<textarea class="form-control" name="com" rows="3"></textarea>
  					</div>
  					<button type="submit" class="btn btn-success float-right">Enviar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>