package Servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Usuario;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter(
		description = "Para validar acceso desde URL", 
		urlPatterns = { 
				"/Filtro", 
				"/TP-Java/UserManagement", 
				"/TP-Java/NoUserManagement", 
				"/TP-Java/ListaAsistenciaMensual", 
				"/TP-Java/ListaTicketsCliente"
		}, 
		servletNames = { 
				"ActualizarTarifa", 
				"AgregarAuto", 
				"AsistenciaMensual", 
				"ComienzoServicio", 
				"EnviarMail", 
				"FacturacionCliente", 
				"FinServicio", 
				"Redireccionamiento"
		})
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        Usuario usu = (Usuario)request.getSession().getAttribute("usuario");
        if(usu!= null){
			if (usu.getTipoUs()){	
				
				response.sendRedirect("WEB-INF/UserManagement.jsp");
				return;
			}
			else {
				
				response.sendRedirect("WEB-INF/NoUserManagement.jsp");
				
			}
		}else {
			response.sendRedirect("index.html");
			
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
