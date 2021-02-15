<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Pagina Dojo</title>
</head>
<body>
	<div class="container p-5">
		<div class="row">
			<div class="col">
			<h1 class="display-4">Listado de Ninjas Dojo <c:out value="${dojo.nombre}"/></h1>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Edad</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ninjas}" var="ninja">
							<tr>
								<td><c:out value="${ninja.nombre}"/></td>
								<td><c:out value="${ninja.apellido}"/></td>
								<td><c:out value="${ninja.edad}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>