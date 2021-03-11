<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Consultas</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<p>¿Qué consulta ejecutarías para obtener todos los países que hablan Sloveno? Su consulta debe retornar el nombre del país, lenguaje y porcentaje del lenguaje. Su consulta debe organizar los resultados por porcentaje en orden descendente.</p>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Pais</th>
							<th>lenguaje</th>
							<th>Porcentaje</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${slo}" var="row">
							<tr>
								<td><c:out value="${row[0].name}"/></td>
								<td><c:out value="${row[1].language}"/></td>
								<td><c:out value="${row[1].percentage}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>¿Qué consulta ejecutarías para mostrar el número total de ciudades de cada país? Su consulta debe retornar el nombre del país y el número total de ciudades. Su consulta debe organizar los resultados por número de ciudades en orden descendente.</p>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Pais</th>
							<th>Total ciudades</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${count}" var="row">
							<tr>
								<td><c:out value="${row[0].name}"/></td>
								<td><c:out value="${row[1]}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>¿Qué consulta ejecutarías para obtener todas las ciudades en México con una población mayor a 500.000? Su consulta debe organizar los resultados por población en orden descendente.</p>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Pais</th>
							<th>Total ciudades</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mex}" var="city">
							<tr>
								<td><c:out value="${city.name}"/></td>
								<td><c:out value="${city.population}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>¿Qué consulta ejecutarías para obtener todos los lenguajes en cada país con un porcentaje mayor al 89%? Su consulta debe organizar los resultados por porcentaje en orden descendente.</p>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Pais</th>
							<th>languages</th>
							<th>Percentage</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lang}" var="row">
							<tr>
								<td><c:out value="${row[0].name}"/></td>
								<td><c:out value="${row[1].language}"/></td>
								<td><c:out value="${row[1].percentage}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>¿Qué consulta ejecutarías para obtener todos los países con un superficie de área inferior a 501 y una población mayor a 100.000?</p>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Pais</th>
							<th>Area</th>
							<th>Population</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${area}" var="country">
							<tr>
								<td><c:out value="${country.name}"/></td>
								<td><c:out value="${country.surface_area}"/></td>
								<td><c:out value="${country.population}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>¿Qué consulta ejecutarías para obtener todos los países que tienen solo Constitutional Monarchy (Monarquía) y una superficie de área mayor a 200 y una expectativa de vida superior a los 75 años?</p>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Pais</th>
							<th>Area</th>
							<th>Life Expectancy</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${monarchy}" var="monarchy">
							<tr>
								<td><c:out value="${monarchy.name}"/></td>
								<td><c:out value="${monarchy.surface_area}"/></td>
								<td><c:out value="${monarchy.life_expectancy}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>¿Qué consulta ejecutarías para obtener todas las ciudades de Argentina dentro del distrito de Buenos Aires y que tengan una población mayor a 500.000? La consulta debe retornar el nombre del país, nombre de la ciudad, distrito y población.</p>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Pais</th>
							<th>City</th>
							<th>Distric</th>
							<th>Population</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${arg}" var="row">
							<tr>
								<td><c:out value="${row[0].name}"/></td>
								<td><c:out value="${row[1].name}"/></td>
								<td><c:out value="${row[1].distric}"/></td>
								<td><c:out value="${row[1].population}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>¿Qué consulta ejecutarías para sumar el número de países en cada región? La consulta debe mostrar el nombre de la región y el número de países. Además, la consulta debe organizar los resultados por el número de países en orden descendente.</p>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Continent</th>
							<th>Count</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${continent}" var="row">
							<tr>
								<td><c:out value="${row[0]}"/></td>
								<td><c:out value="${row[1]}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>