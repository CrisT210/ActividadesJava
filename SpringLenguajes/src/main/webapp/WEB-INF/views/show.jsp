<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>Mostrar</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center mb-5">
			<div class="col-md-8">
				<a href="/lenguajes" class="btn btn-info float-right"><i class="bi bi-house"></i> Inicio</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card bg-light text-dark">
    				<div class="card-body">
    					<div class="row mb-3">
							<label class="col-sm-5">Nombre</label>
							<div class="col-sm-7">
								<span class="form-control text-center"><c:out value="${leng.nombre}"/></span>
							</div>
						</div>
						<div class="row mb-3">
							<label class="col-sm-5">Creador</label>
							<div class="col-sm-7">
								<span class="form-control text-center"><c:out value="${leng.creador}"/></span>
							</div>
						</div>
						<div class="row mb-3">
							<label class="col-sm-5">Version</label>
							<div class="col-sm-7">
								<span class="form-control text-center"><c:out value="${leng.version}"/></span>
							</div>
						</div>
						<div class="row">
							<form action="/lenguajes/${leng.id}" method="post">
    							<input type="hidden" name="_method" value="delete">
    							<button class="btn btn-danger mr-1"><i class="bi bi-trash"></i> Eliminar</button>	
							</form>						
							<a href="/lenguajes/${leng.id}/editar" class="btn btn-info"><i class="bi bi-journal-text"></i> Editar</a>
						</div>
					</div>
  				</div>
			</div>
		</div>
	</div>
</body>
</html>