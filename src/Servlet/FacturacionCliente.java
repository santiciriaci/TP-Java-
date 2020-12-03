package Servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entidades.Usuario;

import Logica.UsuarioLogic;

/**
 * Servlet implementation class FacturacionCliente
 */
@WebServlet("/FacturacionCliente")
public class FacturacionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturacionCliente() {
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
		//if (!(usu.getTipoUs()) ){
			//request.getRequestDispatcher("index.html").forward(request, response);
		//}
		UsuarioLogic usuLog = new UsuarioLogic();
		String dnii = request.getParameter("dni");
		int dni = Integer.parseInt(dnii);
		boolean existe = false;
		try {
			existe =  usuLog.validaUsrDni(dni);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("usuario", usu);
		if (existe) {
		
		String mesInii = request.getParameter("mesIni");
		int mesIni = Integer.parseInt(mesInii);
		String anoInii = request.getParameter("anoIni");
		int anoIni = Integer.parseInt(anoInii);
		
		request.setAttribute("dni",dni);
		request.setAttribute("mesIni", mesIni);
		request.setAttribute("anoIni", anoIni);
		
		request.getRequestDispatcher("WEB-INF/ListaTicketsCliente.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);}
	}

}
