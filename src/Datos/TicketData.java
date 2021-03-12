package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

import Entidades.Auto;
import Entidades.Tarifa;
import Entidades.Ticket;
import Logica.TarifaLogic;


public class TicketData {
	
	private Connection conn;
	
	public TicketData() {
		
		conn = DbConnector.getInstancia().getConn();
		
	}
			
	public ArrayList<Ticket> getAll() throws SQLException, ParseException{
				
				
		Statement stmt = conn.createStatement();
				
		ResultSet rs = stmt.executeQuery("select * from ticket");
				
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		TarifaLogic tarLog = new TarifaLogic();	
		
		while (rs.next()) {
			
		Tarifa tar = tarLog.getOne(rs.getInt("ID_tarifa"));		
		Ticket tick= new Ticket();
					
		
		tick.setId(rs.getInt("ID_ticket"));
		tick.setFecha_horaFin(rs.getTimestamp("fecha_hora_fin"));
		tick.setFecha_horaIni(rs.getTimestamp("fecha_hora_ini"));
		tick.setImporte(rs.getFloat("importe"));
		tick.setTarifa(tar);
		tick.setNumpat(rs.getString("numpat"));
		
		tickets.add(tick);
					
		}
				
		if(rs!=null) {rs.close();}
				
		if(stmt!=null) {stmt.close();}
				
		
		
				
		return tickets;
				
			}
			
	
	public LinkedList<Ticket> getTicketsPatente(String pat,int mes, int ano) throws SQLException, ParseException{
		
		
				
		PreparedStatement stmt = conn.prepareStatement("select * from ticket where (numpat LIKE ?) AND (month(`fecha_hora_inicio`)>=? and year(`fecha_hora_inicio`)>=?) ");
		
		stmt.setString(1, pat);
		stmt.setInt(2, mes);
		stmt.setInt(3, ano);
		
		
		ResultSet rs = stmt.executeQuery();
		LinkedList<Ticket> tickets = new LinkedList<Ticket>();
		TarifaLogic tarLog = new TarifaLogic();	
		
		while (rs.next()) {
			
		Tarifa tar = tarLog.getOne(rs.getInt("ID_tarifa"));		
		Ticket tick= new Ticket();
					
		
		tick.setId(rs.getInt("ID_ticket"));
		tick.setFecha_horaFin(rs.getTimestamp("fecha_hora_fin"));
		tick.setFecha_horaIni(rs.getTimestamp("fecha_hora_inicio"));
		tick.setImporte(rs.getFloat("importe"));
		tick.setTarifa(tar);
		tick.setNumpat(rs.getString("numpat"));
		System.out.println(tick);
		System.out.println("jeje");
		tickets.add(tick);
					
		}
				
		if(rs!=null) {rs.close();}
				
		if(stmt!=null) {stmt.close();}
				
		
		
				
		return tickets;
				
			}
	
	
		public Ticket getOne(String pat) throws SQLException, ParseException{
				
		PreparedStatement stmt = conn.prepareStatement("select * from ticket where (numpat LIKE ? and fecha_hora_fin IS NULL)");
				
		stmt.setString(1, pat);
		
				
		ResultSet rs = stmt.executeQuery();
		TarifaLogic tarLog = new TarifaLogic();
		Ticket tick= new Ticket();
		
		while (rs.next()) {
		tick.setId(rs.getInt("ID_ticket"));
		tick.setFecha_horaFin(rs.getTimestamp("fecha_hora_fin"));
		tick.setFecha_horaIni(rs.getTimestamp("fecha_hora_inicio"));
		tick.setImporte(rs.getFloat("importe"));
		Tarifa tar = tarLog.getOne(rs.getInt("ID_tarifa"));	
		tick.setTarifa(tar);
		tick.setNumpat(rs.getString("numpat"));
		}
				
		if(rs!=null) {rs.close();}
				
		if(stmt!=null) {stmt.close();}
				
		
		
				
		return tick;

	}
			
	public void insert (Ticket ti) throws SQLException{
				
		String npat,patcli = null;
		
		npat=ti.getPatente();
		Auto auto = ti.getAuto();

		if(auto.getModelo() != null) {
			patcli=auto.getPatente();
		}		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO ticket set ID_ticket=?,fecha_hora_fin=?,fecha_hora_inicio=?,importe=?,ID_tarifa=?,patente=?,numpat=?");
				
				
				stmt.setInt(1, ti.getId());
				stmt.setTimestamp(2,null);
				stmt.setTimestamp(3, ti.getFecha_horaIni());
				stmt.setString(4,null);
				stmt.setInt(5, ti.getID_tarifa());
				stmt.setString(6, patcli);
				stmt.setString(7, npat);
				
				stmt.executeUpdate();
				
				if(stmt!=null) {stmt.close();}
				
				
				
				
			}
	
	public Ticket finSer (Ticket ti) throws SQLException, ParseException{
		
		PreparedStatement conimp = conn.prepareStatement("SELECT fecha_hora_inicio,ID_tarifa FROM ticket WHERE ID_ticket=?");
		conimp.setInt(1, ti.getId());
		ResultSet rs = conimp.executeQuery();
		Timestamp fecini = null;
		int idtar = 0;
		while(rs.next()) {
			fecini = rs.getTimestamp("fecha_hora_inicio");
			idtar = rs.getInt("ID_tarifa");
		}
		
		
		//Timestamp fecfin = ti.getFecha_horaFin();
		
		float importe = 0;
		System.out.println(importe);
		ti.setImporte(importe);
		PreparedStatement stmt = conn.prepareStatement("UPDATE ticket SET fecha_hora_fin=?,importe=? where ID_ticket=?");
		
		stmt.setTimestamp(1, ti.getFecha_horaFin());
		stmt.setDouble(2, ti.getImporte());
		stmt.setInt(3, ti.getId());
		
		stmt.executeUpdate();
		
		if(stmt!=null) {stmt.close();}
		
		
		return ti;
		
		
	}
			
			public void update (Ticket ti) throws SQLException{
				
				PreparedStatement stmt = conn.prepareStatement("UPDATE ticket SET fecha_hora_fin=?,fecha_hora_inicio=?,importe=?,ID_tarifa=?,patente=? where ID_ticket=?");
				
				
				stmt.setTimestamp(1, ti.getFecha_horaFin());
				stmt.setTimestamp(2, ti.getFecha_horaIni());
				stmt.setDouble(3, ti.getImporte());
				stmt.setInt(4, ti.getID_tarifa());
				stmt.setString(5, ti.getPatente());
				stmt.setInt(6, ti.getId());
				
				stmt.executeUpdate();
				
				if(stmt!=null) {stmt.close();}
				
				
				
			}
			
				
			public void delete (int id) throws SQLException{
				
				PreparedStatement stmt = conn.prepareStatement("DELETE from ticket where ID_ticket=?");
				
				stmt.setInt(1, id);
				
				stmt.executeUpdate();
				
				if(stmt!=null) {stmt.close();}
				
				conn.close();
				
				

			}
		
	}


