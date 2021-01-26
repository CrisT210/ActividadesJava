package com.codingdojo.mascotas.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codingdojo.mascotas.modelos.Gato;

/**
 * Servlet implementation class ShowGato
 */
@WebServlet("/ShowGato")
public class ShowGato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Gato
		String gnombre = request.getParameter("gname");
		String graza = request.getParameter("graza");
		int gpeso = Integer.parseInt(request.getParameter("gpeso"));
		
		Gato g = new Gato(gnombre, graza, gpeso);
		
		request.setAttribute("g", g);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/gato.jsp");
        view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
