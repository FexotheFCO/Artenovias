package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Venta;

public class DaoVenta {
	
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
	
	public void agregarVenta(Venta venta) {
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO ventas (id,idcliente,monto,fecha) VALUES (?,?,?,?)");// estosvalues van a cambiar cuando se puedan poner mejor los datetime
			update.setInt(1, venta.getId());
			update.setInt(2, venta.getCliente().getId());
			update.setInt(3, venta.getMonto());
			update.setDate(4, (Date) venta.getFecha());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public Cliente devolverCliente(int id) {
		conectar();
		try {
			String sql = "SELECT * FROM clientes WHERE id = (?)";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				return new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("mail"),rs.getInt("telefono1"),rs.getInt("telefono2"),rs.getInt("edad"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return null;
	}
	
	public ArrayList<Venta> devolverTodasLasVentas() {
		ArrayList<Venta> solucion = new ArrayList<Venta>();
		conectar();
		try {
			String sql = "SELECT * FROM ventas";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				solucion.add(new Venta(rs.getInt("id"),devolverCliente(rs.getInt("idcliente")),rs.getInt("monto"),rs.getDate("fecha")));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return solucion;
	}
}
