<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>Top 10</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<h1 class="display-4">Top 10</h1>
			</div>
			<div class="col-md-2">
				<a href="/dashboard" type="button" class="btn btn-info"><i class="bi bi-house"></i> Inicio</a>
			</div>
		</div>
		<div class="row justify-content-center mt-5">
			<div class="col-md-6 border">
				<ul class="list-group list-group-flush">
					<c:forEach items="${songs}" var="song">
						<li class="list-group-item"><c:out value="${song.clasificacion}"/> - <a href="/songs/${song.id}"><c:out value="${song.titulo}"/></a> - <c:out value="${song.artista}"/></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>