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
<title>Lenguajes</title>
</head>
<body>
	<div class="container p-5">
		<div class="row">
			<div class="col mb-5">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Nombre</th>
							<th>Creador</th>
							<th>Version</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lengs}" var="leng">
							<tr>
								<td><a href="/lenguajes/${leng.id}"><c:out value="${leng.nombre}"/></a></td>
								<td><c:out value="${leng.creador}"/></td>
								<td><c:out value="${leng.version}"/></td>
								<td class="row">
									<a href="/lenguajes/${leng.id}/editar" class="btn btn-info mr-1"><i class="bi bi-journal-text"></i></a>
									<form action="/lenguajes/${leng.id}" method="post">
    									<input type="hidden" name="_method" value="delete">
    									<button class="btn btn-danger"><i class="bi bi-trash"></i></button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-8 py-3 border">
				<h2 class="text-center">Nuevo Lenguaje</h2>
				<form:form class="mt-3" action="/lenguajes" method="post" modelAttribute="leng">
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