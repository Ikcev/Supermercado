 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Modificar Productos</title>
</head>
<body class="container" >
	<h1 style="text-align: center">Modificar Producto</h1>
	
<form method="POST" action="modificarProducto">

		<label for="codigo" class="form-label">Codigo de Producto</label>
		<input type="text" id="codigo" class="form-control" name="codigo" value="${producto.codigo}"><br>
		<label for="nombre" class="form-label">Nombre de Producto</label>
		<input type="text" id="nombre" class="form-control" name="nombre" value="${producto.nombre}"><br>
		<label for="cantidad" class="form-label">Cantidad</label>
		<input type="text" id="cantidad" class="form-control" name="cantidad" value="${producto.cantidad}"><br>
		<label for="precio" class="form-label">Precio</label>
		<input type="text" id="precio" class="form-control" name="precio" value="${producto.precio}"><br>
		<label for="caducidad" class="form-label">Fecha de Caducidad</label>
		<input type="date" id="caducidad" class="form-control" name="caducidad" value="${producto.caducidad}"><br>
		<label for="seccion" class="form-label">Seccion</label>
		<select id="id_seccion" name="id_seccion" class="form-select">
			<c:forEach items="${ secciones }" var="seccion">
				<option value="${seccion.id}">${seccion.id}</option>
			</c:forEach>
		</select><br>
		<a class="btn btn-primary" href="mostrarProductos">Cancelar</a>
		<button type="submit" class="btn btn-primary">Enviar</button>
	</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>