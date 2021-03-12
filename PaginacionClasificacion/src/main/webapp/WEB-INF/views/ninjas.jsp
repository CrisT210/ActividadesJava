<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="ninjas">
    <h1>Ninjas</h1>
    
    <!-- for loop to create all the links  -->
    <c:forEach begin="1" end="${totalPages}" var="index">
        <a href="/pages/${index}">${index}</a>
    </c:forEach>
    <table class="table">
        <thead>
        	<tr>
        		<th>Dojo Name</th>
            	<th>Ninja First Name</th>
            	<th>Ninja Last Name</th>
            </tr>
        </thead>
        <tbody>
            <!-- Tenemos que invocar el método .content para obtener los ninjas dentro del objeto iterable Page. -->
            <c:forEach var="dojo" items="${dojos.content}">                 
            <tr>
                <td><c:out value="${dojo[0].nombre}"></c:out></td>
                <td><c:out value="${dojo[1].nombre}"></c:out></td>
                <td><c:out value="${dojo[1].apellido}"></c:out></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>