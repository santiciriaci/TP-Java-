package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import Datos.AutoData;
import Entidades.Auto;


public class AutoLogic {

private AutoData auData;
	
	public AutoLogic() {
		auData = new AutoData();
	}
	
	public ArrayList<Auto> getAll() throws SQLException {
		
		return auData.getAll();
		
	}
	
	public Auto getOne(String patente) throws SQLException{
		
		Auto auto = auData.getOne(patente);
		return auto;
		
	}
	
	public void insert(Auto au) {
		
		try {
			
			auData.insert(au);
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
	
	public void delete(String patente) {
		
		try {
			
			auData.delete(patente);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
	public void update(Auto au) {
		
		try {
			
			auData.update(au);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public LinkedList<Auto> getAutosCte(int dni){
		
		try {
			return auData.getAutosCte(dni);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public boolean validaPatente(String pat)throws SQLException{
		
		
		ArrayList<Auto> autos = auData.getAll(); 
		
		
		for (Auto a : autos) {
			String patente = a.getPatente();
			
			if(pat.equals(patente)) {
				
				return (true);
			}
		}
		return false;
		
	}

	

	


}
