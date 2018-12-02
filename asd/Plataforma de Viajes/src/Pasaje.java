
public class Pasaje {
	private int id;
	private int idUser;
	private int idViaje;
	private int idAsiento;
	
	public Pasaje(int id,int idUser, int idViaje, int idAsiento) {
		this.id = id;
		this.idUser = idUser;
		this.idViaje = idViaje;
		this.idAsiento = idAsiento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	public int getIdAsiento() {
		return idAsiento;
	}
	public void setIdAsiento(int idAsiento) {
		this.idAsiento = idAsiento;
	}
	
}
