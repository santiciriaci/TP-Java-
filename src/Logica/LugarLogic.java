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
	
	public void insert(Lugar lug) throws SQLException{
		
		
			lugData.insert(lug);
			
		
	}
	
	public void delete(int codLugar) throws SQLException{
		
		
			lugData.delete(codLugar);
			
	}
	
	public void update(Auto auto,Lugar lug) throws SQLException,Exception{
		if(lug.getEstado()=='O') {
			if(lugData.getEstado(lug.getCodLugar())=='O'){
				Exception e = new Exception("El lugar se encuentra ocupado");
				throw e;
			}else if(lugData.getOne(auto.getPatente())!=null) {
				Exception e = new Exception("El auto ya se encuentra registrado en otro lugar");
				throw e;
			}
				else {
				lugData.update(auto,lug);
				}
			}
		else {
			lugData.update(auto,lug);
			}

}
	
	public LinkedList<Lugar> getDisponibles() throws SQLException{
		
		
			return lugData.getDisponibles();
		
		
	}
}