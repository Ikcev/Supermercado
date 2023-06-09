<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Productos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="container" >
	<h1 style="text-align: center">Insertar Producto</h1>

	<form method="POST" action="insertarProducto">

		<label for="codigo" class="form-label">Codigo de Producto</label>
		<input type="text" id="codigo" class="form-control" name="codigo"><br>
		<label for="nombre" class="form-label">Nombre de Producto</label>
		<input type="text" id="nombre" class="form-control" name="nombre"><br>
		<label for="cantidad" class="form-label">Cantidad</label>
		<input type="text" id="cantidad" class="form-control" name="cantidad"><br>
		<label for="precio" class="form-label">Precio</label>
		<input type="text" id="precio" class="form-control" name="precio"><br>
		<label for="caducidad" class="form-label">Fecha de Caducidad</label>
		<input type="date" id="caducidad" class="form-control" name="caducidad"><br>
		<label for="seccion" class="form-label">Seccion</label>
		<select id="id_seccion" name="id_seccion" class="form-select">
			<c:forEach items="${ secciones }" var="seccion">
				<option value="${seccion.id}">${seccion.id}</option>
			</c:forEach>
		</select><br>
		<a class="btn btn-primary" href="mostrarProductos">Cancelar</a>
		<button type="submit" class="btn btn-primary">Insertar</button>
	</form>

</body>
</html>