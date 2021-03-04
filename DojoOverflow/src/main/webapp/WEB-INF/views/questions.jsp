<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Questions Dashboard</title>
</head>
<body>
	<div class="container-fluid p-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h1 class="display-4">Questions Dashboard</h1>
				<table class="table border">
					<thead class="thead-light">
						<tr>
							<th>Questions</th>
							<th>Tags</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${questions}" var="question">
							<tr>
								<td><a href="/questions/${question.id}"><c:out value="${question.question}"/></a></td>
								<td>
									<c:forEach items="${question.tags}" var="tag">
										<c:out value="${tag.subject}"/>,
									</c:forEach>	
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="/questions/new" type="button" class="btn btn-success float-right">New Question</a>
			</div>
		</div>
	</div>
</body>
</html>