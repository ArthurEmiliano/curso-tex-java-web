<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.motos.modelo.Moto" %>
<%@ page import="br.com.motos.dao.MotoDao" %>
<!DOCTYPE html>
<html>
<body>

	<%
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		Integer ano = Integer.valueOf(request.getParameter("ano"));
		
		Moto moto = new Moto(marca,modelo,ano);
		MotoDao dao = new MotoDao();
		dao.cadastra(moto);
	%>
	<b>Moto <%=modelo %> cadastrada com sucesso!</b>
	<br>
	<br>
	<a href="/motos/lista">voltar</a>


</body>
</html>