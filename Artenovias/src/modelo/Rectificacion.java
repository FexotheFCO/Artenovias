package modelo;

import java.sql.Date;
import java.util.Calendar;

public class Rectificacion {

	int id;
	String texto;
	Date fecha;
	
	public Rectificacion(int id, String texto) {
		super();
		this.id = id;
		this.texto = texto;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
