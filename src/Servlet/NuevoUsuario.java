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
			request.setAttribute("mensaje", "Usuario ya existente, DNI ya registrado");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		
		
		
		if(band) {
			
			System.out.println("Usuario ya existente");
			request.setAttribute("datosPersona", usr);
			request.getRequestDispatcher("WEB-INF/NewUser.jsp").forward(request, response);
			
		}
		else {
			
			System.out.println("Registrado");
			try {
				usuLog.insert(usr);
			} catch (SQLException e) {
				request.setAttribute("mensaje", "Error al registrar nuevo usuario");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			}
			request.setAttribute("new",1);
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}
