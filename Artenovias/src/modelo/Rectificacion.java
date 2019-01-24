package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Rectificacion {

	private int id;
	private String texto;
	private LocalDate fecha;
	
	public Rectificacion(int id, String texto) {
		super();
		this.id = id;
		this.texto = texto;
		fecha = LocalDate.now();
	}

	public Rectificacion(int id, String texto, Date fecha) {
		super();
		this.id = id;
		this.texto = texto;
		this.fecha = fecha.toLocalDate();
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
