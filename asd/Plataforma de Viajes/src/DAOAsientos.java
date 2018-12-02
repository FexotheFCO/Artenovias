import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOAsientos {
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
	
	ArrayList<Asiento> obtenerTodosLosAsientos(int idViaje){
		conectar();
		ArrayList<Asiento> asientos = new ArrayList<Asiento>();

		try {
			String sql = "SELECT * FROM asientos WHERE id_viaje="+idViaje;
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				boolean disponibilidad = false;
				if(rs.getInt("disponible")== 0) {
					disponibilidad = false;
				}else {
					disponibilidad = true;
				}
				
				asientos.add(new Asiento(disponibilidad, rs.getInt("id")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		desconectar();
		return asientos;
		}
	
	}

