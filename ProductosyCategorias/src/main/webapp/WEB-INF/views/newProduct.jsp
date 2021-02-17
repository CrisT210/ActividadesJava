<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-8">
				<h1 class="display-4 mb-3">New Product</h1>
				<form:form class="mt-3" action="/products/new" method="post" modelAttribute="product">
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="name">Name:</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="name"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="description">Description</form:label>
    					<div class="col-sm-7">
    						<form:textarea class="form-control" path="description"/>
    					</div>
    				</div>
    				<div class="form-group row">
    					<form:label class="col-sm-5" path="price">Price</form:label>
    					<div class="col-sm-7">
        					<form:input class="form-control" path="price"/>
    					</div>
    				</div>
    				<button type="submit" class="btn btn-success float-right">Create</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>