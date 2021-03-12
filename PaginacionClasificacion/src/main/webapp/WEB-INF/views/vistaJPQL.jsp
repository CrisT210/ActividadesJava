<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
    	<thead>
        	<tr>
        		<th>Dojo Name</th>
        		<th>Ninja First Name</th>
        		<th>Ninja Last Name</th>
        	</tr>
    	</thead>
    	<tbody>
        	<c:forEach var="row" items="${table}">                
        	<tr>
            	<td>${row[0].nombre}</td>
            	<td>${row[1].nombre}</td>
            	<td>${row[1].apellido}</td>
        	</tr>
        	</c:forEach>
    	</tbody>
	</table>
</body>
</html>