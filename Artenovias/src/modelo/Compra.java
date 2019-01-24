package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Compra {
	
	private int id;
	private int monto;
	private int cantidad;
	private LocalDate fecha;
	
	public Compra(int id, int monto, int cantidad) {
		super();
		this.id = id;
		this.monto = monto;
		this.cantidad = cantidad;
		fecha = LocalDate.now();
	}
	
	public Compra(int id, int monto,Date fecha, int cantidad ) {
		super();
		this.id = id;
		this.monto = monto;
		this.cantidad = cantidad;
		this.fecha = fecha.toLocalDate();
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

}
