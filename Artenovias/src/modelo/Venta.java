package modelo;
import java.sql.Date;
import java.util.ArrayList;

public class Venta {
	
	private int id;
	private Cliente cliente;
	private int monto;
	private Date fecha;
	
	public Venta(int id,Cliente cliente,int monto,Date fecha) {
		this.id = id;
		this.cliente = cliente;
		this.monto = monto;
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
