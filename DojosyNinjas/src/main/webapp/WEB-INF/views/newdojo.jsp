<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Nuevo Dojo</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h1 class="display-4 mb-3">Nuevo Dojo</h1>
				<form action="/dojos/new" method="post">
					<div class="form-group row">
    					<label class="col-sm-5">Nombre:</label>
    					<div class="col-sm-7">
        					<input class="form-control" name="nombre"/>
    					</div>
    				</div>
    				<button type="submit" class="btn btn-primary">Crear</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>