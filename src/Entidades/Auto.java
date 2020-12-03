package Entidades;

public class Auto {
	
	private String patente;
	private String modelo;
	private int dni;
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	
	public Auto() {
		
	}
	
	@Override
	public String toString() {
		return "Patente= " + patente + ", Modelo= " + modelo + ", Dni= "+ dni + "";
	}
	public Auto(String patente, String modelo,int dni) {
		
		this.patente = patente;
		this.modelo = modelo;
		this.dni = dni;
	}
	
	
	
	
	
	

}
