package Datos;
/*un paso 2*/
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

import Entidades.Auto;


public class AutoData {
	
	private Connection conn;
	
	public AutoData() {
	conn = DbConnector.getInstancia().getConn();
	}

	
	public ArrayList<Auto> getAll() throws SQLException{
		
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from vehiculo");
		
		ArrayList<Auto> vehiculo = new ArrayList<Auto>();
		
		while (rs.next()) {
			
			Auto au= new Auto();
			au.setPatente(rs.getString("patente"));
			au.setModelo(rs.getString("modelo"));
	
			vehiculo.add(au);
			
		}
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		
		return vehiculo;
		
	}
	
	public Auto getOne(String patente) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("select * from vehiculo where patente=?");
		
		stmt.setString(1, patente);

		ResultSet rs = stmt.executeQuery();
		Auto au1= new Auto();
		while (rs.next()) {
			
			au1.setPatente(rs.getString("patente"));
			au1.setModelo(rs.getString("modelo"));
			
			}
		
		

		
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		

		return au1;
	
	}
	
	
	
	public void insert (Auto au) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO vehiculo set patente=?,modelo=?,dni=?");
		
		stmt.setString(1, au.getPatente());
		stmt.setString(2, au.getModelo());
		stmt.setInt(3, au.getDni());
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		
		
		
	}
	
	public void update (Auto au) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("UPDATE vehiculo SET patente=?,modelo=?  where patente=?");
		
		stmt.setString(1, au.getPatente());
		stmt.setString(2, au.getModelo());
		stmt.setString(1, au.getPatente());
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		
		
		
	}
	
		
	public void delete (String patente) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("DELETE from vehiculo where patente=?");
		
		stmt.setString(1, patente);
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}

	}
	
	public LinkedList<Auto> getAutosCte(int dni) throws SQLException{
		
		
		PreparedStatement stmt = conn.prepareStatement("select * from vehiculo where dni=?");
		
		stmt.setInt(1, dni);
		
		LinkedList<Auto> vehiculo = new LinkedList<Auto>();
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Auto au= new Auto();
			au.setPatente(rs.getString("patente"));
			au.setModelo(rs.getString("modelo"));
	
			vehiculo.add(au);
			
		}
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		
		return vehiculo;
		
	}


}