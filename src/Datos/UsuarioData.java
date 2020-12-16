package Datos;

import java.sql.*;

import java.util.LinkedList;

import Entidades.Usuario;

public class UsuarioData {

	private Connection conn;
	
public UsuarioData() {
	
		conn = DbConnector.getInstancia().getConn();
	
	}
	
	
	public LinkedList<Usuario> getAll() throws SQLException{
		
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from usuarios");
		
		LinkedList<Usuario> clientes = new LinkedList<Usuario>();
		
		while (rs.next()) {
			
			Usuario usu= new Usuario();
			usu.setNombre(rs.getString("nombre"));
			usu.setApellido(rs.getString("apellido"));
			usu.setDni(rs.getInt("dni"));
			usu.setMail(rs.getString("mail"));
			usu.setTel(rs.getInt("telefono"));
			usu.setDireccion(rs.getString("direccion"));
			usu.setContraseña(rs.getString("contraseña"));
			usu.setUsuario(rs.getString("usuario"));
			usu.setTipoUs(rs.getBoolean("es_admin"));
			
			clientes.add(usu);
			
		}
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		
		return clientes;
		
	}
	
	
	public Usuario getOne(String usu,String con) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("select * from usuarios where usuario=? and contraseña=?");
		
		stmt.setString(1, usu);
		stmt.setString(2, con);
		
		ResultSet rs = stmt.executeQuery();
		
		Usuario usu1 = new Usuario();
		while (rs.next()) {
		usu1.setNombre(rs.getString("nombre"));
		usu1.setApellido(rs.getString("apellido"));
		usu1.setDni(rs.getInt("dni"));
		usu1.setMail(rs.getString("mail"));
		usu1.setTel(rs.getInt("telefono"));
		usu1.setDireccion(rs.getString("direccion"));
		usu1.setContraseña(rs.getString("contraseña"));
		usu1.setUsuario(rs.getString("usuario"));
		usu1.setTipoUs(rs.getBoolean("es_admin"));
		}
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		//conn.close();
		
		
		return usu1;

	}
	

	public LinkedList<Usuario> clientesMensuales(int mes, int ano) throws SQLException{
		
		
		
		
		PreparedStatement stmt  = conn.prepareStatement("select us.nombre,us.apellido,us.mail,telefono ,COUNT(ti.ID_ticket) as cantidad from usuarios us inner join vehiculo ve on us.dni = ve.dni inner join  ticket ti on ve.patente = ti.patente WHERE (month(`fecha_hora_inicio`)=? and year(`fecha_hora_inicio`)=?) GROUP By us.dni order by cantidad desc");
		
		stmt.setInt(1,mes);
		stmt.setInt(2, ano);
		
		ResultSet rs = stmt.executeQuery();
		LinkedList<Usuario> clientes = new LinkedList<Usuario>();
		
		while (rs.next()) {
			
			Usuario usu= new Usuario();
			usu.setNombre(rs.getString("nombre"));
			usu.setApellido(rs.getString("apellido"));
			usu.setMail(rs.getString("mail"));
			usu.setTel(rs.getInt("telefono"));
			usu.setVisitasMes(rs.getInt("cantidad"));
			
			clientes.add(usu);
			
		}
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		
		return clientes;
		
	}
	
	public void insert (Usuario usu) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios set usuario=?,contraseña=?,dni=?,nombre=?,apellido=?,telefono=?,mail=?,direccion=?,es_admin=?");
		
		stmt.setString(1, usu.getUsuario());
		stmt.setString(2, usu.getContraseña());
		stmt.setInt(3, usu.getDni());
		stmt.setString(4, usu.getNombre());
		stmt.setString(5, usu.getApellido());
		stmt.setInt(6, usu.getTel());
		stmt.setString(7, usu.getMail());
		stmt.setString(8, usu.getDireccion());
		stmt.setBoolean(9, usu.getTipoUs());
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		
		
		
	}
	
	public void update (Usuario usu) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("UPDATE usuarios SET contraseña=?,dni=?,nombre=?,apellido=?,telefono=?,mail=?,direccion=?,es_admin=? where dni=?");
		
		stmt.setString(1, usu.getContraseña());
		stmt.setInt(2, usu.getDni());
		stmt.setString(3, usu.getNombre());
		stmt.setString(4, usu.getApellido());
		stmt.setInt(5, usu.getTel());
		stmt.setString(6, usu.getMail());
		stmt.setString(7, usu.getDireccion());
		stmt.setBoolean(8, usu.getTipoUs());
		stmt.setInt(9, usu.getDni());
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		conn.close();
		
		
	}
	
		
	public void delete (int dni) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("DELETE * from usuarios where dni=?");
		
		stmt.setInt(1, dni);
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		conn.close();
		
		

	}
	

	

}
