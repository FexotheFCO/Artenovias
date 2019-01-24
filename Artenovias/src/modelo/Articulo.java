package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.DaoTransacciones;

public class Articulo {
	
	private int id;
	private int cantidad;
	private String descripcion;
	private String lugar;
	private ArrayList<Compra>compras;
	
	DaoTransacciones daoTrans = new DaoTransacciones();
	
	public Articulo(int id, int cantidad, String descripcion, String lugar) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.lugar = lugar;
		compras = new ArrayList<Compra>();
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
		compra.setId(daoTrans.agregarCompra(compra, id));
		compras.add(compra);
		JOptionPane.showMessageDialog(null, "La compra se agrego correctamente al sistema", "Compra Agregada", 1);
	}

	public void borrarCompra(int compra) {
		int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere eliminar este pago", "Eliminar Pago", 2, 2);
		if (pregunta == JOptionPane.YES_OPTION) {
			Compra solucion = null;
			for(Compra c : compras) {
				if(c.getId() == compra) {
					solucion = c;
				}
			}
			compras.remove(solucion);
			daoTrans.borrarCompra(compra);
			JOptionPane.showMessageDialog(null, "La compra se elimino correctamente del sistema", "Compra Eliminada", 1);
		}else {
			JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion del pago", "Eliminacion Cancelada", 1);
		}
	}
    
	public int devolverValorCompras(){
		int montoTotal = 0;
		for(Compra c : compras) {
			montoTotal = montoTotal + c.getMonto();
		}
		return montoTotal;
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
