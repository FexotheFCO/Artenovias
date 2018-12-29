package modelo;

import java.util.Date;

public class Pago {
	private int id;
	private int monto;
	private String descripcion;
	private Date fecha;
	
	public Pago(int id, int monto, String descripcion) {
		super();
		this.id = id;
		this.monto = monto;
		this.descripcion = descripcion;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
