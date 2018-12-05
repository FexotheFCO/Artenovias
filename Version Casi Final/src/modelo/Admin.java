package modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.digest.DigestUtils;

import datechooser.beans.DateChooserCombo;

public class Admin extends Cliente{

	public Admin (int id, String user) {
		super(id,user);
	}
	public Admin(int id, String user, String password, int tipo) {
		super(id, user, password, tipo);
	}
	
	
	
	void agregarViaje() {

		
	}
	
	
	void borrarViaje() {
		
		
	}

	void verViajes() {
		
	
		}
		
	void registrarAdmin() {
		
		
		}
		
	
	void eliminarAdmin(int n, JTable tableUsuarios) {
		
		Empresa e = new Empresa("Chevallier");
		e.eliminarAdmin(n, tableUsuarios);
	}

	void verUsuarios(JTable tableUsuarios) {
		
		
		}
	
	@Override
	void reservarPasaje(Viaje viaje, Asiento asiento) {
		// TODO Auto-generated method stub
		
	}

}
