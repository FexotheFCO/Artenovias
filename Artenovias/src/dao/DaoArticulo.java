package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Articulo;
import modelo.Cliente;

public class DaoArticulo {
	
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
	
	public void agregarArticulo(Articulo articulo) {
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`articulos` (`cantidad`,`descripcion`,`lugar`) VALUES (?,?,?);");
			update.setInt(1, articulo.getCantidad());
			update.setString(2, articulo.getDescripcion());
			update.setString(3, articulo.getLugar());
			update.executeUpdate();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public void actualizarArticulo(Articulo articulo) {
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("UPDATE `artenovias`.`articulos` SET `cantidad` = (?), `descripcion` = (?), `lugar` = (?) WHERE id = (?)");
			update.setInt(4, articulo.getId());
			update.setInt(1, articulo.getCantidad());
			update.setString(2, articulo.getDescripcion());
			update.setString(3, articulo.getLugar());
			update.executeUpdate();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public void borrarArticulo(int id) {
		conectar();
		try {
			PreparedStatement stm = c.prepareStatement("DELETE FROM `artenovias`.`articulos` WHERE id = (?);");
			stm.setInt(1, id);
			stm.executeUpdate();
			stm.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public ArrayList<Articulo> devolverTodosLosArticulos() {
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		conectar();
		try {
			String sql = "SELECT * FROM articulos";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			DaoTransacciones daoTransacciones = new DaoTransacciones();
			while (rs.next()) {
				articulos.add(new Articulo(rs.getInt("id"),rs.getInt("cantidad"),rs.getString("descripcion"),rs.getString("lugar"),daoTransacciones.devolverTodosLasComprasDeArticulo(rs.getInt("id"))));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return articulos;
	}
	
	public Articulo devolverArticulo(int id) {
		conectar();
		Articulo solucion = new Articulo(0, 0, null, null);
		try {
			PreparedStatement update = c.prepareStatement("SELECT * FROM articulos WHERE id = (?)");
			update.setInt(1, id);
			ResultSet rs = update.executeQuery();
			DaoTransacciones daoTransacciones = new DaoTransacciones();
			while (rs.next()) {
				solucion = new Articulo(rs.getInt("id"),rs.getInt("cantidad"),rs.getString("descripcion"),rs.getString("lugar"),daoTransacciones.devolverTodosLasComprasDeArticulo(rs.getInt("id")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return solucion;
	}
}
