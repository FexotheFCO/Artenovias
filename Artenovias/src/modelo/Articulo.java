package modelo;

public class Articulo {
	
	private int id;
	private int cantidad;
	private String descripcion;
	private String lugar;
	
	public Articulo(int id, int cantidad, String descripcion, String lugar) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.lugar = lugar;
	}
	
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
