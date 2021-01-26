package com.codingdojo.mascotas.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.mascotas.modelos.Perro;

/**
 * Servlet implementation class ShowPerro
 */
@WebServlet("/ShowPerro")
public class ShowPerro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPerro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Perro
		String pnombre = request.getParameter("pname");
		String praza = request.getParameter("praza");
        int ppeso = Integer.parseInt(request.getParameter("ppeso"));
        
        Perro p = new Perro(pnombre, praza, ppeso);
        
        request.setAttribute("p", p);
        
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/perro.jsp");
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
