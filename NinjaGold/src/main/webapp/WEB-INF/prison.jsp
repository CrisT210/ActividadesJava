<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Prision</title>
</head>
<body>
	<div class="container p-5">
		<div class="row justify-content-center"> 
			<div class="col-md-8">
				<h1 class="display-1 mb-5">GAME OVER</h1>
				<h1 class="display-4">Prisión</h1>
				<h2>Debes mas de 50 monedas de oro!!</h2>
				<img src="/img/prision.png" class="img-thumbnail" alt="Cinque Terre">
				
				<form action="/gold" method="POST">
    				<input type="hidden" name="opcion" value="0">
					<button class="btn btn-lg btn-warning mt-3">Reset</button>	
    			</form>
			</div>
		</div>
	</div>
</body>
</html>