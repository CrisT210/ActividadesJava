<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-5">
				<h3>Canciones del artista: <c:out value="${search}"/></h3>
			</div>
			<div class="col-md-5">
				<form action="/dashboard" method="post">
					<div class="input-group mb-3">
  					<input type="text" class="form-control" name="artista" placeholder="Buscar Artista">
  					<div class="input-group-append">
    					<button class="btn btn-success" type="submit">Nueva Busqueda</button>
  					</div>
				</div>
				</form>
			</div>
			<div class="col-md-2">
				<a href="/dashboard" type="button" class="btn btn-info"><i class="bi bi-house"></i> Inicio</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Nombre</th>
							<th>Clasificacion</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listado}" var="song">
							<tr>
								<td><a href="/songs/${song.id}"><c:out value="${song.titulo}"/></a></td>
								<td><c:out value="${song.clasificacion}"/></td>
								<td class="row">
									<form action="/songs/${song.id}" method="post">
    									<input type="hidden" name="_method" value="delete">
    									<button class="btn btn-danger"><i class="bi bi-trash"></i> Eliminar</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>