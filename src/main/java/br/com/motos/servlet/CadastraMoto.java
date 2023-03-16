package br.com.motos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.motos.dao.MotoDao;
import br.com.motos.modelo.Moto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastra")
public class CadastraMoto extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
		Moto moto = new Moto(marca, modelo, ano);
		
		MotoDao motoDao = new MotoDao();
		motoDao.cadastra(moto);
		
		/*
		 * req.setAttribute("nomeDaMoto", moto.getModelo());
		 * 
		 * RequestDispatcher rd = req.getRequestDispatcher("cadastrado.jsp");
		 * rd.forward(req, resp);
		 */
		
		resp.sendRedirect("cadastrado.jsp");
	}
}
