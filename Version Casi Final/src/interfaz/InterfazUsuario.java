package interfaz;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.xml.internal.ws.api.Component;

import dao.DAOAsientos;
import dao.DAOUsuario;
import dao.DAOpasajes;
import dao.DAOviajes;
import javafx.scene.control.ComboBox;
import modelo.Asiento;
import modelo.Cliente;
import modelo.Pasaje;
import modelo.Viaje;

import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import java.awt.Font;

public class InterfazUsuario extends JPanel {
	
	DAOUsuario daoUsuario = new DAOUsuario();
	DAOviajes daoViajes = new DAOviajes();
	DAOAsientos daoAsiento = new DAOAsientos();
	DAOpasajes daoPasajes = new DAOpasajes();
	
	DefaultTableModel model;
	Connection c = null;
	
	
	//private JTable table;
	private float totalGastado;
	private JTable tableBusqueda;
	private JButton btnRefresh;
	private JTable tableMisViajes;
	private JLabel lblCosto;
	private JTextField textField;
	private JComboBox<Integer> listado;
	private JButton btnComprar;
	private JLabel lblNewLabel;
	
	public void actualizarCompras() {
		DefaultTableModel modeloViajes = (DefaultTableModel) tableBusqueda.getModel();
		modeloViajes.setRowCount(1);
		for(Viaje v : daoViajes.obtenerTodosLosViajes()) {
			Object[] linea = {v.getId(),v.getDestino(),v.getPrecio(),v.getFecha(),v.getOrigen()};
			modeloViajes.addRow(linea);
			tableBusqueda.setModel(modeloViajes);
		}
	}
	
	public void actualizarListado() {
		listado.removeAllItems();
		int coso = tableBusqueda.getSelectedRow();
		Object idViaje = tableBusqueda.getValueAt(coso, 0);
		String seleccionId = String.valueOf(idViaje);
		System.out.println("id viajesoide"+idViaje);
		ArrayList<Asiento> asientoides = daoAsiento.obtenerTodosLosAsientos(seleccionId);
		for(Asiento a : asientoides) {
			if(a.isDisponible()) {
			listado.addItem(a.getId());
			}
		}
		
	}
	
	public void misCostosTotales(Cliente user, JLabel lblCosto) {
		totalGastado = 0;
		for(Pasaje p : daoPasajes.obtenerPasajes()) {
			if(p.getIdUser() == user.getId()) {
				int idViaje = p.getIdViaje();
				for(Viaje v : daoViajes.obtenerTodosLosViajes()) {
					if(v.getId() == idViaje) {
						totalGastado += v.getPrecio();
					}	
				}
			}
			
		}
		switch (user.getTipo()) {
		case 2:
			lblCosto.setText(""+totalGastado);
			return;
		case 3:
			totalGastado = totalGastado*0.8f;
			lblCosto.setText(""+totalGastado);
			break;
		}	
	}
	
	public void actualizarMisViajes(Cliente user) {
		
		DefaultTableModel modelCompras = (DefaultTableModel) tableMisViajes.getModel();
		modelCompras.setRowCount(1);
		String destinoide = "";
		String origen = "";
		String nombreUser ="";
		LocalDate fecha = null;
		for(Pasaje p : daoPasajes.obtenerPasajes()) {
			if(p.getIdUser()==user.getId()) {//chekeo que muestre solo los viajes del user actual
			int idViajesoide = p.getIdViaje();
			int idUseroide = p.getIdUser();
			
			double precioide = 0;
			for(Viaje v: daoViajes.obtenerTodosLosViajes()) {//busco a que viaje pertenece con los datos del pasaje y devuelvo el destino del viaje
				if(idViajesoide == v.getId()) {
					origen=v.getOrigen();
					destinoide = v.getDestino();
					precioide = v.getPrecio();
					fecha = v.getFecha();
				}
			}
			for(Cliente c: daoUsuario.obtenerTodosLosUsuarios()) {//hago lo mismo pero creo q no hace falta, porque ya lo tengo en otro lado
				if(idUseroide==c.getId()) {
					nombreUser = c.getUser();
				}
			}
			
			
			Object[] fila = {p.getId(),p.getIdAsiento(),nombreUser,destinoide, precioide, origen, fecha};
			modelCompras.addRow(fila);
			tableMisViajes.setModel(modelCompras);
			}
			}
	}

	public InterfazUsuario(JFrame frame, Cliente userActualoide) {
		
		setBounds(new Rectangle(0, 0, 900, 900));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 84, 327, 205);
		add(scrollPane_1);
		tableBusqueda = new JTable();
		scrollPane_1.setViewportView(tableBusqueda);
	
		tableBusqueda.setRowSelectionAllowed(false);
		tableBusqueda.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "DESTINO", "PRECIO", "FECHA", "ORIGEN"},
			},
			new String[] {
				"ID", "Destino", "Precio", "Fecha", "origen"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		DefaultTableModel modeloViajes = (DefaultTableModel) tableBusqueda.getModel();
		
		
		tableBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				actualizarListado();
				btnComprar.setVisible(true);
				//listado.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 84, 407, 205);
		add(scrollPane);
		
		tableMisViajes = new JTable();
		scrollPane.setViewportView(tableMisViajes);
		tableMisViajes.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "ASIENTO", "USUARIO", "DESTINO", "PRECIO", "ORIGEN", "FECHA"},
			},
			new String[] {
				"Id", "Asiento", "Usuario", "Destino", "Precio", "Origen", "Fecha"
			}
		));
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(textField.getText().isEmpty()) {
					System.out.println("NO SE INGRESO NADA U8SER");
					actualizarCompras();

				}else {
				String buskeda = textField.getText();
				String[] titulos = {"Id", "Destino", "Precio", "Fecha", "Origen"};
				
				ArrayList<Viaje> busquedaFiltrada = daoViajes.buscarDestino(buskeda);
				
				DefaultTableModel modeloBusqueda = (DefaultTableModel) tableBusqueda.getModel();
				modeloBusqueda.setRowCount(0);
				
				model = new DefaultTableModel(null, titulos);
				

				for(Viaje v : busquedaFiltrada) {//Se recorre el array debido a q paso de estar en el dao a en la interfaz
					
					String id = String.valueOf(v.getId());
					String destino = v.getDestino();
					String precio = String.valueOf(v.getPrecio());
					String dia = String.valueOf(v.getFecha());
					String origen = v.getOrigen();
					
					String[] filaString = new String[5];
					filaString[0] = id;
					filaString[1] = destino;
					filaString[2]=precio;
					filaString[3]=dia;
					filaString[4]=origen;
					
					System.out.println("fila del modelo: "+filaString[1]);
					modeloBusqueda.addRow(filaString);
				}
				
				tableBusqueda.setModel(modeloBusqueda);
					}
				
			}
			
		});
		JLabel lblMisViajes = new JLabel("Mis viajes");
		lblMisViajes.setBounds(431, 59, 46, 14);
		add(lblMisViajes);
		textField.setBounds(35, 53, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		listado = new JComboBox<Integer>();
		listado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//btnComprar.setVisible(true);
			}
		});
		listado.setBounds(20, 300, 113, 20);
		add(listado);
		

		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				misCostosTotales(userActualoide, lblCosto);
				
				int opcion = JOptionPane.showConfirmDialog(null, "Realmente desea comprar el pasaje?", "Confirmar compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(opcion == JOptionPane.YES_OPTION) {
				
				int coso = tableBusqueda.getSelectedRow();
				Object valorUno = tableBusqueda.getValueAt(coso, 0);
				String idloco = String.valueOf(valorUno);
				System.out.println("user: "+userActualoide.getId());
				int id = 0;
				Pasaje p = new Pasaje(id,userActualoide.getId(), Integer.parseInt(idloco), (int)listado.getSelectedItem());
				
				daoPasajes.agregarPasaje(p);
				daoPasajes.comprar((int) listado.getSelectedItem());
				actualizarListado();
				actualizarMisViajes(userActualoide);
				JOptionPane.showMessageDialog(null, "Compra realizada con exito", "COMPRA CONFIRMADA", JOptionPane.OK_CANCEL_OPTION);
				}else {
					JOptionPane.showMessageDialog(null, "Compra cancelada", "CANCELADA", JOptionPane.OK_OPTION);

				}
				
			}
		});
		btnComprar.setBounds(234, 51, 91, 20);
		add(btnComprar);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(131, 50, 91, 23);
		add(btnRefresh);
		
		JButton btnEliminar = new JButton("Cancelar pasaje");
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				misCostosTotales(userActualoide, lblCosto);
				int opcion = JOptionPane.showConfirmDialog(null, "Realmente desea cancelar este pasaje?", "CANCELAR PASAJE", JOptionPane.YES_NO_OPTION, JOptionPane.CANCEL_OPTION);
				if(opcion == JOptionPane.YES_OPTION) {
				int coso = tableMisViajes.getSelectedRow();
				Object aidi = tableMisViajes.getValueAt(coso, 0);
				ArrayList<Pasaje> pasajes = daoPasajes.obtenerPasajes();
				for(Pasaje p : pasajes) {
					if(p.getId()== (int)aidi) {
						daoPasajes.eliminarPasaje(p);
						actualizarMisViajes(userActualoide);
						actualizarListado();
					}
				}
				
			}
			}
		});
		btnEliminar.setBounds(441, 299, 173, 23);
		add(btnEliminar);
		
		lblNewLabel = new JLabel("Hola: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 122, 28);
		add(lblNewLabel);
		
		JLabel lblCostoTotal = new JLabel("Costo total:");
		lblCostoTotal.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCostoTotal.setBounds(365, 367, 129, 28);
		add(lblCostoTotal);
		
		lblCosto = new JLabel("0");
		lblCosto.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCosto.setBounds(506, 367, 156, 28);
		add(lblCosto);
		
		lblNewLabel.setText("Hola: "+userActualoide.getUser());
		/*btnComprar.setVisible(false);
		listado.setVisible(false);*/
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel modelCompras = (DefaultTableModel) tableMisViajes.getModel();

				actualizarCompras();
				
				modelCompras.setRowCount(1);
				String destinoide = "";
				String nombreUser ="";
				actualizarMisViajes(userActualoide);
				misCostosTotales(userActualoide, lblCosto);
			}
		});
		btnComprar.setVisible(false);

	}
	
}
	


	
