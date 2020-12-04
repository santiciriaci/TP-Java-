package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import Datos.TarifaData;
import Entidades.Tarifa;

public class TarifaLogic {
	
	private TarifaData tarData;

		public TarifaLogic() {
			tarData = new TarifaData();
		}

		public ArrayList<Tarifa> getAll() throws SQLException {
			
			return tarData.getAll();
		}
		
		public Tarifa getOne(int tar) throws SQLException{
			
			Tarifa tarifa = tarData.getOne(tar);
			return tarifa;
			
		}
		
		
		public Tarifa getActual() throws SQLException{
			Tarifa tarifa = tarData.getActual();
			return tarifa;
			
		}
		public void insert(Tarifa tar) throws SQLException{
			
			
				tarData.insert(tar);
			
		}
		
		
		public void delete(int tarifa) throws SQLException{
			
				tarData.delete(tarifa);
		
		}
		
		public void update(Tarifa tar) throws SQLException{
			
			
				tarData.update(tar);
				
		}
		
		
	}


