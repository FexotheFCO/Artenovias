package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Asiento;
import modelo.Cliente;
import modelo.Pasaje;
import modelo.Viaje;

public class DAOCompras {
	
	Connection c = null;
	void conectar() {
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

	void desconectar() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pasaje> obtenerPasajes() {
		conectar();
		ArrayList<Pasaje> solucion = new ArrayList<Pasaje>();

		try {
			String sql = "SELECT * FROM compras";
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				solucion.add(new Pasaje(rs.getInt("idCompras"),rs.getInt("idUser"), rs.getInt("idViaje"), rs.getInt("idAsiento")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		desconectar();
		return solucion;
	
	}
	
}
