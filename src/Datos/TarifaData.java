package Datos;

import java.sql.*;
import java.util.ArrayList;

import Entidades.Tarifa;

public class TarifaData {
	
	private Connection conn;
		
	public TarifaData() {
			
	conn = DbConnector.getInstancia().getConn();
			
	}
			
			
	public ArrayList<Tarifa> getAll() throws SQLException{
				
				
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from tarifa");
				
				ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();
				
				while (rs.next()) {
					
					Tarifa tar= new Tarifa();
					tar.setIDtarifa(rs.getInt("ID_tarifa"));
					tar.setMediaHora(rs.getFloat("media_hora"));
					tar.setHora(rs.getFloat("hora"));
					tar.setMediaEstadia(rs.getFloat("media_estadia"));
					tar.setEstadiaCompleta(rs.getFloat("estadia_completa"));
					tar.setSemanal(rs.getFloat("semanal"));
					tar.setMensual(rs.getFloat("mensual"));
					
					tarifas.add(tar);
					
				}
				
				if(rs!=null) {rs.close();}
				
				if(stmt!=null) {stmt.close();}
				
				conn.close();
				
				
				return tarifas;
				
			}
			
	public Tarifa getOne(int tar) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("select * from tarifa where ID_tarifa=?");
		
		stmt.setInt(1, tar);
		
		ResultSet rs = stmt.executeQuery();
		
		Tarifa tar1 = new Tarifa();
		while (rs.next()) {
			
		tar1.setIDtarifa(rs.getInt("ID_tarifa"));
		tar1.setMediaHora(rs.getFloat("media_hora"));
		tar1.setHora(rs.getFloat("hora"));
		tar1.setMediaEstadia(rs.getFloat("media_estadia"));
		tar1.setEstadiaCompleta(rs.getFloat("estadia_completa"));
		tar1.setSemanal(rs.getFloat("semanal"));
		tar1.setMensual(rs.getFloat("mensual"));
		}
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		
		return tar1;

	}
	
	
	public Tarifa getActual() throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("select * from tarifa where ID_tarifa=(SELECT MAX(ID_tarifa) FROM tarifa)");
		
		ResultSet rs = stmt.executeQuery();
		
		Tarifa tar1 = new Tarifa();
		while (rs.next()) {
		tar1.setIDtarifa(rs.getInt("ID_tarifa"));
		tar1.setMediaHora(rs.getFloat("media_hora"));
		tar1.setHora(rs.getFloat("hora"));
		tar1.setMediaEstadia(rs.getFloat("media_estadia"));
		tar1.setEstadiaCompleta(rs.getFloat("estadia_completa"));
		tar1.setSemanal(rs.getFloat("semanal"));
		tar1.setMensual(rs.getFloat("mensual"));}
		
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
	
		
		
		return tar1;
		
		}
	
	public void insert (Tarifa tar) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO tarifa set media_hora=?,hora=?,media_estadia=?,estadia_completa=?,semanal=?,mensual=?");
		
		
		stmt.setDouble(1, tar.getMediaHora());
		stmt.setDouble(2, tar.getHora());
		stmt.setDouble(3, tar.getMediaEstadia());
		stmt.setDouble(4, tar.getEstadiaCompleta());
		stmt.setDouble(5, tar.getSemanal());
		stmt.setDouble(6, tar.getMensual());
	
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		conn.close();
		
		
	}
	
	public void update (Tarifa tar) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("UPDATE tarifa SET media_hora=?,hora=?,media_estadia=?,estadia_completa=?,semanal=?,mensual=? where ID_tarifa=?");
		
		stmt.setDouble(1, tar.getMediaHora());
		stmt.setDouble(2, tar.getHora());
		stmt.setDouble(3, tar.getMediaEstadia());
		stmt.setDouble(4, tar.getEstadiaCompleta());
		stmt.setDouble(5, tar.getSemanal());
		stmt.setDouble(6, tar.getMensual());
		stmt.setInt(7, tar.getIDtarifa());
	
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		conn.close();
		
		
	}
	
		
	public void delete (int ID_tarifa) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("DELETE * from tarifa where ID_tarifa=?");
		
		stmt.setInt(1, ID_tarifa);
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		conn.close();
		
		

	}
}