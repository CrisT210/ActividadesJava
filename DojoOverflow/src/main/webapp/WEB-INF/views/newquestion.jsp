<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>New Question</title>
</head>
<body>
	<div class="container-fluid p-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h1 class="display-4">What is your question?</h1>
				<div class="border bg-light p-3">
					<form:form class="mt-5" action="/questions/new" method="post" modelAttribute="quest">
						<div class="form-group row">
    						<form:label class="col-sm-5" path="question">Question</form:label>
    						<div class="col-sm-7">
        						<form:textarea class="form-control" rows="5" path="question"></form:textarea>
        						<form:errors class="text-danger" path="question"/>
        					</div>
    					</div>
    					<div class="form-group row">
    						<label class="col-sm-5">Tag</label>
    						<div class="col-sm-7">
        						<input class="form-control" name="tag"/>
        					</div>
    					</div>
    					<button type="submit" class="btn btn-success">Submit</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>