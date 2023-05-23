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
<a class="btn btn-primary" href="insertarProducto">Insertar</a>
	<table style="border:1px solid black">
		<tr>
			<th>Id</th>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Caducidad</th>
			<th>Seccion</th>
		</tr>
		<c:forEach items="${ productos }" var="producto">
			 <tr>
			 	<th style="border:1px solid black">${ producto.id }</th>
				<th style="border:1px solid black">${ producto.codigo }</th>
				<th style="border:1px solid black">${ producto.nombre }</th>
	 			<th style="border:1px solid black">${ producto.cantidad }</th>
	 			<th style="border:1px solid black">${ producto.precio }</th>
	 			<th style="border:1px solid black">${ producto.caducidad }</th>
	 			<th style="border:1px solid black">${ producto.seccion.id }</th>
	 			<th><a class="btn btn-primary" href="modificarProducto">Modificar</a></th>
	 		</tr>
	 	</c:forEach>
	 </table>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>