package modelo;
import java.util.ArrayList;

public class Cliente {

	private int id;
	private String nombre;
	private String apellido;
	private String mail;
	private int telefono;
	private int telefono2;
	private int edad;
	private Vestido vestido;
	
	public Cliente(int id, String nombre, String apellido, String mail, int telefono, int telefono2, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.telefono2 = telefono2;
		this.edad = edad;
		vestido = new Vestido();
	}

	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(int telefono2) {
		this.telefono2 = telefono2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Vestido getVestido() {
		return vestido;
	}

	public void setVestido(Vestido vestido) {
		this.vestido = vestido;
	}
	
}