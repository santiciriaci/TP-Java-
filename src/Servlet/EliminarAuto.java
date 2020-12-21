package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.AutoLogic;

/**
 * Servlet implementation class EliminarAuto
 */
@WebServlet("/EliminarAuto")
public class EliminarAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pat = request.getParameter("patente1");
		pat = pat.toUpperCase();
		AutoLogic auLog = new AutoLogic();	
		try {
			auLog.delete(pat);
			request.setAttribute("mensaje", "Vehículo eliminado correctamente");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Error al eliminar el vehículo");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		
	}

}
