package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Rectificacion;

public class DaoRectificacion {

	Connection c = null;

	private void conectar() {
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

	private void desconectar() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int agregarRectificacion(Rectificacion rectificacion,int idCliente) {
		int id = 0;
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`rectificaciones` (`idcliente`,`texto`,`fecha`) VALUES (?,?,?);",Statement.RETURN_GENERATED_KEYS);
			update.setInt(1, idCliente);
			update.setString(2, rectificacion.getTexto());
			update.setDate(3, java.sql.Date.valueOf(rectificacion.getFecha()));
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
	
	public void borrarRectificacion(int idRectificacion) {
		conectar();
		try {
			PreparedStatement stm = c.prepareStatement("DELETE FROM `artenovias`.`rectificaciones` WHERE id = (?);");
			stm.setInt(1, idRectificacion);
			stm.executeUpdate();
			stm.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public ArrayList<Rectificacion>devolverTodasLasRectificacionesDeCliente(int idCliente){
		ArrayList<Rectificacion> rectificacion = new ArrayList<Rectificacion>();
		conectar();
		try {
			PreparedStatement stm = c.prepareStatement("SELECT * FROM rectificaciones WHERE idcliente = (?)");
			stm.setInt(1, idCliente);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				rectificacion.add(new Rectificacion(rs.getInt("id"),rs.getString("texto"),rs.getDate("fecha")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return rectificacion;
	}
}
