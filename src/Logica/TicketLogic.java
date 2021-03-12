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

public ArrayList<Ticket> getAll() throws SQLException, ParseException {
		
		return tickData.getAll();
		
	}

public LinkedList<Ticket> getTicketsPatente(String pat, int mes, int ano) throws SQLException, ParseException {
	
	return tickData.getTicketsPatente(pat, mes, ano);
	
}

	public Ticket getOne(String pat) throws SQLException, ParseException{
		
		Ticket ticket = tickData.getOne(pat);
		return ticket;
		
	}
	
	public  Ticket finSer (Ticket ti) throws SQLException, ParseException,Exception{
		if (ti == null) {
			Exception e = new Exception();
			throw e;
		}
		
		Ticket ticket = tickData.finSer(ti);
		return ticket;
	}
	
	
	public void insert(Ticket tick) throws SQLException{
		
			tickData.insert(tick);

	}
	
	public void delete(int id) throws SQLException{
		
		
			tickData.delete(id);
			
	}
	
	public void update(Ticket tick) throws SQLException{
		
			tickData.update(tick);
			
	}
	
	

}
