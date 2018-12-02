import java.util.ArrayList;

public class Empresa {
	
	private String nombre;
	private ArrayList<Cliente>clientes = new ArrayList<Cliente>();
	private ArrayList<Viaje>viajes = new ArrayList<Viaje>();
	
	Empresa(String nombre){
		this.nombre = nombre;
		
	}
	
	
	ArrayList<Asiento>mostrarAsientosLibres(Viaje viaje) {
		//mostrar de alguna manera los ascientos disponibles al usuario usando la funcion mostrarAsientosLibres que tiene la clase viaje
		return viaje.mostrarAsientosLibres();
	}
	
	void comprarPasaje(Viaje viaje,Cliente cliente,int index) {//index = 
		ArrayList<Asiento> asientosDisponibles = viaje.mostrarAsientosLibres();
		viaje.reservarAsiento(asientosDisponibles.get(index));
		//cliente.reservarPasaje(viaje1, asientosDisponibles.get(index));
	}
}
