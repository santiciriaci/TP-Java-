package Logica;

import java.sql.SQLException;

import java.util.LinkedList;

import Datos.UsuarioData;
import Entidades.Usuario;


public class UsuarioLogic {

	private UsuarioData usData;
	
	public UsuarioLogic() {
		
		usData = new UsuarioData();
		
	}
	
	public LinkedList<Usuario> getAll() throws SQLException {
		
		return usData.getAll();
		
	}

	public Usuario getOne(String usu,String con) throws SQLException{
		
		Usuario usuario = usData.getOne(usu, con);
		return usuario;
		
	}
	
	public  LinkedList<Usuario> clientesMensuales(int mes, int ano) throws SQLException{
		
		LinkedList<Usuario> usuario = usData.clientesMensuales(mes,ano);
		return usuario;
		
	}
	public boolean validaUsr(String usr)throws SQLException{
		
		
		LinkedList<Usuario> usrs = usData.getAll(); 
		
		
		for (Usuario u : usrs) {
			String usu = u.getUsuario();
			
			if(usu.equals(usr)) {
				
				return (true);
			}
		}
		return false;
		
	}
	
	
	public boolean validaUsrDni(int dni)throws SQLException{
		
		
		LinkedList<Usuario> usrs = usData.getAll(); 
		
		
		for (Usuario u : usrs) {
			int dnii = u.getDni();
			
			if(dni == dnii) {
				
				return (true);
			}
		}
		return false;
		
	}
	
	public void insert(Usuario usu) {
		
		try {
			
			usData.insert(usu);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int dni) {
		
		try {
			
			usData.delete(dni);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
	public void update(Usuario usu) {
		
		try {
			
			usData.update(usu);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
