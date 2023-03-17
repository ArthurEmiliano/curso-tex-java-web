package br.com.motos.servlet;

import java.io.IOException;

import br.com.motos.dao.UsuarioDao;
import br.com.motos.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.verifica(login, senha);
		
		if(usuario != null) {
			System.out.println("Usuario cadastrado");
		} else {
			System.out.println("Usuario não existe");
		}
		
	}

}
