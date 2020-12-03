package Servlet;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Entidades.Auto;
import Entidades.Lugar;

import Entidades.Ticket;
import Entidades.Usuario;
import Logica.AutoLogic;
import Logica.LugarLogic;
import Logica.TarifaLogic;
import Logica.TicketLogic;

/**
 * Servlet implementation class ComienzoServicio
 */
@WebServlet("/ComienzoServicio")
public class ComienzoServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComienzoServicio() {
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
		LugarLogic lugLog = new LugarLogic();
		Lugar lugar = new Lugar();
		String codLugarr = request.getParameter("lugar");
		int codLugar = Integer.parseInt(codLugarr);
		String patente = request.getParameter("patente");
		lugar.setCodLugar(codLugar);
		lugar.setEstado('O');
		AutoLogic auLog = new AutoLogic();
		Auto auto = new Auto();
		try {
			auto=auLog.getOne(patente);
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		if(auto.getModelo() == null) {
			auto.setPatente(patente);
			auto.setModelo(null);
		}
		lugLog.update(auto, lugar);
		TarifaLogic tarLog = new TarifaLogic();
		
		
		
		TicketLogic TickLog = new TicketLogic();
		Ticket ticket = new Ticket();
		Date date = new Date();
		java.sql.Timestamp dh = new java.sql.Timestamp(date.getTime());
		try {
			ticket.setTarifa(tarLog.getActual());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ticket.setFecha_horaIni(dh);
		ticket.setAuto(auto);
		TickLog.insert(ticket);
		System.out.println("REGISTRADO");
		request.setAttribute("usuario", usu);
		request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
	}

}
