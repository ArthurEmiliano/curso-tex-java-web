package br.com.motos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/busca")
public class BuscaPorId extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		MotoDao dao = new MotoDao();
		Moto moto = dao.buscaPor(id);
		
		PrintWriter saida = resp.getWriter();
		saida.println("<html><body>");
		
		saida.println("<b>Marca:</b> " + moto.getMarca() + "<br />");
		saida.println("<b>Modelo:</b> " + moto.getModelo() + "<br />");
		saida.println("<b>Ano:</b> " + moto.getAno() + "<br />");
		
		saida.println("<a href='/motos/lista'>voltar</a>");
		
		saida.println("</body></html>");
	}
}
