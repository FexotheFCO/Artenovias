package modelo;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.DaoArticulo;
import dao.DaoRectificacion;
import dao.DaoTransacciones;
import dao.DaoVestido;

public class Cliente {

	private int id;
	private String nombre;
	private String apellido;
	private String mail;
	private int telefono;
	private int telefono2;
	private int edad;
	private Vestido vestido;
	private ArrayList<Pago>pagos;
	private ArrayList<Rectificacion>rectificaciones;
	private ArrayList<ArtNecesario>articulos;
	
	DaoTransacciones daoTrans = new DaoTransacciones();
	DaoRectificacion daoRect = new DaoRectificacion();
	DaoVestido daoVestido = new DaoVestido();
	DaoArticulo daoArticulo = new DaoArticulo();
	
	public Cliente(int id, String nombre, String apellido, String mail, int telefono, int telefono2, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.telefono2 = telefono2;
		this.edad = edad;
		//Creacion del Vestido
		Vestido	vestido = new Vestido(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
		DaoVestido daoVestido = new DaoVestido();
		int idVestido = daoVestido.agregarVestido(vestido);
		//System.out.println("agregando vestido con id"+idVestido);
		this.vestido = daoVestido.devolverUnVestido(idVestido);
	}
	
	public Cliente(int id, String nombre, String apellido, String mail, int telefono, int telefono2, int edad, Vestido vestido,ArrayList<Pago>pagos,ArrayList<Rectificacion>rectificaciones,ArrayList<ArtNecesario>articulos) {
		//TODO arraylist rectificaciones
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.telefono2 = telefono2;
		this.edad = edad;
		this.vestido = vestido;
		this.pagos = pagos;
		this.rectificaciones = rectificaciones;
		this.articulos = articulos;
	}
	
	//Funciones
	public void agregarPago(Pago pago) {
		pago.setId(daoTrans.agregarPago(pago, id));
		pagos.add(pago);
		JOptionPane.showMessageDialog(null, "El pago se agrego correctamente al sistema", "Pago Agregado", 1);
	}
	
	public void borrarPago(int idPago) {
		int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere eliminar este pago", "Eliminar Pago", 2, 2);
		if (pregunta == JOptionPane.YES_OPTION) {
			Pago solucion = null;
			for(Pago p : pagos) {
				if(p.getId() == idPago) {
					solucion = p;
				}
			}
			pagos.remove(solucion);
			daoTrans.borrarPago(idPago);
			JOptionPane.showMessageDialog(null, "El pago se a eliminado correctamente del sistema", "Pago Borrado", 1);
		}else {
			JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion del pago", "Eliminacion Cancelada", 1);
		}
	}

	public int getValorVestido() {
		return vestido.getValor();
	}
	
	public void agregarRectificacion(Rectificacion rectificacion) {
		rectificacion.setId(daoRect.agregarRectificacion(rectificacion, id));
		rectificaciones.add(rectificacion);
		JOptionPane.showMessageDialog(null, "La rectificacion se agrego correctamente al sistema", "Rectificacion Agregada", 1);
	}
	
	public void borrarRectificacion(int idRectificacion) {
		int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere eliminar este pago", "Eliminar Pago", 2, 2);
		if (pregunta == JOptionPane.YES_OPTION) {
			Rectificacion solucion = null;
			for(Rectificacion rectificacion : rectificaciones){
				if(rectificacion.getId() == idRectificacion) {
					solucion = rectificacion;
				}
			}
			rectificaciones.remove(solucion);
			daoRect.borrarRectificacion(idRectificacion);
			JOptionPane.showMessageDialog(null, "La rectificacion se elimino correctamente del sistema", "Rectificacion Eliminada", 1);
		}else {
			JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion del pago", "Eliminacion Cancelada", 1);
		}
		
	}
	
	//editarRectificacion
	
	public void editarVestido(Vestido vestido) {
		daoVestido.actualizarVestido(vestido);
		this.vestido = vestido;
		JOptionPane.showMessageDialog(null, "El vestido se edito correctamente", "Vestido editado", 1);
	}
	
	public int devolverValorPagos() {
		int montoTotal = 0;
		for(Pago p : pagos) {
			montoTotal = montoTotal + p.getMonto();
		}
		return montoTotal;
	}
	
	public void agregarArticulo(ArtNecesario articulo) {
		articulo.setId(daoArticulo.agregarArticuloNecesario(articulo,id));
		articulos.add(articulo);
		JOptionPane.showMessageDialog(null, "El articulo se agrego correctamente al sistema", "Articulo Agregado", 1);
	}
	
	public void borrarArticulo(int idArticulo) {
		int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere eliminar este articulo", "Eliminar Articulo", 2, 2);
		if (pregunta == JOptionPane.YES_OPTION) {
			ArtNecesario solucion = null;
			for(ArtNecesario p : articulos) {
				if(p.getId() == idArticulo) {
					solucion = p;
				}
			}
			articulos.remove(solucion);
			daoArticulo.borrarArticulo(idArticulo, false);
			JOptionPane.showMessageDialog(null, "El articulo se a eliminado correctamente del sistema", "Articulo Borrado", 1);
		}else {
			JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion del articulo", "Eliminacion Cancelada", 1);
		}
	}
	
	public void editarArticulo(ArtNecesario articulo) {
		daoArticulo.actualizarArticuloNecesario(articulo);
		actualizarArticulos();
		JOptionPane.showMessageDialog(null, "El articulo se a editado correctamente", "Articulo Editado", 1);
	}
	
	public ArtNecesario devolverArticulo(int idArticulo) {
		ArtNecesario solucion = null;
		for(ArtNecesario p : articulos) {
			if(p.getId() == idArticulo) {
				solucion = p;
			}
		}
		return solucion;
	}
	
	private void actualizarArticulos() {
		articulos.removeAll(articulos);
		articulos = daoArticulo.devolverTodosLosArticulosNecesario();
	}
	
	//getter and setters
	public ArrayList<Rectificacion> getRectificaciones() {
		return rectificaciones;
	}
	public ArrayList<ArtNecesario> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<ArtNecesario> articulos) {
		this.articulos = articulos;
	}
	public void setRectificaciones(ArrayList<Rectificacion> rectificaciones) {
		this.rectificaciones = rectificaciones;
	}
	public ArrayList<Pago> getPagos() {
		return pagos;
	}
	public void setPagos(ArrayList<Pago> pagos) {
		this.pagos = pagos;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(int telefono2) {
		this.telefono2 = telefono2;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Vestido getVestido() {
		return vestido;
	}
	public void setVestido(Vestido vestido) {
		this.vestido = vestido;
	}
	public int getIdVestido(){
		return vestido.getId();
	}
	
}
