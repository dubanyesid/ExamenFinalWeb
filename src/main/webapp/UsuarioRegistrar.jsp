<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/bfd4c33ec6.js" crossorigin="anonymous"></script>
<title>Document</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>
	<form class="formulario" action="UsuarioRegistrarController" method="POST">
		<h1>Registrate</h1>
		<div class="contenedor">
		<div class="form-group">
			<i class="far fa-user icon"></i>
			<label for="user">Usuario</label>  <input type="text" required
				class="form-control" placeholder="Usuario" name="usuario"> 
			</div>
			</div>
		<div class="contenedor">
		<div class="form-group">
			<i class="far fa-envelope icon"></i>
			<label for="email">Email</label> <input type="email" required
				class="form-control" placeholder="email" name="email">
		</div>
		</div>
		<div class="contenedor">
		<div class="form-group">
			<i class="far fa-envelope icon"></i>
			<label for="password">Password</label> <input type="password" required
				class="form-control" placeholder="*****" name="pass">
		</div>
		</div>
		<div class="form-group">
			<select name="role">
				<c:forEach var="item" items="${roles}">
					<option value="<c:out value='${item.id}'/>"><c:out
							value="${item.description}" /></option>
				</c:forEach>
			</select>
		</div>

		<input type="hidden" class="form-control" name="state" value="1">

		<div class="form-group">
			<button type="submit" class="button">Registrar</button>
		</div>
	</form>
</body>

</html>