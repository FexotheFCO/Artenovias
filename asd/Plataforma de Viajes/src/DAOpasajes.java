import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOpasajes {
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
	ArrayList<Pasaje> obtenerPasajes() {
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
	void comprar(int id) {
		conectar();
		
		try {
			PreparedStatement update = c.prepareStatement("UPDATE `reservas`.`asientos`SET disponible = 0 WHERE id =(?)");
			update.setInt(1,id);
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
	}
	void eliminarPasaje(Pasaje pasaje) {
		
		conectar();
		try {
			PreparedStatement actualizoide = c.prepareStatement("UPDATE reservas.asientos SET disponible = 1 WHERE id = (?)");
			actualizoide.setInt(1, pasaje.getIdAsiento());
			actualizoide.executeUpdate();
			PreparedStatement deletoide = c.prepareStatement("DELETE FROM reservas.compras WHERE idCompras = (?)");
			deletoide.setInt(1, pasaje.getId());
			deletoide.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	void agregarPasaje(Pasaje pasaje) {
		conectar();

		int id = 0;
		
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO compras (idUser,idViaje,idAsiento) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			update.setInt(1, pasaje.getIdUser());
			update.setInt(2, pasaje.getIdViaje());
			update.setInt(3, pasaje.getIdAsiento());
			update.executeUpdate();
			ResultSet rs = update.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			System.out.println(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		}
	}

