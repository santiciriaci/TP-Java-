package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Mail;
import Entidades.Usuario;
import Logica.UsuarioLogic;

/**
 * Servlet implementation class EmailDescuentoServlet
 */
@WebServlet("/EmailDescuentoServlet")
public class EmailDescuentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailDescuentoServlet() {
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
		
		
		 int mes = (int)request.getSession().getAttribute("mes");
		 int ano = (int)request.getSession().getAttribute("ano");
		
		 UsuarioLogic usuLog= new UsuarioLogic();
		 
		 Mail mail = new Mail();
	        String de =  "tpestacionamientojava@gmail.com";
	        String clave = "estacionamiento123";
		 
		 try {
			LinkedList<Usuario> clientes = usuLog.clientesMensuales(mes,ano);
			 boolean resultado = false;
			for (Usuario us:clientes) {
				
				int band = 0;
				
				//String para = us.getMail();
				String para = "juan230897@gmail.com";
		        String asunto = "ESTACIONAMIENTO JAVA // BENEFICIO";
		        String nombre = us.getNombre();
		        String apellido = us.getApellido();
		        String dnii = us.getDniString();
		        int dni =  Integer.parseInt(dnii);
		        String mensaje = "Beneficio de un 15% de descuento para utilizar en ESTACIONAMIENTO JAVA valido para "+System.lineSeparator()+
		        		"Cliente: "+apellido+", "+nombre+System.lineSeparator()+
		        		"Dni: "+dni;
		        		
		       
				try {
					resultado = mail.enviarCorreo(de, clave, para, mensaje, asunto);
				} catch (Exception e) {
					request.setAttribute("mensaje", "Error al enviar el E-mail al usuario:" + us.getApellido() + ", " + us.getNombre());
					request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
				}
		        
				if(band>=4) {
					break;
				}
				
		        band++;
				
			}
			
			
			if(resultado){
				request.setAttribute("mensaje","E-mails enviados correctamente a todos los usuarios");
	            request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
	        }
			
			
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Error al recuperar datos de los clientes");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);		
		}
		 
				
	}

}
