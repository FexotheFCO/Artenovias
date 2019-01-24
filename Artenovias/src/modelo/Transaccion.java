package modelo;

import java.time.LocalDate;

public class Transaccion {
	
	private Pago pago;
	private Cliente cliente;
	private Articulo articulo;
	private Compra compra;
	private LocalDate fecha;
	private boolean tipo; //true pago false compra
	
	public Transaccion(Articulo articulo, Compra compra) {
		super();
		this.articulo = articulo;
		this.compra = compra;
		fecha = compra.getFecha();
		tipo = false;
	}
	
	public Transaccion(Pago pago, Cliente cliente) {
		super();
		this.pago = pago;
		this.cliente = cliente;
		fecha = pago.getFecha();
		tipo = true;
	}
	
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public Pago getVenta() {
		return pago;
	}
	public void setVenta(Pago pago) {
		this.pago = pago;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	

}
