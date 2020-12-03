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
 * Servlet implementation class Registro
 */
@WebServlet("/NuevoUsuario")
public class NuevoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoUsuario() {
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
		Usuario usr = new Usuario();
		String usuario = request.getParameter("usuario");
		String contra = request.getParameter("contraseña");
		String nom = request.getParameter("nombre");
		String ape = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		int dnii = Integer.parseInt(dni);
		String tel = request.getParameter("telefono");
		int tell = Integer.parseInt(tel);
		String mail = request.getParameter("mail");
		String direcc = request.getParameter("direccion");
		String esadmin = "0";
		boolean admin =Boolean.parseBoolean(esadmin); 
		usr.setUsuario(usuario);
		usr.setContraseña(contra);
		usr.setNombre(nom);
		usr.setApellido(ape);
		usr.setDni(dnii);
		usr.setTel(tell);
		usr.setMail(mail);
		usr.setDireccion(direcc);
		usr.setTipoUs(admin);
		
		
		UsuarioLogic usuLog = new UsuarioLogic();
		Boolean band = null;
		try {
			band = usuLog.validaUsr(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		
		
		
		if(band) {
			
			System.out.println("Usuario ya existente");
			request.setAttribute("datosPersona", usr);
			request.getRequestDispatcher("WEB-INF/NewUser.jsp").forward(request, response);
			
		}
		else {
			
			System.out.println("Registrado");
			usuLog.insert(usr);
			request.setAttribute("new",1);
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}
