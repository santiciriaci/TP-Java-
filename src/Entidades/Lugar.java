package Entidades;

public class Lugar {

	private int codLugar;
	private char estado; //Disponible(D)-Ocupado(O)
	private String numpat;
	private Auto auto;
	
	

	public int getCodLugar() {
		return codLugar;
	}

	public void setCodLugar(int codLugar) {
		this.codLugar = codLugar;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char c) {
		this.estado = c;
	}
	
	public Lugar() {
		
	}
	
	public Lugar(int codigo,Auto au) {
		this.codLugar = codigo;
		this.estado = 'D';
		this.auto = au;
	}

	public String toString() {
		return "Lugar= " + codLugar + ", estado= " + estado + ", auto= "+auto+"";
	}

	public  Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public String getPatente() {
		return auto.getPatente();
		
	}

	public String getNumpat() {
		return numpat;
	}

	public void setNumpat(String numpat) {
		this.numpat = numpat;
	}
	

}