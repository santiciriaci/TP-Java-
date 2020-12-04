package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entidades.Tarifa;
import Entidades.Usuario;
import Logica.TarifaLogic;

/**
 * Servlet implementation class ActualizarTarifa
 */
@WebServlet("/ActualizarTarifa")
public class ActualizarTarifa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTarifa() {
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
		Tarifa tar = new Tarifa();
		TarifaLogic tarLog = new TarifaLogic();
		String mediahoraa = request.getParameter("mediahora");
		String horaa = request.getParameter("hora");
		String mediaestt = request.getParameter("mediaest");
		String estadiaa = request.getParameter("estadia");
		String semanall = request.getParameter("semanal");
		String mensuall = request.getParameter("mensual");
		double mediahora = Double.parseDouble(mediahoraa);
		double hora = Double.parseDouble(horaa);
		double mediaest = Double.parseDouble(mediaestt);
		double estadia = Double.parseDouble(estadiaa);
		double semanal = Double.parseDouble(semanall);
		double mensual = Double.parseDouble(mensuall);
		
		tar.setMediaHora(mediahora);
		tar.setHora(hora);
		tar.setMediaEstadia(mediaest);
		tar.setEstadiaCompleta(estadia);
		tar.setSemanal(semanal);
		tar.setMensual(mensual);
		
		try {
			tarLog.insert(tar);
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Error al actualizar tarifa");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		request.setAttribute("usuario", usu);
		System.out.println("REGISTRADO");
		
		request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);

}
}
