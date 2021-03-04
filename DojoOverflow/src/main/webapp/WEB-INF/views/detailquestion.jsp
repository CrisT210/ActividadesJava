<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Question Profile</title>
</head>
<body>
	<div class="container-fluid p-5">
		<div class="row justify-content-center">
			<div class="col-md-10">
				<h1 class="display-4 text-center"><c:out value="${question.question}"/></h1>
				<div class="row justify-content-start">
					<h1 class="col-md-1">Tags:</h1>
					<div class="col-md-11">
						<c:forEach items="${question.tags}" var="tag">
							<h2><span class="badge badge-info"><c:out value="${tag.subject}"/></span></h2>
						</c:forEach>
					</div>				
				</div>
			</div>			
		</div>
		<div class="row">
				<div class="col p-5">
					<table class="table border">
						<thead class="thead-light">
							<tr>
								<th>Answers</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${question.answers}" var="answer">
								<tr>
									<td><c:out value="${answer.answer}"/></td>								
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col p-5">
					<h1>Add your answer:</h1>
					<form:form class="mt-5" action="/questions/${question.id}" method="post" modelAttribute="ans">
						<form:hidden path="question" value="${question.id}"/>
						<div class="form-group row">
    						<form:label class="col-sm-5" path="answer">Answer</form:label>
    						<div class="col-sm-7">
        						<form:textarea class="form-control" rows="5" path="answer"/>
        						<form:errors class="text-danger" path="answer"/>
        					</div>
    					</div>
    					<button type="submit" class="btn btn-success float-right">Answer it</button>
					</form:form>
				</div>
			</div>
	</div>
</body>
</html>