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
	
public Lugar getLugar(int codLug) throws SQLException{
		
		Lugar lugar = lugData.getLugar(codLug);
		return lugar;
		
	}
	
	
	public void insert(Lugar lug) throws SQLException{
		
		
			lugData.insert(lug);
			
		
	}
	
	public void delete(int codLugar) throws SQLException{
		
		
			lugData.delete(codLugar);
			
	}
	
	public void update(Auto auto,Lugar lug) throws SQLException,Exception{
		if(lug.getEstado()=='O') {
				Exception e = new Exception("El lugar se encuentra ocupado");
				throw e;
			}
		if(lugData.getOne(auto.getPatente()).getEstado()=='O') {
			Exception e = new Exception("El auto ya se encuentra registrado en otro lugar");
			throw e;
			}
		else {
			if(auto.getPatente()==null){
				lug.setEstado('D');
			}
			else {
				lug.setEstado('O');
			}
			
			lugData.update(auto,lug);
			}
		}
		


	
	public LinkedList<Lugar> getDisponibles() throws SQLException{
		
		
			return lugData.getDisponibles();
		
		
	}
}