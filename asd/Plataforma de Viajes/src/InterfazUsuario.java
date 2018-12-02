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
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.xml.internal.ws.api.Component;

import javafx.scene.control.ComboBox;

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
	private JTable tableBusqueda;
	private JButton btnRefresh;
	private JTable tableMisViajes;
	/**
	 * Create the panel.
	 */
	
	private JTextField textField;
	private JComboBox<Integer> listado;
	private JButton btnComprar;
	private JLabel lblNewLabel;
	private JLabel lblAsiento;
	
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
		int idloco = (int) tableBusqueda.getValueAt(coso, 0);
		System.out.println("id viajesoide"+idloco);
		ArrayList<Asiento> asientoides = daoAsiento.obtenerTodosLosAsientos(idloco);
		for(Asiento a : asientoides) {
			if(a.isDisponible()) {
			listado.addItem(a.getId());
			}
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
		tableBusqueda = new JTable();
	
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
		tableBusqueda.setBounds(10, 84, 327, 205);
		add(tableBusqueda);
		
		tableMisViajes = new JTable();
		tableMisViajes.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "ASIENTO", "USUARIO", "DESTINO", "PRECIO", "ORIGEN", "FECHA"},
			},
			new String[] {
				"Id", "Asiento", "Usuario", "Destino", "Precio", "Origen", "Fecha"
			}
		));
		tableMisViajes.setBounds(365, 84, 407, 205);
		add(tableMisViajes);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(textField.getText().isEmpty()) {
					System.out.println("NO SE INGRESO NADA U8SER");
					actualizarCompras();

				}else {
				String buskeda = textField.getText();
				DefaultTableModel asd = daoViajes.buscarDestino( tableBusqueda, buskeda);
				tableBusqueda.setModel(asd);
					}
				
			}
			
		});
		JLabel lblMisViajes = new JLabel("Mis viajes");
		lblMisViajes.setBounds(365, 59, 112, 14);
		add(lblMisViajes);
		
		
		DefaultTableModel modeloViajes = (DefaultTableModel) tableBusqueda.getModel();
		
		
		tableBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				actualizarListado();
				//listado.setVisible(true);
			}
		});
		textField.setBounds(10, 53, 212, 20);
		add(textField);
		textField.setColumns(10);
		
		listado = new JComboBox<Integer>();
		listado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//btnComprar.setVisible(true);
			}
		});
		listado.setBounds(109, 300, 113, 20);
		add(listado);
		

		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int coso = tableBusqueda.getSelectedRow();
				Object valorUno = tableBusqueda.getValueAt(coso, 0);
				int idloco = (int) valorUno;
				System.out.println("user: "+userActualoide.getId());
				int id = 0;
				Pasaje p = new Pasaje(id,userActualoide.getId(), idloco, (int)listado.getSelectedItem());
				
				daoPasajes.agregarPasaje(p);
				daoPasajes.comprar((int) listado.getSelectedItem());
				actualizarListado();
				actualizarMisViajes(userActualoide);

				
			}
		});
		btnComprar.setBounds(246, 299, 91, 23);
		add(btnComprar);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(246, 52, 91, 23);
		add(btnRefresh);
		
		JButton btnEliminar = new JButton("Cancelar pasaje");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		btnEliminar.setBounds(441, 299, 173, 23);
		add(btnEliminar);
		
		lblNewLabel = new JLabel("Hola: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 122, 28);
		add(lblNewLabel);
		
		lblNewLabel.setText("Hola: "+userActualoide.getUser());
		
		lblAsiento = new JLabel("Asiento");
		lblAsiento.setBounds(10, 303, 75, 14);
		add(lblAsiento);
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
			}
		});
		
	}
}
	


	
