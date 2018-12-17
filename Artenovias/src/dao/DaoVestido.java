package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Vestido;

public class DaoVestido {
	
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
	
	public Vestido devolverUnVestido(int idVestido) {
		conectar();
		Vestido vestido = null;
		try {
			String sql = "SELECT * FROM VESTIDOS WHERE ID = (?);";
			PreparedStatement unVestido = c.prepareStatement(sql);
			unVestido.setInt(1, idVestido);
			ResultSet rs = unVestido.executeQuery();
			while(rs.next()) {
				System.out.println("id del vestido devuelto"+ String.valueOf(rs.getInt("id")));
				vestido = new Vestido(rs.getInt("id"),rs.getInt("talledelantero"),rs.getInt("talletrasero"),rs.getInt("hombro"),rs.getInt("alturahombro"),rs.getInt("espalda"),rs.getInt("pecho"),rs.getInt("pinza"),rs.getInt("bajosisa"),rs.getInt("busto"),rs.getInt("bustodelantero"),rs.getInt("contornobustosup"),rs.getInt("contornobustoinf"),rs.getInt("centrobusto"),rs.getInt("cintura"),rs.getInt("cadera"),rs.getInt("escotedelantero"),rs.getInt("escotetrasero"),rs.getInt("pico"),rs.getInt("largofaldalarga"),rs.getInt("largofaldacorta"),rs.getInt("arrastre"),rs.getInt("largo"),rs.getInt("ancho"),rs.getInt("puño"),rs.getInt("largocascada"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		desconectar();
		return vestido;
	}
	
	public int agregarVestido(Vestido vestido) {
		int id = 0;
		conectar();
		try {
			String sql = "INSERT INTO `artenovias`.`vestidos`(`talledelantero`,`talletrasero`,`hombro`,`alturahombro`,`espalda`,`pecho`,`pinza`,`bajosisa`,`busto`,`bustodelantero`,`contornobustosup`,`contornobustoinf`,`centrobusto`,`cintura`,`cadera`,`escotedelantero`,`escotetrasero`,`pico`,`largofaldalarga`,`largofaldacorta`,`arrastre`,`largo`,`ancho`,`puño`,`largocascada`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement update = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			update.setInt(1, vestido.getTalleDelantero());
			update.setInt(2, vestido.getTalleTrasero());
			update.setInt(3, vestido.getHombro());
			update.setInt(4, vestido.getAlturaHombro());
			update.setInt(5, vestido.getEspalda());
			update.setInt(6, vestido.getPecho());
			update.setInt(7, vestido.getPinza());
			update.setInt(8, vestido.getBajoSisa());
			update.setInt(9, vestido.getBusto());
			update.setInt(10, vestido.getBustoDelantero());
			update.setInt(11, vestido.getContornoBustoSup());
			update.setInt(12, vestido.getContornoBustoInf());
			update.setInt(13, vestido.getCentroBusto());
			update.setInt(14, vestido.getCintura());
			update.setInt(15, vestido.getCadera());
			update.setInt(16, vestido.getEscoteDelantero());
			update.setInt(17, vestido.getEscoteTrasero());
			update.setInt(18, vestido.getPico());
			update.setInt(19, vestido.getLargoFaldaLarga());
			update.setInt(20, vestido.getLargoFaldaCorta());
			update.setInt(21, vestido.getArrastre());
			update.setInt(22, vestido.getLargo());
			update.setInt(23, vestido.getAncho());
			update.setInt(24, vestido.getPuño());
			update.setInt(25, vestido.getLargoCascada());
			update.executeUpdate();
			//Consigo el id del vestido aniadido a la bd para luego crear el cliente con este vestido asignado
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
	
	public void actualizarVestido(Vestido vestido) {
		conectar();
		
		try {
			String sql = "UPDATE `artenovias`.`vestidos` SET `talledelantero` = (?),`talletrasero` = (?),`hombro` = (?),`alturahombro` = (?),`espalda` = (?),`pecho` = (?),`pinza` = (?),`bajosisa` = (?),`busto` = (?),`bustodelantero` = (?),`contornobustosup` = (?),`contornobustoinf` = (?),`centrobusto` = (?),`cintura` = (?),`cadera` = (?),`escotedelantero` = (?),`escotetrasero` = (?),`pico` = (?),`largofaldalarga` = (?),`largofaldacorta` = (?),`arrastre` = (?),`largo` = (?),`ancho` = (?),`puño` = (?),`largocascada` = (?) WHERE `id` = (?);";
			PreparedStatement update = c.prepareStatement(sql);
			update.setInt(1, vestido.getTalleDelantero());
			update.setInt(2, vestido.getTalleTrasero());
			update.setInt(3, vestido.getHombro());
			update.setInt(4, vestido.getAlturaHombro());
			update.setInt(5, vestido.getEspalda());
			update.setInt(6, vestido.getPecho());
			update.setInt(7, vestido.getPinza());
			update.setInt(8, vestido.getBajoSisa());
			update.setInt(9, vestido.getBusto());
			update.setInt(10, vestido.getBustoDelantero());
			update.setInt(11, vestido.getContornoBustoSup());
			update.setInt(12, vestido.getContornoBustoInf());
			update.setInt(13, vestido.getCentroBusto());
			update.setInt(14, vestido.getCintura());
			update.setInt(15, vestido.getCadera());
			update.setInt(16, vestido.getEscoteDelantero());
			update.setInt(17, vestido.getEscoteTrasero());
			update.setInt(18, vestido.getPico());
			update.setInt(19, vestido.getLargoFaldaLarga());
			update.setInt(20, vestido.getLargoFaldaCorta());
			update.setInt(21, vestido.getArrastre());
			update.setInt(22, vestido.getLargo());
			update.setInt(23, vestido.getAncho());
			update.setInt(24, vestido.getPuño());
			update.setInt(25, vestido.getLargoCascada());
			update.setInt(26, vestido.getId());
			update.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		desconectar();
	}

}
