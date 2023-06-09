package br.com.motos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import br.com.motos.modelo.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lista")
public class ListaMotos extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MotoDao dao = new MotoDao();
		List<Moto> motos = dao.lista();
		
		Moto moto = dao.buscaPor(11);
		
		req.setAttribute("moto", moto);
		req.setAttribute("motos", motos);
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		System.out.println("Nome do usuário logado: " + usuario.getNome());
		
		req.getRequestDispatcher("listagem.jsp").forward(req, resp);
		
	}
	
}
