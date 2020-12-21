package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Auto;
import Entidades.Usuario;
import Logica.AutoLogic;

/**
 * Servlet implementation class AgregarAuto
 */
@WebServlet("/AgregarAuto")
public class AgregarAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarAuto() {
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
		
		Usuario usu = (Usuario) request.getAttribute("usuario");
		Auto auto = new Auto();
		AutoLogic aulog = new AutoLogic();
		String pat = request.getParameter("patente");
		pat = pat.toUpperCase();
		String mod = request.getParameter("modelo");
		mod = mod.toUpperCase();
		String dni = request.getParameter("dni");
		int dnii = Integer.parseInt(dni);
		auto.setPatente(pat);
		auto.setModelo(mod);
		auto.setDni(dnii);
		
		
		Boolean band = null;
		try {
			band = aulog.validaPatente(pat);
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Patente Invalida");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		request.setAttribute("usuario", usu);
		
		if(band) {
			
			request.setAttribute("mensaje", "La patente ingresada ya existe");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			
		}
		else {
			try {
				aulog.insert(auto);
				request.getRequestDispatcher("WEB-INF/NoUserManagement.jsp").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("mensaje", "Error al agregar Auto");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			}
			System.out.println("REGISTRADO");

		}
	}

		
	}

