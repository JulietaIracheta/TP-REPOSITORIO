<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="es">
<head>
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punto 6 TP 1</title>
</head>
<body>
<div class="container">
	<div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-5 col-sm-offset-2">
		<form:form method="post" action="validar-tp" modelAttribute="cadena">
			<label>Ingrese cadena de caracteres: </label><hr>
			<form:input path="texto" id="texto" type="text" class="form-control"/><hr>
			<label>Ingrese acción a realizar: </label><hr>
			<form:select path="accion" id="accion" type="text" class="form-control">
			<form:option value="Pasar cadena a mayúsculas">Pasar cadena a mayúsculas</form:option>
			<form:option value="Pasar cadena a minúsculas">Pasar cadena a minúsculas</form:option>
			<form:option value="Invertir Orden">Invertir Orden</form:option>
			<form:option value="Mostrar cantidad de caracteres">Mostrar cantidad de caracteres</form:option>
			</form:select>
			<hr>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
		</form:form>
	</div>
</div>
</body>
</html>