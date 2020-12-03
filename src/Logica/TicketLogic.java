package Logica;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

import Datos.TicketData;
import Entidades.Ticket;

public class TicketLogic {

private TicketData tickData;
	
	public TicketLogic() {
		
		tickData = new TicketData();
		
	}

public ArrayList<Ticket> getAll() throws SQLException {
		
		return tickData.getAll();
		
	}

public LinkedList<Ticket> getTicketsPatente(String pat, int mes, int ano) throws SQLException {
	
	return tickData.getTicketsPatente(pat, mes, ano);
	
}

	public Ticket getOne(String pat) throws SQLException{
		
		Ticket ticket = tickData.getOne(pat);
		return ticket;
		
	}
	
	public  Ticket finSer (Ticket ti) throws SQLException, ParseException{
		Ticket ticket = tickData.finSer(ti);
		return ticket;
	}
	public void insert(Ticket tick) {
		
		try {
			
			tickData.insert(tick);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int id) {
		
		try {
			
			tickData.delete(id);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
	public void update(Ticket tick) {
		
		try {
			
			tickData.update(tick);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	

}
