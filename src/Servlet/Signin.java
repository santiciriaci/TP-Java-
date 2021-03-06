package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import Entidades.Usuario;

import Logica.UsuarioLogic;


/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/signin", "/SIGNIN", "/Signin", "/SignIn", "/signIn" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("get at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usu = null;
		if(usu==null) {

		
		UsuarioLogic usulog = new UsuarioLogic();
		
		String usrName = request.getParameter("usrName");
		String password = request.getParameter("password");
		
		
		try {
			usu=usulog.getOne(usrName,password);
		} catch (SQLException e) {
			request.setAttribute("mensaje", "Usuario no existente o datos incorrectos");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		if(usu.getNombre() == null) {
			usu=null;
		};
		
		
		
		request.getSession().setAttribute("usuario", usu);
		
		if(usu!= null){
			if (usu.getTipoUs()){	
	
				request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
			}
			else {
				
				request.getRequestDispatcher("WEB-INF/NoUserManagement.jsp").forward(request, response);
			}
		}
	
		else{
			request.setAttribute("mensaje", "Usuario no existente o datos incorrectos");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		
	}
		}
		
	}
}
