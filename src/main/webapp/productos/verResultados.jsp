<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ModeloDTO.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Ver Resultados</title>
</head>
<body class="container" style="text-align:center">
    <h1>Resultados de búsqueda</h1>
    
    <table  class="table table-dark table-striped table-hover" style="border:1px solid whitesmoke">
        <tr>
			<th>Id</th>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Cantidad</th>
			<th>Precio</th>
			<th>Caducidad</th>
			<th>Seccion</th>
			<th></th>
		</tr>
		<c:forEach items="${ resultados }" var="producto">
			 <tr>
			 	<th style="border:1px solid whitesmoke">${ producto.id }</th>
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
    
    <a class="btn btn-success" href="mostrarProductos">Volver a Inicio</a>
</body>
</html>