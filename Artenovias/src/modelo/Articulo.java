package modelo;

import java.util.ArrayList;

public class Articulo {
	
	private int id;
	private int cantidad;
	private String descripcion;
	private String lugar;
	private ArrayList<Compra>compras;
	
	public Articulo(int id, int cantidad, String descripcion, String lugar) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.lugar = lugar;
	}
	
	
	public Articulo(int id, int cantidad, String descripcion, String lugar, ArrayList<Compra> compras) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.compras = compras;
	}
	
	public void agregarCompra(Compra compra) {
		compras.add(compra);
	}

	public void borrarCompra(int compra) {
		Compra solucion = null;
		for(Compra c : compras) {
			if(c.getId() == compra) {
				solucion = c;
			}
		}
		compras.remove(solucion);
	}
    
	//Getters and Setters
	public ArrayList<Compra> getCompras() {
		return compras;
	}
	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
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
