package Datos;
import java.sql.*;

import java.util.LinkedList;

import Entidades.Auto;
import Entidades.Lugar;
import Logica.AutoLogic;

public class LugarData {
	
	private Connection conn;
	
	public LugarData() {
		conn = DbConnector.getInstancia().getConn();
	}

	public LinkedList<Lugar> getAll() throws SQLException{
		
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from lugar");
		
		LinkedList<Lugar> lugares = new LinkedList<Lugar>();
		
		while (rs.next()) {
			
			Lugar lug= new Lugar();
			lug.setCodLugar(rs.getInt("ID_lugar"));
			lug.setEstado(rs.getString("estado_lugar").charAt(0));
			lug.setNumpat(rs.getString("numpat"));
			AutoLogic auLog = new AutoLogic();
			Auto auto = auLog.getOne(rs.getString("patente"));
			
			if (auto!=null) {
				lug.setAuto(auto);}
			lugares.add(lug);
			
		}
		
		
		
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		return lugares;
		
	}
	
	public LinkedList<Lugar> getDisponibles() throws SQLException{
		
		
		PreparedStatement stmt = conn.prepareStatement("select * from lugar where estado_lugar=?");
	
		String estado = "D" ;
		((PreparedStatement) stmt).setString(1, estado);
		
		LinkedList<Lugar> lugares = new LinkedList<Lugar>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			
			Lugar lug= new Lugar();
			lug.setCodLugar(rs.getInt("ID_lugar"));
			lug.setEstado(rs.getString("estado_lugar").charAt(0));
			AutoLogic auLog = new AutoLogic();
			Auto auto = auLog.getOne(rs.getString("patente"));
			if (auto!=null) {
				lug.setAuto(auto);}
		    lugares.add(lug);
			
		}
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		return lugares;
		
	}
		
	public Lugar getOne(String pat) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("select * from lugar where numpat=?");
		
		stmt.setString(1, pat);
		
		
		ResultSet rs = stmt.executeQuery();
		AutoLogic auLog = new AutoLogic();
		Auto au = auLog.getOne(pat);
		Lugar lug = new Lugar();
		
		if(rs.next()) {
		
		
		lug.setCodLugar(rs.getInt("ID_lugar"));
		lug.setEstado(rs.getString("estado_lugar").charAt(0));
		lug.setAuto(au);
		lug.setNumpat(rs.getString("numpat"));
		
		}
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		return lug;

	}
	
	public void insert (Lugar lug) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO lugar set ID_lugar=?,estado_lugar=?");
		
		stmt.setInt(1, lug.getCodLugar());
		stmt.setString(2, String.valueOf(lug.getEstado()));
		
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		conn.close();
		
		
	}
	
	public void update (Auto auto,Lugar lug) throws SQLException{
		
		String npat = null,patcli = null;
		if(auto.getPatente()!=null) {
			npat=auto.getPatente();}
		
		if(auto.getModelo() != null) {
			patcli=auto.getPatente();
		}
		
		PreparedStatement stmt = conn.prepareStatement("UPDATE lugar SET estado_lugar=?,patente=?,numpat=? WHERE ID_lugar=?");
		
		stmt.setString(1, String.valueOf(lug.getEstado()));
		stmt.setString(2, patcli);
		stmt.setString(3, npat);
		stmt.setInt(4, lug.getCodLugar());
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		

		
	}
	
		
	public void delete (int codLugar) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("DELETE from lugar where ID_lugar=?");
		
		stmt.setInt(1, codLugar);
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		conn.close();
		
		

	}
	
		public char getEstado(int cod) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("select * from lugar where ID_lugar=? limit 1");
		
		stmt.setInt(1, cod);
		
		
		ResultSet rs = stmt.executeQuery();
		
		char estado = 'D';
		
		if(rs.next()) {
		
		estado = rs.getString("estado_lugar").charAt(0);
		
		}
		if(rs!=null) {rs.close();}
		
		if(stmt!=null) {stmt.close();}
		
		
		
		return estado;

	}
	
	
	
	
}

