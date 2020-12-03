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
		public void insert(Tarifa tar) {
			
			try {
				
				tarData.insert(tar);
				
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		
		
		public void delete(int tarifa) {
			
			try {
				
				tarData.delete(tarifa);
				
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
				
			}
		}
		
		public void update(Tarifa tar) {
			
			try {
				
				tarData.update(tar);
				
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		
		
	}


