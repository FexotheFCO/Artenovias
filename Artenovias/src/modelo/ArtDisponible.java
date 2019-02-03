package modelo;

import java.util.ArrayList;

public class ArtDisponible  extends Articulo{
	
	private String lugar;

	public ArtDisponible(int id, int cantidad, String descripcion, String lugar, ArrayList<Compra> compras) {
		super(id, cantidad, descripcion, compras);
		this.lugar = lugar;
		// TODO Auto-generated constructor stub
	}
	
	public ArtDisponible(int id, int cantidad, String descripcion, String lugar) {
		super(id, cantidad, descripcion);
		this.lugar = lugar;
		// TODO Auto-generated constructor stub
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
}
