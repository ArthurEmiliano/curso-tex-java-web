<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.motos.modelo.Moto, br.com.motos.dao.MotoDao, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<body>
	
	<table>
		<tr>
			<td>id</td>
			<td>Marca</td>
			<td>Modelo</td>
			<td>Ano</td>
		</tr>
		<c:forEach items="${motos}" var="moto">
			<tr>
				<td>${moto.id}</td>
				<td>${moto.marca}</td>
				<td>${moto.modelo}</td>
				<td>${moto.ano}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>