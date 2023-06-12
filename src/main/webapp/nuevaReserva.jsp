<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="NuevaReserva" method="post">
					<table>
						<tr>
							<td>Nombre:</td>
							<td><input type="text" name="nombre" value=""/></td>
						</tr>
						<tr>
							<td>Apellido:</td>
							<td><input type="text" name="apellido" value=""/></td>
						</tr>
						<tr>
							<td>Dni:</td>
							<td><input type="text" name="dni" value=""/></td>
						</tr>
						<tr>
							<td>Numero de pesonas:</td>
							<td><input type="text" name="numero_personas" value=""/></td>
						</tr>
						<tr>
							<td>Fecha inicio:</td>
							<td><input type="text" name="fecha_inicio"
								placeholder="dd-MM-yyyy" value="" /></td>
						</tr>
						<tr>
							<td>Fecha fin:</td>
							<td><input type="text" name="fecha_fin"
								placeholder="dd-MM-yyyy" value="" /></td>
						</tr>
						<tr>
							<td>Luz</td>
							<td><input type="checkbox" name="luz" /></td>
						</tr>
						<tr>
							<td>id parcela:</td>
							<td><input type="number" name="id_parcela" value=""/></td>
						</tr>
					</table>
					<input class="btn btn-primary" type="submit" value="Reservar" name="reservar" />
				</form>
</body>
</html>