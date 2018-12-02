import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOUsuario {
	
	Connection c = null;
	DefaultTableModel model;
	void conectar() {
		try {
			String db = "reservas";
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/reservas?useSSL=false&useTimezone=true&serverTimezone=UTC";
			c = DriverManager.getConnection(url, "root", "admin");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	void desconectar() {
		try {
			c.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void agregarUser(Cliente user){
		conectar();
		
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO user (user,password,tipo) VALUES (?,?,?)");
			update.setString(1,user.getUser());
			update.setString(2,user.getPassword());
			update.setInt(3, user.getTipo());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
	}
	
	ArrayList<Cliente> obtenerTodosLosUsuarios(){
		conectar();
		
		ArrayList<Cliente> users = new ArrayList<Cliente>();//ArrayList para retornar
		try {
			String sql = "SELECT * FROM user";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {//cada resultado de la bd creamos un usuario y los agregamos al arraylist de retorno(de esta manera la clase admin no sirve para nada)
				users.add(new Usuario(rs.getInt("id"),rs.getString("user"),rs.getString("password"), rs.getInt("tipo")));//es posible cambiar la clase admin por una sola de usuario con un booleano si es admin o no
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return users;
	}
	
	void borrarUsuario(int id) {
	conectar();
	
	try {
		PreparedStatement update = c.prepareStatement("DELETE FROM `reservas`.`user` WHERE id = (?)");
		update.setInt(1,id);
		update.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	desconectar();
}
	}

