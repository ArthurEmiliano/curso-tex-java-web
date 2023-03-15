<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.motos.modelo.Moto, br.com.motos.dao.MotoDao, java.util.List" %>
<!DOCTYPE html>
<html>
<body>
	<% List<Moto> motos = (List<Moto>)request.getAttribute("motos");%>
	
	<table>
		<tr>
			<td>id</td>
			<td>Marca</td>
			<td>Modelo</td>
			<td>Ano</td>
		</tr>
		<% for(Moto moto : motos) { %>
			<tr>
				<td><%=moto.getId() %></td>
				<td><%=moto.getModelo() %></td>
				<td><%=moto.getMarca() %></td>
				<td><%=moto.getAno() %></td>
			</tr>
		<% } %>
	
	</table>
</body>
</html>