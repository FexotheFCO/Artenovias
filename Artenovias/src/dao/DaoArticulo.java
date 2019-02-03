package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.ArtDisponible;
import modelo.ArtNecesario;
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
	
	public int agregarArticuloDisponible(ArtDisponible articulo) {
		conectar();
		int id = 0;
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`articulos` (`cantidad`,`descripcion`,`lugar`) VALUES (?,?,?);",Statement.RETURN_GENERATED_KEYS);
			update.setInt(1, articulo.getCantidad());
			update.setString(2, articulo.getDescripcion());
			update.setString(3, articulo.getLugar());
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
	
	public int agregarArticuloNecesario(ArtNecesario articulo, int idCliente) {
		conectar();
		int id = 0;
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`artnecesarios` (`cantidad`,`descripcion`,`disponible`,`idcliente`) VALUES (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
			update.setInt(1, articulo.getCantidad());
			update.setString(2, articulo.getDescripcion());
			update.setBoolean(3, articulo.isDisponible());
			update.setInt(4, idCliente);
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
	
	public void actualizarArticuloDisponible(ArtDisponible articulo) {
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
	
	public void actualizarArticuloNecesario(ArtNecesario articulo) {
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("UPDATE `artenovias`.`artnecesarios` SET `cantidad` = (?), `descripcion` = (?), `disponible` = (?) WHERE id = (?)");
			update.setInt(4, articulo.getId());
			update.setInt(1, articulo.getCantidad());
			update.setString(2, articulo.getDescripcion());
			update.setBoolean(3, articulo.isDisponible());
			update.executeUpdate();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public void borrarArticulo(int id,boolean esDisponible) {
		conectar();
		String sql = null;
		if(esDisponible) {
			sql = "DELETE FROM `artenovias`.`articulos` WHERE id = (?);";
		}else {
			sql = "DELETE FROM `artenovias`.`artnecesarios` WHERE id = (?);";
		}
		try {
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setInt(1, id);
			stm.executeUpdate();
			stm.close();
		}catch (java.sql.SQLIntegrityConstraintViolationException e1) {
			e1.printStackTrace();
			//todo msj de que el articulo tiene compras incluidas y no se puede borrar
		}catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public ArrayList<ArtDisponible> devolverTodosLosArticulosDisponibles() {
		ArrayList<ArtDisponible> articulos = new ArrayList<ArtDisponible>();
		conectar();
		try {
			String sql = "SELECT * FROM articulos";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			DaoTransacciones daoTransacciones = new DaoTransacciones();
			while (rs.next()) {
				articulos.add(new ArtDisponible(rs.getInt("id"),rs.getInt("cantidad"),rs.getString("descripcion"),rs.getString("lugar"),daoTransacciones.devolverTodosLasComprasDeArticulo(rs.getInt("id"))));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return articulos;
	}
	
	public ArrayList<ArtNecesario> devolverTodosLosArticulosNecesario() {
		ArrayList<ArtNecesario> articulos = new ArrayList<ArtNecesario>();
		conectar();
		try {
			String sql = "SELECT * FROM artnecesarios";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			DaoTransacciones daoTransacciones = new DaoTransacciones();
			while (rs.next()) {
				articulos.add(new ArtNecesario(rs.getInt("id"),rs.getInt("cantidad"),rs.getString("descripcion"),daoTransacciones.devolverTodosLasComprasDeArticulo(rs.getInt("id")),rs.getBoolean("disponible")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return articulos;
	}
	
	public ArtDisponible devolverArticuloDisponible(int id) {
		conectar();
		ArtDisponible solucion = new ArtDisponible(0, 0, null, null);
		try {
			PreparedStatement update = c.prepareStatement("SELECT * FROM articulos WHERE id = (?)");
			update.setInt(1, id);
			ResultSet rs = update.executeQuery();
			DaoTransacciones daoTransacciones = new DaoTransacciones();
			while (rs.next()) {
				solucion = new ArtDisponible(rs.getInt("id"),rs.getInt("cantidad"),rs.getString("descripcion"),rs.getString("lugar"),daoTransacciones.devolverTodosLasComprasDeArticulo(rs.getInt("id")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return solucion;
	}
	
	public ArtNecesario devolverArticuloNecesario(int id) {
		conectar();
		ArtNecesario solucion = new ArtNecesario(0, 0, null, null,true);
		try {
			PreparedStatement update = c.prepareStatement("SELECT * FROM artnecesarios WHERE id = (?)");
			update.setInt(1, id);
			ResultSet rs = update.executeQuery();
			DaoTransacciones daoTransacciones = new DaoTransacciones();
			while (rs.next()) {
				solucion = new ArtNecesario(rs.getInt("id"),rs.getInt("cantidad"),rs.getString("descripcion"),daoTransacciones.devolverTodosLasComprasDeArticulo(rs.getInt("id")),rs.getBoolean("disponible"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return solucion;
	}
	//devolverArticulosNecesariosdeCliente 
	public ArrayList<ArtNecesario> devolverArticulosNecesariosDeCliente(int idCliente){
		ArrayList<ArtNecesario> articulos = new ArrayList<ArtNecesario>();
		conectar();
		try {
			String sql = "SELECT * FROM artnecesarios WHERE idcliente = (?)";
			PreparedStatement update = c.prepareStatement(sql);
			update.setInt(1, idCliente);
			ResultSet rs = update.executeQuery();
			DaoTransacciones daoTransacciones = new DaoTransacciones();
			while (rs.next()) {
				articulos.add(new ArtNecesario(rs.getInt("id"),rs.getInt("cantidad"),rs.getString("descripcion"),daoTransacciones.devolverTodosLasComprasDeArticulo(rs.getInt("id")),rs.getBoolean("disponible")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return articulos;
	}
}
