<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css"/>
<title>Insert title here</title>
</head>
<body>
	<%
	try{
	int w = Integer.parseInt(request.getParameter("ancho"));
	int h = Integer.parseInt(request.getParameter("alto"));
	int aux = 0;
	%>
	<h1>Tablero de Damas: <%=w %> Ancho x <%=h %> Alto</h1>
	<div class="contenedor">
	<%
	for(int i = 0; i < w ; i++){
	%>
		<div>
	<%		
		for(int j = 0; j < h; j++){
			if(aux % 2 == 0){
				aux++;
			%>
				<div class="rosado"></div>
			<%
			} else{
				aux++;
			%>
				<div class="azul"></div>
			<%}%>
		<%}%>
		</div>
	<%}%>
	</div>
	<%
	}catch(Exception e){
		out.println("Favor Ingresar parametros en la barra de direcciones");
	}
	%>
</body>
</html>