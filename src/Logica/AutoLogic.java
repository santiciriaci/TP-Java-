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
	
	public void insert(Auto au) throws SQLException{
			
			auData.insert(au);

	}
	
	
	public void delete(String patente) throws SQLException{
					
			auData.delete(patente);
			
	
	}
	
	public void update(Auto au) throws SQLException{
		
			
			auData.update(au);
			
	
	}
	
	public LinkedList<Auto> getAutosCte(int dni) throws SQLException{
		
			return auData.getAutosCte(dni);
	
	}
	
	public boolean validaPatente(String pat) throws SQLException{
		
		
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
