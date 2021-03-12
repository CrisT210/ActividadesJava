<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Nuevo Ninja</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<h1 class="display-4 mb-3">Nuevo Ninja</h1>
				<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
					<div class="form-group row">
    					<form:label class="col-sm-5" path="dojo">Dojo:</form:label>
    					<div class="col-sm-7">
        					<form:select class="form-control" id="sel1" path="dojo">
        						<form:option value = "NONE" label = "Selecciona"/>
        						<c:forEach items="${dojos}" var="dojo">
        							<form:option path="dojo" value="${dojo.id}" label="${dojo.nombre}"/>
        						</c:forEach>
  							</form:select>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="nombre">Nombre:</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="nombre"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="apellido">Apellido</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="apellido"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="edad">Edad</form:label>
    					<div class="col-sm-7">
        					<form:input type="number" class="form-control" path="edad"/>
    					</div>
    				</div>
    				<button type="submit" class=" btn btn-primary">Crear</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>