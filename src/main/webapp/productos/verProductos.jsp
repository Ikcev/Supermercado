<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Ver Productos</title>
</head>
<body class="container" style="text-align:center">
<div class="botonInsert">
<a class="btn btn-primary" href="insertarProducto">Insertar</a>
</div>
<br>
<form method="GET" action="mostrarProductos">
<div class="input-group rounded">
  <input type="search" name="buscador" class="form-control rounded" placeholder="Introduce cadena a buscar" aria-label="Search" aria-describedby="search-addon">
  <span class="input-group-text border-0" id="search-addon">
    <i class="fas fa-search"></i>
  </span>
</div>
</form>
<br>
<form class="row">
<div class="input-group col">
  <span class="input-group-text">&euro;</span>
  <span class="input-group-text">0.00</span>
  <input type="number" min="0" class="form-control" placeholder="Precio Mínimo" aria-label="Dollar amount (with dot and two decimal places)">
</div>

<div class="input-group col">
  <input type="number" min="0" class="form-control" placeholder="Precio Máximo" aria-label="Dollar amount (with dot and two decimal places)">
  <span class="input-group-text">&euro;</span>
  <span class="input-group-text">0.00</span>
</div>
</form>
<br>
	<table class="table table-dark table-striped table-hover" style="border:1px solid whitesmoke">
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Codigo</th>
			<th scope="col">Nombre</th>
			<th scope="col">Cantidad</th>
			<th scope="col">Precio</th>
			<th scope="col">Caducidad</th>
			<th scope="col">Seccion</th>
			<th></th>
		</tr>
		<c:forEach items="${ productos }" var="producto">
			 <tr>
			 	<th style="border:1px solid whitesmoke" scope="row">${ producto.id }</th>
				<th style="border:1px solid whitesmoke">${ producto.codigo }</th>
				<th style="border:1px solid whitesmoke">${ producto.nombre }</th>
	 			<th style="border:1px solid whitesmoke">${ producto.cantidad }</th>
	 			<th style="border:1px solid whitesmoke">${ producto.precio }</th>
	 			<th style="border:1px solid whitesmoke">${ producto.caducidad }</th>
	 			<th style="border:1px solid whitesmoke">${ producto.seccion.id }</th>
	 			<th><a class="btn btn-light" href="modificarProducto?id=${producto.id}">Modificar</a></th>
	 		</tr>
	 	</c:forEach>
	 </table>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>