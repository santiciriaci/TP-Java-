package Entidades;


public class Usuario {

	private String nombre;
	private String apellido;
	private String mail;
	private String direccion;
	private int tel,dni;
	private String usuario;
	private String contraseña;
	private Boolean tipoUs;
	private int visitasMes;
	
	
	public Usuario(String nombre, String apellido, String mail, String direccion, int tel, int dni,String usuario,String contraseña,Boolean tipoUs) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.direccion = direccion;
		this.tel = tel;
		this.dni = dni;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.tipoUs = tipoUs;
		
	}


	public Usuario() {
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}
	
	

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	@Override
	public String toString() {
		return "\nCliente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", tel=" + tel + ", mail=" + mail + ", direccion=" + direccion + ", usuario=" + usuario+ "]";
	}


	public Boolean getTipoUs() {
		return tipoUs;
	}


	public void setTipoUs(Boolean tipoUs) {
		this.tipoUs = tipoUs;
	}
	
	public String getTelString() {
		
		return "" + this.getTel() + "";
		
	}
	
public String getDniString() {
		
		return "" + this.getDni() + "";
		
	}


public int getVisitasMes() {
	return visitasMes;
}


public void setVisitasMes(int visitasMes) {
	this.visitasMes = visitasMes;
}
	

}
