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

@WebServlet("/altera")
public class AlteraMoto extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
		Moto moto = new Moto(id, marca, modelo, ano);
		MotoDao dao = new MotoDao();
		dao.atualiza(moto);
		
		PrintWriter saida = resp.getWriter();
		saida.println("<html><body>");
		saida.println("Moto alterada com sucesso!");
		saida.println("<br /><br />");
		saida.println("<a href='/motos/lista'> voltar </a>");
		saida.println("</body></html>");
	}
	
}
