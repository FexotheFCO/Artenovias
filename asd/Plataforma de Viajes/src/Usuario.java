import java.util.ArrayList;

public class Usuario extends Cliente {
	
	private ArrayList<Viaje> misViajes = new ArrayList<Viaje>();
	//private int id;
	public Usuario(int id,String user, String password, int tipo){
		super(id,user,password, tipo);
	};
	
	void reservarPasaje(Viaje viaje, Asiento asiento) {
		misViajes.add(viaje);
	}
	
	void cancelarPasaje() {
		
	}
}
