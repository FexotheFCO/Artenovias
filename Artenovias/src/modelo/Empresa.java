package modelo;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.DaoArticulo;
import dao.DaoCliente;

public class Empresa {
	
	private	int id;
	private String nombre;
	
	private ArrayList<Cliente>clientes;
	private ArrayList<ArtDisponible>articulos;
	private ArrayList<ArtNecesario>artNecesarios;
	
	DaoArticulo daoArticulo = new DaoArticulo();
	DaoCliente daoCliente = new DaoCliente();
	
	public Empresa(ArrayList<ArtDisponible> articulos,ArrayList<Cliente> clientes) {
		super();
		this.articulos = articulos;
		this.clientes = clientes;
	}

	//Getters And Setters
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
	public ArrayList<ArtDisponible> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<ArtDisponible> articulos) {
		this.articulos = articulos;
	}

	//Funciones
	public void agregarCliente(Cliente cliente) {
		cliente.setId(daoCliente.agregarCliente(cliente));
		clientes.add(cliente);
		JOptionPane.showMessageDialog(null, "El cliente se a ingresado correctamente al sistema", "Cliente Ingresado", 1);
	}
	
	public void editarCliente(Cliente cliente) {
		daoCliente.editarCliente(cliente);
		actualizarClientes();
		JOptionPane.showMessageDialog(null, "El cliente se a editado correctamente", "Cliente Editado", 1);
	}

	public ArrayList<Cliente> busquedaDeClientes(String busqueda) {
		return daoCliente.busquedaDeClientes(busqueda);
	}
	
	private void actualizarClientes() {
		clientes.remove(clientes);
		clientes = daoCliente.devolverTodosLosClientes();
	}
	
	public void agregarArticulo(ArtDisponible articulo) {
		articulo.setId(daoArticulo.agregarArticuloDisponible(articulo));
		articulos.add(articulo);
		JOptionPane.showMessageDialog(null, "El articulo se a ingresado correctamente al sistema", "Articulo Ingresado", 1);
	}
	
	public void borrarArticulo(int id) {
		int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere eliminar este pago", "Eliminar Pago", 2, 2);
		if (pregunta == JOptionPane.YES_OPTION) {
			int index = 0;
			for(Articulo articulo : articulos) {
				if(articulo.getId() == id) {
					articulos.remove(index);
					break;
				}
				index++;
			}
			daoArticulo.borrarArticulo(id,true);
			JOptionPane.showMessageDialog(null, "El articulo se a eliminado correctamente del sistema", "Articulo Borrado", 1);
		}else {
			JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion del pago", "Eliminacion Cancelada", 1);
		}
	}
	
	private void actualizarArticulos(){
		articulos.removeAll(articulos);
		articulos = daoArticulo.devolverTodosLosArticulosDisponibles();
	}
	
	public void editarArticulo(ArtDisponible articulo) {
		daoArticulo.actualizarArticuloDisponible(articulo);
		actualizarArticulos();
		JOptionPane.showMessageDialog(null, "El articulo se a editado correctamente", "Articulo Editado", 1);
	}
	
	public ArtDisponible devolverUnArticulo(int id) {
		ArtDisponible solucion = null;
		for(ArtDisponible articulo : articulos) {
			if (articulo.getId() == id) {
				solucion = articulo;
				break;
			}
		}
		return solucion;
	}
	
	public ArrayList<Pago> devolverTodosLosPagos() {
		ArrayList<Pago> solucion = new ArrayList<Pago>();
		for(Cliente c : clientes) {
			solucion.addAll(c.getPagos());
		}
		return solucion;
	}
	
	public ArrayList<Compra> devolverTodasLasCompras(){
		ArrayList<Compra> solucion = new ArrayList<Compra>();
		for(Articulo a : articulos) {
			solucion.addAll(a.getCompras());
		}
		return solucion;
	}
	
}
