package modelo;
import java.util.Date;

public class Compra {
	
	private int id;
	private int monto;
	private int cantidad;
	private Date fecha;
	
	public Compra(int id, int monto, int cantidad) {
		super();
		this.id = id;
		this.monto = monto;
		this.cantidad = cantidad;
	}
	
	public Compra(int id, int monto,Date fecha, int cantidad ) {
		super();
		this.id = id;
		this.monto = monto;
		this.cantidad = cantidad;
		this.fecha = fecha;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
