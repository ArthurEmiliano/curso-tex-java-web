package br.com.motos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.protocol.ValueDecoder;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/preparaAtualiza")
public class PreparaAtualiza extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(req.getParameter("id"));
		
		MotoDao dao = new MotoDao();
		Moto moto = dao.buscaPor(id);
		
		PrintWriter saida = resp.getWriter();
		
		saida.println("<html><body>");
		saida.println("<form action='/motos/altera' method='POST'>");
		
		saida.println("<input type='hidden' name='id' value='" + moto.getId() + "'/>");
		
		saida.println("Marca: <input type='text' name='marca' value ='" + moto.getMarca() + "' /><br />");
		saida.println("Modelo: <input type='text' name='modelo' value ='" + moto.getModelo() + "' /><br />");
		saida.println("Ano: <input type='text' name='ano' value ='" + moto.getAno() + "' /><br />");
		saida.println("<input type='submit' value='alterar' />");
		
		saida.println("</form>");
		saida.println("<a href='/motos/lista'>voltar</a>");
		saida.println("</body></html>");
		
		
	}

}
