package Datos;

import java.sql.*;
import java.util.TimeZone;

public class DbConnector {

	private static DbConnector instancia;
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3307";
	private String user="root";
	private String pass="";
	private String password="VMMont27520";
	private String db="estacionamiento";
	private int conectados=0;
	private static Connection conn=null;
	
	private DbConnector() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DbConnector getInstancia() {
		if (instancia == null) {
			instancia = new DbConnector();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?serverTimezone=UTC", user, pass);
				//conn=DriverManager.getConnection("jdbc:mysql://node64490-estacionamiento.jelastic.saveincloud.net/", user, password);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void Cerrar() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conn=null;
		
	}

}