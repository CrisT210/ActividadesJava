<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>Lookify!</title>
</head>
<body>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-3">
				<a href="/songs/new" type="button" class="btn btn-info">Nueva Cancion</a>
			</div>
			<div class="col-md-3">
				<a href="/search/topTen" type="button" class="btn btn-info">Top Canciones</a>
			</div>
			<div class="col-md-6"> 
				<form action="/dashboard" method="post">
					<div class="input-group mb-3">
  						<input class="form-control" name="artista" placeholder="Buscar Artista"/>
  						<div class="input-group-append">
    						<button class="btn btn-success" type="submit">Buscar</button>
  						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table border">
					<thead class="thead-light">
						<tr>
							<th>Nombre</th>
							<th>Clasificacion</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${songs}" var="song">
							<tr>
								<td><a href="/songs/${song.id}"><c:out value="${song.titulo}"/></a></td>
								<td><c:out value="${song.clasificacion}"/></td>
								<td class="row m-0">
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