package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Mail;


/**
 * Servlet implementation class EnviarMail
 */
@WebServlet("/EnviarMail")
public class EnviarMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarMail() {
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
		Mail mail = new Mail();
        
        String de =  "tpestacionamientojava@gmail.com";
        String clave = "estacionamiento123";
       
		
		//String para = usu.getMail();
        String para = "santiagociriaci@gmail.com";
        String asunto = "ESTACIONAMIENTO JAVA // BENEFICIO";
        String nombre = request.getParameter("nom");
        String apellido = request.getParameter("ape");
        String dnii = request.getParameter("dni");
        int dni =  Integer.parseInt(dnii);
        String patente = request.getParameter("patenteBeneficio");
        String mensaje = "Beneficio de un 15% de descuento para utilizar en ESTACIONAMIENTO JAVA valido para "+System.lineSeparator()+
        		"Cliente: "+apellido+", "+nombre+System.lineSeparator()+
        		"Dni: "+dni+
        		"Patente: "+patente;
        
        
        /* 
            
            String[] direcciones = {"correo numero 1","correo numero 2","correo numero 3","correo ..."}
            boolean resultado = email.enviarCorreo(de, clave, direcciones, mensaje, asunto);
        
        */
        
        boolean resultado = mail.enviarCorreo(de, clave, para, mensaje, asunto);
        
        if(resultado){
            System.out.print("CORREO ELECTRONICO CORRECTAMENTE ENVIADO....");
            request.getRequestDispatcher("WEB-INF/NoUserManagement.jsp").forward(request, response);
        }else{
            System.out.print("CORREO ELECTRONICO NO ENVIADO..."); 
            request.getRequestDispatcher("WEB-INF/NoUserManagement.jsp").forward(request, response);
        }
	}

}
