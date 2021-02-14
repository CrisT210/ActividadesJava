<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>Nueva Cancion</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-end mb-5">
			<div class="col-md-3">
				<a href="/dashboard" type="button" class="btn btn-info"><i class="bi bi-house"></i> Inicio</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 py-3 border bg-light">
				<form:form class="mt-3" action="/songs/new" method="post" modelAttribute="song">
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="titulo">Titulo</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="titulo"/>
        					<form:errors class="text-danger" path="titulo"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="artista">Artista</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="artista"/>
        					<form:errors class="text-danger" path="artista"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="clasificacion">Clasificacion(1 - 10)</form:label>
    					<div class="col-sm-7">
        					<form:input type="number" class="form-control" path="clasificacion"/>
        					<form:errors class="text-danger" path="clasificacion"/>
    					</div>
    				</div>
    				<button type="submit" class="btn btn-success float-right">Guardar</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>