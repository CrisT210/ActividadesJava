
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String leng = request.getParameter("leng");
		String ciudad = request.getParameter("ciudad");
		
		PrintWriter out = response.getWriter();
		
		if(nombre == null) {
			nombre = "Unkown";
		} 
		if(apellido == null) {
			apellido = "Unkown";
		} 
		if(ciudad == null) {
			ciudad = "Unkown";
		}
		if(leng == null){
			leng = "Unkown";
		}
		
		out.write("<h1>Bienvenido, "+ nombre +" "+ apellido +"</h1>");
		out.write("<br>");
		out.write("<h3>Tu lenguaje favorito es: "+ leng +"<h3>");
		out.write("<h3>Tu ciudad natal es: "+ ciudad +"</h3>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
