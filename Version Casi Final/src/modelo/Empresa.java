package modelo;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.digest.DigestUtils;

public class Empresa {
	
	private String nombre;
	private ArrayList<Cliente>clientes = new ArrayList<Cliente>();
	private ArrayList<Viaje>viajes = new ArrayList<Viaje>();
	private ArrayList<Admin> administradores = new ArrayList<Admin>();
	
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
	
	void registrarUsuario(String usuario, String password, String password2) {
		

		}
		
	void registrarAdmin(String usuario, String password, String password2) {
		
			
		}
		
	
	void eliminarAdmin(int n, JTable tableUsuarios) {
		

		//aca tendria q eliminar al administrador del array
	}
}

