package modelo;

public class Transaccion {
	
	private Pago pago;
	private Cliente cliente;
	private Articulo articulo;
	private Compra compra;
	
	
	
	public Transaccion(Articulo articulo, Compra compra) {
		super();
		this.articulo = articulo;
		this.compra = compra;
	}
	
	public Transaccion(Pago pago, Cliente cliente) {
		super();
		this.pago = pago;
		this.cliente = cliente;
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
	
	

}
