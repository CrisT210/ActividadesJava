<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>Detalles</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-end mb-5">
			<div class="col-md-3">
				<a href="/dashboard" type="button" class="btn btn-info"><i class="bi bi-house"></i> Inicio</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 border bg-light p-3">
				<div class="form-group">
    				<label>Titulo:</label>
    				<span class="form-control"><c:out value="${song.titulo}"/></span>
  				</div>
  				<div class="form-group">
    				<label>Artista:</label>
    				<span class="form-control"><c:out value="${song.artista}"/></span>
  				</div>
  				<div class="form-group">
    				<label>Clasificacion:</label>
    				<span class="form-control"><c:out value="${song.clasificacion}"/></span>
  				</div>
  				<form action="/songs/${song.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<button class="btn btn-danger"><i class="bi bi-trash"></i> Eliminar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>