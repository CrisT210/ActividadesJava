<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>Editar</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-end">
			<div class="col-md-2 py-5">
				<form action="/lenguajes/${leng.id}" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<button class="btn btn-danger float-right"><i class="bi bi-trash"></i> Eliminar</button>	
				</form>
			</div>
			<div class="col-md-2 py-5">
				<a href="/lenguajes" class="btn btn-info float-left"><i class="bi bi-house"></i> Inicio</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-8 py-3 border">
				<h2 class="text-center">Editar</h2>
				<form:form class="mt-3" action="/lenguajes/${leng.id}" method="post" modelAttribute="leng">
    				<input type="hidden" name="_method" value="put">
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="nombre">Nombre</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="nombre"/>
        					<form:errors class="text-danger" path="nombre"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="creador">Creador</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="creador"/>
        					<form:errors class="text-danger" path="creador"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="version">Version</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="version"/>
        					<form:errors class="text-danger" path="version"/>
    					</div>
    				</div>
    				<button type="submit" class="btn btn-success float-right">Guardar</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>