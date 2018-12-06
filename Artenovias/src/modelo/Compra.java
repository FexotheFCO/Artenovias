package modelo;
import java.util.Date;

public class Compra {
	
	private int id;
	private Articulo articulo;
	private int monto;
	private Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Articulo getIdArticulo() {
		return articulo;
	}
	public void setIdArticulo(Articulo articulo) {
		this.articulo = articulo;
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
