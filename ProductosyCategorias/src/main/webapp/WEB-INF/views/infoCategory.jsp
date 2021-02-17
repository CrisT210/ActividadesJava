<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
	<div class="container p-5">
		<div class="row mb-5">
			<div class="col">
				<h1 class="display-4"> <c:out value="${category.name}"/> </h1>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h1>Products:</h1>
				<ul class="list-group list-group-flush">
  					<c:forEach items="${pro}" var="cat">
						<li class="list-group-item">- <c:out value="${cat.name}"/></li>
					</c:forEach>	
				</ul>
			</div>
			<div class="col">
				<form class="mt-3" action="/categories/${category.id}" method="post">
    				<div class="form-group row">
    					<label class="col-sm-5">Add Product:</label>
    					<div class="col-sm-7">
        					<select name="productId" class="form-control">
        						<option value = "NONE" label = "Select"/>
        						<c:forEach items="${products}" var="product">
        							<option value="${product.id}" label="${product.name}"/>
        						</c:forEach>
  							</select>
    					</div>
    				</div>
    				<button type="submit" class="btn btn-success float-right">Create</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>