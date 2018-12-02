import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOCompras {
	
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
	
	ArrayList<Pasaje> obtenerTodosLosPasajes(){
		ArrayList<Pasaje> compras = new ArrayList<Pasaje>();
		conectar();
		
		try {
			String sql = "SELECT * FROM compras ";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				compras.add(new Pasaje(rs.getInt("idCompras"),rs.getInt("idUser"),rs.getInt("idViaje"),rs.getInt("idAsiento")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return compras;
	}
	
}
