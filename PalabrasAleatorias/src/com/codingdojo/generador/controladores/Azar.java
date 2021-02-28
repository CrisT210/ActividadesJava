package com.codingdojo.generador.controladores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Azar
 */
@WebServlet("/Azar")
public class Azar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Azar() {
        super();
        count = 0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession(); 
        
        String serie = "";
        Random rand = new Random();
        	
        for(int i = 0; i < 10; i++) {
        	int op = (int) Math.floor(Math.random()* 2);
        	System.out.println(op);
        	// 0 es Letra y 1 Numero
        	switch(op) {
        		case 0:
        			serie += (char) (rand.nextInt(91 - 65) + 65);
        			break;
        		case 1:
        			serie += (char) (rand.nextInt(58 - 48) + 48);
        			break;
        	}
        	
        }
        System.out.println(serie);
            
        session.setAttribute("str", serie);
        String str = (String) session.getAttribute("str");
        
        
        String txt = request.getParameter("count") != null ? request.getParameter("count") : "0";
        int click = Integer.parseInt(txt);
        count += click;
        
        if(txt != null && click != 0) {
        	
        	Date fecha = new Date();
        	System.out.println(fecha.toString());
        	SimpleDateFormat objDate = new SimpleDateFormat("MMMM dd, y - hh:mm:ss a");
        	String dato = objDate.format(fecha);
        	System.out.println(dato);
        	
        	session.setAttribute("date", dato);
            String fechaActual = (String) session.getAttribute("date");
            
        }
        
        session.setAttribute("conteo", count); 
	    int conteo = (int) session.getAttribute("conteo");
        
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
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
