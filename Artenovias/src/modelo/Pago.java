package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Pago {
	private int id;
	private int monto;
	private String descripcion;
	private LocalDate fecha;
	
	public Pago(int id, int monto, String descripcion) {
		super();
		this.id = id;
		this.monto = monto;
		this.descripcion = descripcion;
		fecha = LocalDate.now();
	}
	
	public Pago(int id, int monto, String descripcion, Date fecha) {
		super();
		this.id = id;
		this.monto = monto;
		this.descripcion = descripcion;
		this.fecha = fecha.toLocalDate();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
