<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>New Category</title>
</head>
<body>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-8">
				<h1 class="display-4 mb-3">New Category</h1>
				<form action="/categories/new" method="post">
					<div class="form-group row">
    					<label class="col-sm-5">Name</label>
    					<div class="col-sm-7">
        					<input class="form-control" name="name"/>
    					</div>
    				</div>
    				<button type="submit" class="btn btn-success float-right">Create</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>