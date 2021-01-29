package com.codingdogo.greatnumber.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowGame
 */
@WebServlet("/ShowGame")
public class ShowGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String bg, none, block;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGame() {
        super();
        none = "none;";
        block = "block;";
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("sesion") == null) {
			
			// Validar sesion
			int sesion = 0;
			sesion++;
			session.setAttribute("sesion", sesion);
			System.out.println("Sesion iniciada: "+ sesion);
			
			// Generar numero al azar
			String numero;
			Random rand = new Random();
			numero = Integer.toString(rand.nextInt(101));
			System.out.println("Numero al Azar: "+ numero);
	        
			// Se guarda variable en sesion
			session.setAttribute("rand", numero);
	        
//	       	numRand = (String) session.getAttribute("rand");
			String display = none;
			bg = "bg-danger";
			request.getSession().setAttribute("display", display);
			request.getSession().setAttribute("bg", bg);
				
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
			view.forward(request, response);
	 
	    }
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		// Toma numero ingresado por usuario
		String str = request.getParameter("num");
//		
		String numRand = (String) request.getSession().getAttribute("rand");
		System.out.println(numRand);
			
		if(str.equals(numRand)) {
			
			String display = block;
			request.getSession().setAttribute("display", display);
			bg = "bg-success";
			request.getSession().setAttribute("bg", bg);
			String res = "Adivinaste "+ numRand +" es el numero!";
			request.setAttribute("res", res);
			System.out.println("Numero correcto " + str + " = "+ numRand);
			String form = none;
			request.setAttribute("form", form);
				
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		    view.forward(request, response);
		    
		    request.getSession().invalidate();
		    
		} else if(Integer.parseInt(str) < Integer.parseInt(numRand)) {
			
			String display = block;
			request.getSession().setAttribute("display", display);
			String res = "Muy bajo!";
			request.setAttribute("res", res);
			String newGame = none;
			request.setAttribute("newGame", newGame);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		    view.forward(request, response);
		    
		} else if(Integer.parseInt(str) > Integer.parseInt(numRand)) {
			
			String display = block;
			request.getSession().setAttribute("display", display);
			String res = "Muy alto!";
			request.setAttribute("res", res);
			String newGame = none;
			request.setAttribute("newGame", newGame);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		    view.forward(request, response);
		}
			
	
	}

}
