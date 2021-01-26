<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crea tu mascota</title>
</head>
<body>
	<h3>Ingresar un Perro</h3>
	<form action="/Mascotas/ShowPerro">
  		<label for="pname">Nombre:</label><br>
  		<input type="text" id="pname" name="pname"><br>
  		<label for="praza">Raza:</label><br>
  		<input type="text" id="praza" name="praza"><br>
  		<label for="ppeso">Peso:</label><br>
  		<input type="number" id="ppeso" name="ppeso"><br><br>
  		<input type="submit" value="Enviar">
	</form> 
	
	<h3>Ingresar un Gato</h3>
	<form action="/Mascotas/ShowGato">
  		<label for="gname">Nombre:</label><br>
  		<input type="text" id="gname" name="gname"><br>
  		<label for="graza">Raza:</label><br>
  		<input type="text" id="graza" name="graza"><br>
  		<label for="gpeso">Peso:</label><br>
  		<input type="number" id="gpeso" name="gpeso"><br><br>
  		<input type="submit" value="Enviar">
	</form> 
</body>
</html>