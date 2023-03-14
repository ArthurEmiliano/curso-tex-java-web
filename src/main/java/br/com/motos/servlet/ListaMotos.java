package br.com.motos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
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
		
		PrintWriter saida = resp.getWriter();
		saida.println("<html><body>");
		
		saida.println("<table>");
		
		saida.println("<tr>");
		saida.println("<td>id</td>");
		saida.println("<td>marca</td>");
		saida.println("<td>modelo</td>");
		saida.println("<td>ano</td>");
		saida.println("<td></td>");
		saida.println("<td></td>");
		saida.println("</tr>");
		
		for(Moto moto : motos) {
			saida.println("<tr>");
			saida.println("<td><a href='/motos/busca?id=" + moto.getId() + "'>" + moto.getId() + "</a></td>");
			saida.println("<td>" + moto.getMarca() + "</td>");
			saida.println("<td>" + moto.getModelo() + "</td>");
			saida.println("<td>" + moto.getAno() + "</td>");
			saida.println("<td><a href='/motos/deleta?id=" + moto.getId() + "'> X </a></td>");
			saida.println("<td><a href='/motos/preparaAtualiza?id=" + moto.getId() + "'> altera </a></td>");
			saida.println("</tr>");
		}
		
		saida.println("</table>");
		
		saida.println("</body></html>");
	}
	
}
