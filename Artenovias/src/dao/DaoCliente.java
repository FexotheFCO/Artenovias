package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;

public class DaoCliente {
	
	Connection c = null;

	void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/artenovias?useSSL=false&useTimezone=true&serverTimezone=UTC";
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
	
	public void agregarCliente(Cliente cliente){
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`clientes` (`nombre`,`apellido`,`mail`,`edad`,`telefono1`,`telefono2`) VALUES (?,?,?,?,?,?);");
			update.setString(1, cliente.getNombre());
			update.setString(2, cliente.getApellido());
			update.setString(3, cliente.getMail());
			update.setInt(4, cliente.getEdad());
			update.setInt(5, cliente.getTelefono());
			update.setInt(6, cliente.getTelefono2());
			update.executeUpdate();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public void editarCliente(Cliente cliente) {
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("UPDATE `artenovias`.`clientes` SET `id` = (?), `nombre` = (?), `apellido` = (?), `mail` = (?), `edad` = (?), `telefono1` = (?), `telefono2` = (?) WHERE `id` = (?);");
			update.setInt(1, cliente.getId());
			update.setString(2, cliente.getNombre());
			update.setString(3, cliente.getApellido());
			update.setString(4, cliente.getMail());
			update.setInt(5, cliente.getEdad());
			update.setInt(6, cliente.getTelefono());
			update.setInt(7, cliente.getTelefono2());
			update.setInt(8, cliente.getId());
			update.executeUpdate();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public ArrayList<Cliente> devolverTodosLosClientes() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		conectar();
		
		try {
			String sql = "SELECT * FROM clientes";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				clientes.add(new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("mail"),rs.getInt("telefono1"),rs.getInt("telefono2"),rs.getInt("edad")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return clientes;
	}
}
