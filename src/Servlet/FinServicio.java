package Servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;

import Entidades.Usuario;
import Entidades.Auto;
import Entidades.Lugar;
import Entidades.Ticket;
import Logica.LugarLogic;
import Logica.TicketLogic;


/**
 * Servlet implementation class FinServicio
 */
@WebServlet("/FinServicio")
public class FinServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinServicio() {
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
		String patente = request.getParameter("patente");
		String benUsr =request.getParameter("benefUsr");
		String benDia =request.getParameter("benefDia");
		boolean benefUsr = Boolean.parseBoolean(benUsr); 
		boolean benefDia = Boolean.parseBoolean(benDia); 
		TicketLogic tickLog = new TicketLogic();
		Ticket tic = new Ticket();
		try {
			tic = tickLog.getOne(patente);
		} catch (SQLException | ParseException e) {
			request.setAttribute("mensaje", "Error al recuperar ticket");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		
		Date date = new Date();
		java.sql.Timestamp dh = new java.sql.Timestamp(date.getTime());
		tic.setFecha_horaFin(dh);
		
		try {
			tickLog.finSer(tic);
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Error al registrar el fin de servicio");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		} catch (ParseException e) {
			request.setAttribute("mensaje", "Error al convertir las fechas del ticket");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		LugarLogic lugLogic = new LugarLogic();
		Lugar lug = new Lugar();
		Auto au = new Auto();
		Lugar actLug = new Lugar();
		try {
			 lug = lugLogic.getOne(patente);
			 
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Error al recuperar lugar");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		actLug.setEstado('D');
		au.setPatente(null);
		au.setModelo(null);
		actLug.setAuto(au);
		actLug.setCodLugar(lug.getCodLugar());
		actLug.setNumpat(null);
		try {
			lugLogic.update(au, actLug);
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Error al actualizar estado del lugar");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		} catch (Exception e) {
			
		}
		System.out.println(benefUsr);
		System.out.println(benefDia);
		System.out.println("FINALIZADO");
		ByteArrayOutputStream baos = null;
		try {
				baos = tic.Pdf(benefUsr,benefDia);
			
		} catch (SQLException | ParseException |DocumentException e) {
			request.setAttribute("mensaje", "Error al crear PDF");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		
		// setting some response headers
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control",
            "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        // setting the content type
        response.setContentType("application/pdf");
        // the contentlength
        response.setContentLength(baos.size());
        // write ByteArrayOutputStream to the ServletOutputStream
        ServletOutputStream os = response.getOutputStream();

        baos.writeTo(os);
        os.flush();
        os.close();
		request.setAttribute("usuario", usu);
		//request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
	}
}

