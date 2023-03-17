<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	
	<br />
	${mensagem}
	<br />

	<form action="/motos/login" method="post">
		<b>Login:</b><input type ="text" name="login"><br />
		<b>Senha:</b><input type ="text" name="senha"><br />
		<input type="submit" value="entrar" />
	</form>
</body>
</html>