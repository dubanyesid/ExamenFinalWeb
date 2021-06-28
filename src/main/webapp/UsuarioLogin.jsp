<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>

<body>
	<form class="w-50 p-3" action="UsuarioLoginController"
		method="POST">
		<div class="form-group">
			<label for="usuario">Usuario</label> <input type="text" required
				class="form-control" placeholder="Enter email" name="usuario">
		</div>
		<div class="form-group">
			<label for="pass">Password</label> <input type="password" required
				class="form-control" placeholder="Password" name="pass">
		</div>
		<button type="submit" class="btn btn-primary">Registrar</button>
	</form>
</body>

</html>