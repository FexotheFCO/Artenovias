package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Usuario;

public class DAOUsuario {
	
	Connection c = null;
	DefaultTableModel model;
	public void conectar() {
		try {
			String db = "reservas";
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/reservas?useSSL=false&useTimezone=true&serverTimezone=UTC";
			c = DriverManager.getConnection(url, "root", "admin");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		try {
			c.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void agregarUser(Cliente user){
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
	
	public ArrayList<Cliente> obtenerTodosLosUsuarios(){
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
	
	public ArrayList<Cliente> obtenerTodosLosAdmins(){
		conectar();
		
		ArrayList<Cliente> users = new ArrayList<Cliente>();//ArrayList para retornar
		try {
			String sql = "SELECT * FROM user WHERE tipo = 1";
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
	
	public ArrayList<Cliente> obtenerTodosLosClientes(){
		
conectar();
		
		ArrayList<Cliente> users = new ArrayList<Cliente>();//ArrayList para retornar
		try {
			String sql = "SELECT * FROM user WHERE tipo = 2 or tipo = 3";
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
	
	public void borrarUsuario(int id) {
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
	
	public Cliente buscarUser(int id) {
		Cliente coso = null;
		conectar();
		try {
			
			String sql = "SELECT * FROM reservas.user where id = (?) AND tipo = 2";
			PreparedStatement select = c.prepareStatement("SELECT * FROM reservas.user where id = (?) AND tipo = 2");
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			select.setInt(1, id);
			select.executeQuery();
			while (rs.next()) {
				 coso = new Usuario(rs.getInt("id"),rs.getString("user"),rs.getString("password"), rs.getInt("tipo"));
				
				return coso;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return coso;
		
		
	}
	
	public void hacerVIP(int id) {
		conectar();
		try {
			
		String sql = "UPDATE user SET tipo = 3 WHERE id = (?)";
		PreparedStatement update = c.prepareStatement(sql);
		update.setInt(1, id);
		update.executeUpdate();
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
	
		desconectar();
		}
	
	public void hacerNoVIP(int id) {
		conectar();
		try {
			
		String sql = "UPDATE user SET tipo = 2 WHERE id = (?)";
		PreparedStatement update = c.prepareStatement(sql);
		update.setInt(1, id);
		update.executeUpdate();
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
	
		desconectar();
		}
	
	
	}

