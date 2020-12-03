package Entidades;

public class Tarifa {

	private int ID_tarifa;
	private double media_hora;
	private double hora;
	private double media_estadia;
	private double estadia_completa;
	private double semanal;
	private double mensual;
	
	
	
	
	public int getIDtarifa() {
		return ID_tarifa;
	}
	public void setIDtarifa(int iD_tarifa) {
		ID_tarifa = iD_tarifa;
	}
	public double getMediaHora() {
		return media_hora;
	}
	public void setMediaHora(double media_hora) {
		this.media_hora = media_hora;
	}
	public double getHora() {
		return hora;
	}
	public void setHora(double hora) {
		this.hora = hora;
	}
	public double getMediaEstadia() {
		return media_estadia;
	}
	public void setMediaEstadia(double media_estadia) {
		this.media_estadia = media_estadia;
	}
	public double getEstadiaCompleta() {
		return estadia_completa;
	}
	public void setEstadiaCompleta(double estadia_completa) {
		this.estadia_completa = estadia_completa;
	}
	public double getSemanal() {
		return semanal;
	}
	public void setSemanal(double semanal) {
		this.semanal = semanal;
	}
	public double getMensual() {
		return mensual;
	}
	public void setMensual(double mensual) {
		this.mensual = mensual;
	}
	
	public Tarifa(int iD_tarifa, double media_hora, double hora, double media_estadia, double estadia_completa,
			double semanal, double mensual) {
		super();
		ID_tarifa = iD_tarifa;
		this.media_hora = media_hora;
		this.hora = hora;
		this.media_estadia = media_estadia;
		this.estadia_completa = estadia_completa;
		this.semanal = semanal;
		this.mensual = mensual;
	}

	public Tarifa() {}
	

}
