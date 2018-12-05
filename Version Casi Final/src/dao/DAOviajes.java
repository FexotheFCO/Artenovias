package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Asiento;
import modelo.Viaje;

public class DAOviajes {

	Connection c = null;

	public void conectar() {
		try {
			String db = "reservas";
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/reservas?useSSL=false&useTimezone=true&serverTimezone=UTC";
			c = DriverManager.getConnection(url, "root", "admin");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void desconectar() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void agregarViaje(Viaje viaje) {
		conectar();

		int id = 0;
		
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO viajes (destino,precio,fecha,origen) VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);// estosvalues van a cambiar cuando se puedan poner mejor los datetime
			update.setString(1, viaje.getDestino());
			update.setDouble(2, viaje.getPrecio());
			update.setDate(3, java.sql.Date.valueOf(viaje.getFecha()));
			update.setString(4, viaje.getOrigen());
			update.executeUpdate();
			ResultSet rs = update.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			System.out.println(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Asiento a : viaje.getAsientos()) {
			try {
				PreparedStatement update = c.prepareStatement("INSERT INTO asientos (disponible,id_viaje) VALUES (?,?)");// estosvalues van a cambiar cuando se puedan poner mejor los datetime
				update.setBoolean(1, a.isDisponible());
				update.setInt(2, id);
				update.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		desconectar();
	}

	public void borrarViaje(int id) {
		conectar();

		try {
			PreparedStatement update = c.prepareStatement("DELETE FROM `reservas`.`asientos` WHERE id_viaje = (?)");																		
			update.setInt(1, id);
			update.executeUpdate();
			update = c.prepareStatement("DELETE FROM `reservas`.`viajes` WHERE id = (?)");
			update.setInt(1, id);
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		desconectar();
	}
	
	public ArrayList<Viaje> obtenerTodosLosViajes() {
		conectar();

		ArrayList<Viaje> viajes = new ArrayList<Viaje>();
		try {
			String sql = "SELECT * FROM viajes";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);


			while (rs.next()) {// cada resultado de la bd creamos un usuario y los agregamos al arraylist de
								// retorno(de esta manera la clase admin no sirve para nada)
			viajes.add(new Viaje(rs.getInt("id"), rs.getString("destino"), rs.getDouble("precio"),rs.getString("origen"),rs.getDate("fecha").toLocalDate()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		desconectar();
	
		return viajes;
	}
	
	public ArrayList<Viaje> buscarDestino( String buskeda) {
		ArrayList<Viaje> listaViajes = new ArrayList<>();
		
		/*if(textField.getText().isEmpty()) {
			System.out.println("nada");
			return model;
			
		}else {
		*/try {
			conectar();
			
			String[] titulos = {"Id", "Destino", "Precio", "Fecha", "Origen"};
			String filtro = ""+buskeda+"%";
			String SQL = "SELECT * FROM viajes WHERE destino LIKE"+'"'+filtro+'"';
			System.out.println("Consulta: "+SQL);
			

			Statement sta = c.prepareStatement(SQL);
			ResultSet rs = sta.executeQuery(SQL);

			while (rs.next()) {
				Viaje sup = null;
				sup = new Viaje(rs.getInt("id"), rs.getString("destino"), rs.getDouble("precio"),rs.getString("origen"),rs.getDate("fecha").toLocalDate());
				listaViajes.add(sup);
				for(Viaje v : listaViajes) {
				System.out.println("Viajes: "+v.getDestino());
				}
				}

		
			c.close();
			rs.close();
			sta.close();
			desconectar();
			}catch(Exception e) 
		{
		System.err.println(""+e.getMessage());
		}
		desconectar();
		return listaViajes;
		
	}
	
	public void actualizarViaje(Viaje viaje) {
		conectar();
		System.out.println(viaje.getOrigen());
		try {
			PreparedStatement update = c.prepareStatement("UPDATE `reservas`.`viajes` SET `id` = (?), `destino` = (?), `precio` = (?), `fecha` = (?), `origen` = (?) WHERE `id` = (?);");
			update.setInt(1, viaje.getId());
			update.setString(2, viaje.getDestino());
			update.setDouble(3, viaje.getPrecio());
			update.setDate(4, java.sql.Date.valueOf(viaje.getFecha()));
			update.setString(5, viaje.getOrigen());
			update.setInt(6, viaje.getId());
			update.executeUpdate();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public Viaje devolverViaje(int idViaje) {
		conectar();
		int id = 0;
		String destino = null;
		String origen = null;
		Double precio = null;
		LocalDate fecha = null;
		try {
			PreparedStatement update = c.prepareStatement("SELECT * FROM `reservas`.`VIAJES` WHERE id = (?)");																		
			update.setInt(1, idViaje);
			ResultSet rs = update.executeQuery();	
			if(rs.next()) {
				id=rs.getInt("id");
				destino = rs.getString("destino");
				origen = rs.getString("origen");
				precio = rs.getDouble("precio");
				fecha = rs.getDate("fecha").toLocalDate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		desconectar();
		return new Viaje(id,destino,precio,origen,fecha);
	}
}
	//}

	
	/*int ultimoIdViaje() {

		conectar();

		int ultimoID = 0;

		try {
			PreparedStatement stmt = c.prepareStatement("SELECT * FROM viajes", Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.executeQuery();

			// ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				ultimoID = rs.getInt(1);

			}
			System.out.println(ultimoID);
			return ultimoID;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		desconectar();
		return 0;
	}*/


