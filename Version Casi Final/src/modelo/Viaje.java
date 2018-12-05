package modelo;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Viaje {

	private int id;
	private String destino;
	private double precio;
	private LocalDate fecha;
	private String origen;
	private ArrayList<Asiento>asientos = new ArrayList<Asiento>();
	
	public Viaje(int id,String destino, double precio,String origen,int cantidadDeAsientos, LocalDate fecha){
		this.id = id;
		this.destino = destino;
		this.precio = precio;
		this.origen = origen;
		this.fecha = fecha;

		crearAsientos(cantidadDeAsientos);
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Viaje(int id, String destino, double precio,String origen, LocalDate fecha) {
		this.id = id;
		this.destino = destino;
		this.precio = precio;
		this.origen = origen;
		this.fecha = fecha;
	}
	
	public void reservarAsiento(Asiento asiento) {
		asiento.setDisponible(false);
	}
	
	public void cancelarAsiento(Asiento asiento) {
		asiento.setDisponible(true);
	}
	
	public ArrayList<Asiento> mostrarAsientosLibres() {
		ArrayList<Asiento> asientosDisponibles = new ArrayList<Asiento>();
		for (Asiento asiento : asientos) {
			if(asiento.isDisponible()) {
				asientosDisponibles.add(asiento);
			}
		}
		return asientosDisponibles;
	}	

	public void crearAsientos(int cantidadDeAsientos) {
		for (int i = 0; i < cantidadDeAsientos; i++) {
			Asiento asiento = new Asiento(true,i+1);
			asientos.add(asiento);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/*public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
*/
	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}
	
}
