
public abstract class Cliente {
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String user;
	private String password;
	private int tipo;
	public Cliente(int id,String user, String password, int tipo){
		this.id = id;
		this.user = user;
		this.password = password;
		this.tipo = tipo;
	}

	abstract void reservarPasaje(Viaje viaje, Asiento asiento);

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
