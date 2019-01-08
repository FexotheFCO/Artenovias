package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Compra;
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
	
	public int agregarPago(Pago pago,int idCliente) {
		int id = 0;
		conectar();
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`pagos` (`idcliente`,`monto`,`fecha`,`descripcion`) VALUES (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
			update.setInt(1, idCliente);
			update.setInt(2, pago.getMonto());
			update.setDate(3, null);
			update.setString(4, pago.getDescripcion());
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
	
	/*public ArrayList<Pago>devolverTodosLosPagos(){
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
	}*/
	
	public ArrayList<Pago>devolverTodosLosPagosDeCliente(int idCliente){
		ArrayList<Pago> pagos = new ArrayList<Pago>();
		conectar();
		try {
			PreparedStatement stm = c.prepareStatement("SELECT * FROM pagos WHERE idcliente = (?)");
			stm.setInt(1, idCliente);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				pagos.add(new Pago(rs.getInt("id"),rs.getInt("monto"),rs.getString("descripcion")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return pagos;
	}
	
	public int agregarCompra(Compra compra,int idArticulo) {
		conectar();
		int id = 0;
		try {
			PreparedStatement update = c.prepareStatement("INSERT INTO `artenovias`.`compras` (`idarticulo`,`monto`,`fecha`,`cantidad`) VALUES (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
			update.setInt(1, idArticulo);
			update.setInt(2, compra.getMonto());
			update.setDate(3, null);
			update.setInt(4, compra.getCantidad());
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
	
	public void borrarCompra(int idCompra) {
		conectar();
		try {
			PreparedStatement stm = c.prepareStatement("DELETE FROM `artenovias`.`compras` WHERE id = (?);");
			stm.setInt(1, idCompra);
			stm.executeUpdate();
			stm.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		desconectar();
	}
	
	public ArrayList<Compra>devolverTodosLasComprasDeArticulo(int idArticulo){
		ArrayList<Compra> compras = new ArrayList<Compra>();
		conectar();
		try {
			PreparedStatement stm = c.prepareStatement("SELECT * FROM compras WHERE idarticulo = (?)");
			stm.setInt(1, idArticulo);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				compras.add(new Compra(rs.getInt("id"),rs.getInt("monto"),rs.getDate("fecha"),rs.getInt("cantidad")));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		desconectar();
		return compras;
	}
	
	
}
