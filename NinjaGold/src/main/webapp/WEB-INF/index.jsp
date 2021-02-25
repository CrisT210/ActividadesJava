<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Juego Ninja Gold</title>
</head>
<body>
	<div class="container-fluid p-5">
		<div class="row">
			<div class="col-md-11">
				<div class="row justify-content-start">
					<h1 class="col-md-2 display-4">Tu Oro:</h1>
					<input type="text" class="col-md-1 form-control form-control-lg mt-3" value="<c:out value='${gold}'/>" disabled>
				</div>
			</div>
			<div class="col-md-1">
				<form action="/gold" method="POST">
    				<input type="hidden" name="opcion" value="0">
					<button class="btn btn-lg btn-warning mt-3">Reset</button>	
    			</form>
			</div>
		</div>
		<div class="row p-5 text-center">
			<div class="card bg-secondary text-white col mr-5">
    			<div class="card-body">
    				<h3 class="mb-3">Granja</h3>
    				<h5 class="mb-5">(Gana 10-20 de oro)</h5>
    				<form action="/gold" method="POST">
    					<input type="hidden" name="opcion" value="1">
    					<button type="submit" class="btn btn-success mb-3">¡Encontrar Oro!</button>
    				</form>
    			</div>
  			</div>
  			<div class="card bg-secondary text-white col mr-5">
    			<div class="card-body">
					<h3 class="mb-3">Cueva</h3>
					<h5 class="mb-5">(Gana 5-10 de oro)</h5>
					<form action="/gold" method="POST">
						<input type="hidden" name="opcion" value="2">
						<button type="submit" class="btn btn-success mb-3">¡Encontrar Oro!</button>
					</form>
				</div>
  			</div>
  			<div class="card bg-secondary text-white col mr-5">
    			<div class="card-body">
    				<h3 class="mb-3">Casa</h3>
    				<h5 class="mb-5">(Gana 2-5 de oro)</h5>
    				<form action="/gold" method="POST">
    					<input type="hidden" name="opcion" value="3">
    					<button type="submit" class="btn btn-success mb-3">¡Encontrar Oro!</button>
    				</form>
    			</div>
  			</div>
  			<div class="card bg-secondary text-white col mr-5">
    			<div class="card-body">
    				<h3 class="mb-3">Casino</h3>
    				<h5 class="mb-5">(Gana/Toma 0-50 de oro)</h5>
    				<form action="/gold" method="POST">
    					<input type="hidden" name="opcion" value="4">
    					<button type="submit" class="btn btn-success mb-3">¡Encontrar Oro!</button>
    				</form>
    			</div>
  			</div>
  			<div class="card bg-secondary text-white col">
    			<div class="card-body">
    				<h3 class="mb-3">Spa</h3>
    				<h5 class="mb-5">(Toma 5-20 de oro)</h5>
    				<form action="/gold" method="POST">
    					<input type="hidden" name="opcion" value="5">
    					<button type="submit" class="btn btn-success mb-3">¡Encontrar Oro!</button>
    				</form>
    			</div>
  			</div>
		</div>
		<div class="row">
			<div class="col">
				<h1 class="display-4">Actividades:</h1>
				<div style="height: 200px;" class="border rounded-lg border-secondary overflow-auto bg-light p-1">
					<c:forEach items="${historial}" var="actividad">
							${actividad}
  					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>