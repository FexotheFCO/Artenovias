package modelo;

import java.util.ArrayList;

public class ArtNecesario extends Articulo{
	
	private boolean disponible;

	public ArtNecesario(int id, int cantidad, String descripcion,boolean disponible) {
		super(id, cantidad, descripcion);
		this.disponible = disponible;
		// TODO Auto-generated constructor stub
	}
	
	public ArtNecesario(int id, int cantidad, String descripcion, ArrayList<Compra> compras,boolean disponible) {
		super(id, cantidad, descripcion, compras);
		this.disponible = disponible;
		// TODO Auto-generated constructor stub
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	

}
