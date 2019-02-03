package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Cliente;

public class DaoCliente {
	
	private DaoVestido daoVestido = new DaoVestido();
	private DaoTransacciones daoTrans = new DaoTransacciones();
	private DaoRectificacion daoRect = new DaoRectificacion();
	private DaoArticulo daoArticulo = new DaoArticulo();
	
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
	
	public int agregarCliente(Cliente cliente){
		conectar();
		int id = 0;
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`clientes` (`nombre`,`apellido`,`mail`,`edad`,`telefono1`,`telefono2`,`idvestido`) VALUES (?,?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
			update.setString(1, cliente.getNombre());
			update.setString(2, cliente.getApellido());
			update.setString(3, cliente.getMail());
			update.setInt(4, cliente.getEdad());
			update.setInt(5, cliente.getTelefono());
			update.setInt(6, cliente.getTelefono2());
			update.setInt(7, cliente.getIdVestido());
			update.executeUpdate();
			ResultSet rs = update.getGeneratedKeys();
			while(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return id;
	}
	
	public void editarCliente(Cliente cliente) {
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("UPDATE `artenovias`.`clientes` SET `nombre` = (?), `apellido` = (?), `mail` = (?), `edad` = (?), `telefono1` = (?), `telefono2` = (?) WHERE `id` = (?);");
			update.setString(1, cliente.getNombre());
			update.setString(2, cliente.getApellido());
			update.setString(3, cliente.getMail());
			update.setInt(4, cliente.getEdad());
			update.setInt(5, cliente.getTelefono());
			update.setInt(6, cliente.getTelefono2());
			update.setInt(7, cliente.getId());
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
				clientes.add(new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("mail"),rs.getInt("telefono1"),rs.getInt("telefono2"),rs.getInt("edad"),
						daoVestido.devolverUnVestido(rs.getInt("idvestido")),daoTrans.devolverTodosLosPagosDeCliente(rs.getInt("id")),daoRect.devolverTodasLasRectificacionesDeCliente(rs.getInt("id")),daoArticulo.devolverArticulosNecesariosDeCliente(rs.getInt("id"))));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return clientes;
	}
	
	public Cliente devolverCliente(int id) {
		conectar();
		try {
			String sql = "SELECT * FROM clientes WHERE id = (?)";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			DaoVestido daoVestido = new DaoVestido();
			DaoTransacciones daoTrans = new DaoTransacciones();
			while (rs.next()) {
				return new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("mail"),rs.getInt("telefono1"),rs.getInt("telefono2"),rs.getInt("edad"),
						daoVestido.devolverUnVestido(rs.getInt("idvestido")),daoTrans.devolverTodosLosPagosDeCliente(rs.getInt("id")),daoRect.devolverTodasLasRectificacionesDeCliente(rs.getInt("id")),daoArticulo.devolverArticulosNecesariosDeCliente(rs.getInt("id")));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return null;
	}
	
	public ArrayList<Cliente> busquedaDeClientes(String busqueda){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		conectar();
		try {
			String sql = "SELECT * FROM clientes where `apellido` LIKE (?)";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, busqueda + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				clientes.add(new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("mail"),rs.getInt("telefono1"),rs.getInt("telefono2"),rs.getInt("edad"),
						daoVestido.devolverUnVestido(rs.getInt("idvestido")),daoTrans.devolverTodosLosPagosDeCliente(rs.getInt("id")),daoRect.devolverTodasLasRectificacionesDeCliente(rs.getInt("id")),daoArticulo.devolverArticulosNecesariosDeCliente(rs.getInt("id"))));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return clientes;
	}
}
