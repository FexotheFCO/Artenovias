package modelo;
import java.util.ArrayList;

public class Empresa {
	
	private	int id;
	private String nombre;
	
	private ArrayList<Cliente>clientes;
	private ArrayList<Venta>ventas;
	private ArrayList<Articulo>articulos;
	private ArrayList<Compra>compras;
	
	//Getters And Setters
	public ArrayList<Compra> getCompras() {
		//TODO Aca estoy pensando si vendria bien traer de los daos todos los arraylist y manejarme mas con el modelo que con los daos
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	//Funciones
	void agregarCliente() {
		
	}

	void realizarVenta() {
		
	}
	
	void realizarCompra() {
		
	}
}