
public class Asiento {
	
	private int id;

//comentario cancer a�adido al git
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	private boolean disponible;
	
	public Asiento(boolean disponible,int id) {
		this.disponible = disponible;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
