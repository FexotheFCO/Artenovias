
public class Admin extends Cliente{

	public Admin(int id, String user, String password, int tipo) {
		super(id, user, password, tipo);
	}

	void nuevoViaje() {
		
	}
	
	void borrarViaje() {
		
	}

	@Override
	void reservarPasaje(Viaje viaje, Asiento asiento) {
	}

}
