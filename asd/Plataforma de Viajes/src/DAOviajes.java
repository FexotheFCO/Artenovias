import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DAOviajes {

	Connection c = null;

	void conectar() {
		try {
			String db = "reservas";
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/reservas?useSSL=false&useTimezone=true&serverTimezone=UTC";
			c = DriverManager.getConnection(url, "root", "admin");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void desconectar() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void agregarViaje(Viaje viaje) {
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

	void borrarViaje(int id) {
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
	
	ArrayList<Viaje> obtenerTodosLosViajes() {
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

public DefaultTableModel buscarDestino( JTable tabla, String buskeda) {//tengo q desharcodear esta shit xdxd
		
		
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
	
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
			
			
			
			model = new DefaultTableModel(null, titulos);
			model.setRowCount(0);
			String[] coso = new String[] {
					"ID", "DESTINO", "PRECIO", "FECHA", "ORIGEN"
				};
			model.addRow(coso);

			Statement sta = c.prepareStatement(SQL);
			ResultSet re = sta.executeQuery(SQL);
			Vector fila = new Vector<>();
			
			while (re.next()) {
				
				
				
				fila.add(re.getInt("id"));
				fila.add(re.getString("destino"));
				fila.add(re.getInt("precio"));
				fila.add(re.getDate("fecha").toLocalDate());
				fila.add(re.getString("Origen"));

				model.addRow(fila);
				}
			
			tabla.setModel(model);
		
			c.close();
			re.close();
			sta.close();
			desconectar();
			}catch(Exception e) 
		{
		System.err.println(""+e.getMessage());
		}
		desconectar();
		return model;
		
}

Viaje devolverViaje(int id) {
	conectar();
	Viaje resultado = null;
	try {
		String sql = "SELECT * FROM viajes WHERE id = (?)";
		PreparedStatement pS = c.prepareStatement(sql);
		pS.setInt(1, id);
		ResultSet rs = pS.executeQuery(sql);
		while(rs.next()){
			resultado = new Viaje(rs.getInt("id"),rs.getString("destino"),rs.getInt("precio"),rs.getString("origen"),rs.getDate("fecha").toLocalDate());
		}
		desconectar();
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return resultado;
}}
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


