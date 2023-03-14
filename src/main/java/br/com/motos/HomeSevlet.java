package br.com.motos;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeSevlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override //service - doGet - doPost
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CHEGUEI");
		
		// http://localhost:8080/motos/home?nome=AAAAA&idade=3726173
		
		String nome = request.getParameter("nome");
		int idade = Integer.valueOf(request.getParameter("idade"));
		
		PrintWriter saida = response.getWriter();
		saida.println("<html>");
		saida.println("<body>");
		saida.println("nome: " + nome);
		saida.println("idade: " + idade);
		saida.println("Hora de agora: " + LocalTime.now());
		saida.println("</body>");
		saida.println("</html>");
	}

}
