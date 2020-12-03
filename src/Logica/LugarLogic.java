package Logica;

import java.sql.SQLException;

import java.util.LinkedList;

import Datos.LugarData;
import Entidades.Auto;
import Entidades.Lugar;

public class LugarLogic {

private LugarData lugData;
	
	public LugarLogic() {
		
		lugData = new LugarData();
		
	}

public LinkedList<Lugar> getAll() throws SQLException {
		
		return lugData.getAll();
		
	}

	public Lugar getOne(String pat) throws SQLException{
		
		Lugar lugar = lugData.getOne(pat);
		return lugar;
		
	}
	
	public void insert(Lugar lug) {
		
		try {
			
			lugData.insert(lug);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int codLugar) {
		
		try {
			
			lugData.delete(codLugar);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
	public void update(Auto auto,Lugar lug) {
		
		try {
			
			lugData.update(auto,lug);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

}
	
	public LinkedList<Lugar> getDisponibles(){
		
		try {
			return lugData.getDisponibles();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
}