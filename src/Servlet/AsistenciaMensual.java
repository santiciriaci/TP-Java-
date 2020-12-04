package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsistenciaMensual
 */
@WebServlet("/AsistenciaMensual")
public class AsistenciaMensual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsistenciaMensual() {
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
		String mesInii = request.getParameter("mesIni");
		int mesIni = 0;
		int anoIni = 0;
		try {
			mesIni = Integer.parseInt(mesInii);
			String anoInii = request.getParameter("anoIni");
			anoIni = Integer.parseInt(anoInii);
		
	} catch (Exception e) {
		request.setAttribute("mensaje", "Mes o Año ingresados incorrectos");
		request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
	}
		request.getAttribute("usuario");
		request.setAttribute("mesIni", mesIni);
		request.setAttribute("anoIni", anoIni);
		
		request.getRequestDispatcher("WEB-INF/ListaAsistenciaMensual.jsp").forward(request, response);
		
	}

}
