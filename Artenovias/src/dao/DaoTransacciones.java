package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pago;

public class DaoTransacciones {
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
	
	public void agregarPago(Pago pago,int idCliente) {
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`pagos` (`idcliente`,`monto`,`fecha`,`descripcion`) VALUES (?,?,?,?);");
			update.setInt(1, idCliente);
			update.setInt(2, pago.getMonto());
			update.setDate(3, null);
			update.setString(4, pago.getDescripcion());
			update.executeUpdate();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public void borrarPago(int idPago) {
		conectar();
		try {
			PreparedStatement stm = c.prepareStatement("DELETE FROM `artenovias`.`pagos` WHERE id = (?);");
			stm.setInt(1, idPago);
			stm.executeUpdate();
			stm.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public ArrayList<Pago>devolverTodosLosPagos(){
		ArrayList<Pago> pagos = new ArrayList<Pago>();
		conectar();
		try {
			String sql = "SELECT * FROM articulos";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			DaoCliente daoCliente = new DaoCliente();
			while (rs.next()) {
				pagos.add(new Pago(rs.getInt("id"),rs.getInt("monto"),rs.getString("descripcion")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return pagos;
	}
	
	public ArrayList<Pago>devolverTodosLosPagosDeCliente(int idCliente){
		ArrayList<Pago> pagos = new ArrayList<Pago>();
		conectar();
		try {
			PreparedStatement stm = c.prepareStatement("SELECT * FROM pagos WHERE idcliente = (?)");
			stm.setInt(1, idCliente);
			ResultSet rs = stm.executeQuery();
			DaoCliente daoCliente = new DaoCliente();
			while (rs.next()) {
				pagos.add(new Pago(rs.getInt("id"),rs.getInt("monto"),rs.getString("descripcion")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return pagos;
	}
}
