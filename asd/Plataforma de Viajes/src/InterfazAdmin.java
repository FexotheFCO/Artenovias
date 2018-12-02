import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.Panel;
import datechooser.beans.DateChooserCombo;
import java.awt.Font;
import javax.swing.SwingConstants;

public class InterfazAdmin extends JPanel {
	private JTextField txtDestino;
	private JTable table;
	private JTable tableViajes;
	private JTextField textUsuario;
	private JTable tableUsuarios;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtFieldOrigen;

	/**
	 * Create the panel.
	 */
	
	public InterfazAdmin(JFrame frame) {
		frame.setBounds(0,0,580,610);
		setBackground(new Color(102, 102, 102));
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBounds(10, 344, 228, 195);
		add(panel);
		panel.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar Admin");
		btnRegistrar.setBounds(51, 150, 117, 23);
		panel.add(btnRegistrar);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(101, 35, 117, 20);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(20, 38, 46, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(20, 83, 56, 14);
		panel.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(101, 80, 117, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(101, 111, 117, 20);
		panel.add(passwordField_1);
		
		JLabel lblConfirmar = new JLabel("Confirmar");
		lblConfirmar.setBounds(20, 114, 62, 14);
		panel.add(lblConfirmar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(235, 344, 328, 195);
		add(panel_1);
		panel_1.setLayout(null);
		
		tableUsuarios = new JTable();
		tableUsuarios.setBounds(20, 11, 124, 170);
		panel_1.add(tableUsuarios);
		tableUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Usuario"
			}
		));
		
		DefaultTableModel modeloUsuario = (DefaultTableModel) tableUsuarios.getModel();
		DAOUsuario daoUsuario = new DAOUsuario();
		DAOviajes daoViaje = new DAOviajes();
		
		JButton btnBorrarUsuario = new JButton("Borrar");
		btnBorrarUsuario.setBounds(180, 100, 91, 26);
		panel_1.add(btnBorrarUsuario);
		
		JButton btnRefreshUsuario = new JButton("Refresh");
		btnRefreshUsuario.setBounds(180, 66, 91, 23);
		panel_1.add(btnRefreshUsuario);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuarios.setBounds(10, 304, 95, 34);
		add(lblUsuarios);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(10, 33, 553, 265);
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(68, 213, 89, 23);
		panel_2.add(btnAgregar);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(10, 103, 46, 14);
		panel_2.add(lblDestino);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 128, 46, 14);
		panel_2.add(lblPrecio);
		
		JLabel lblPasajeros = new JLabel("Pasajeros");
		lblPasajeros.setBounds(10, 153, 65, 14);
		panel_2.add(lblPasajeros);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 180, 46, 14);
		panel_2.add(lblFecha);
		
		txtDestino = new JTextField();
		txtDestino.setBounds(86, 100, 155, 20);
		panel_2.add(txtDestino);
		txtDestino.setColumns(10);
		
		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setBounds(86, 125, 155, 20);
		panel_2.add(spinnerPrecio);
		
		JSpinner spinnerPasajeros = new JSpinner();
		spinnerPasajeros.setBounds(85, 150, 156, 20);
		panel_2.add(spinnerPasajeros);
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		dateChooserCombo.setBounds(86, 180, 155, 22);
		panel_2.add(dateChooserCombo);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(10, 74, 56, 16);
		panel_2.add(lblOrigen);
		
		txtFieldOrigen = new JTextField();
		txtFieldOrigen.setBounds(86, 71, 155, 22);
		panel_2.add(txtFieldOrigen);
		txtFieldOrigen.setColumns(10);
		
		tableViajes = new JTable();
		tableViajes.setBounds(253, 49, 290, 205);
		panel_2.add(tableViajes);
		tableViajes.setRowSelectionAllowed(false);
		tableViajes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id","Origen", "Destino", "Precio", "Fecha"
			}	
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(253, 15, 89, 23);
		panel_2.add(btnBorrar);
		
		JButton btnRefreshViajes = new JButton("Referesh");
		btnRefreshViajes.setBounds(454, 15, 89, 23);
		panel_2.add(btnRefreshViajes);
		
		JLabel lblViajes = new JLabel("Viajes");
		lblViajes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblViajes.setBounds(22, 19, 65, 19);
		panel_2.add(lblViajes);
		
		DefaultTableModel modeloViajes = (DefaultTableModel) tableViajes.getModel();
		
		//Ver Lista Viajes
		btnRefreshViajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloViajes.setRowCount(0);
				for(Viaje v : daoViaje.obtenerTodosLosViajes()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
					Object[] linea = {v.getId(),v.getDestino(),v.getPrecio(),v.getFecha().format(formatter),v.getOrigen()};
					modeloViajes.addRow(linea);
					tableViajes.setModel(modeloViajes);
				}
			}
		});
		
		
		
		//Borrar Viaje
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int caca = tableViajes.getSelectedRow();
				Object valor = tableViajes.getValueAt(caca, 0);
				daoViaje.borrarViaje((int) valor);
				modeloViajes.removeRow(caca);
				tableViajes.setModel(modeloViajes);
			}
		});

		
			//Agregar Viaje
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					double precio = (Integer) spinnerPrecio.getValue();
					int pasajeros = (Integer) spinnerPasajeros.getValue();
					LocalDate fecha =  dateChooserCombo.getSelectedDate().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					int id = 0;//POSIBLE PROBLEMA CONSULTAR CON TORCHIA
					if(txtDestino.getText() != null && precio > 0 && pasajeros > 0) {
						DAOviajes dao = new DAOviajes();
						dao.agregarViaje(new Viaje(id,txtDestino.getText(), precio,txtFieldOrigen.getText(), pasajeros, fecha));
					}
				}
			});
		
		//Ver Lista Usuario
		btnRefreshUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloUsuario.setRowCount(0);
				for(Cliente u : daoUsuario.obtenerTodosLosUsuarios()) {
					Object[] linea = {u.getId(),u.getUser(),u.getPassword()};
					modeloUsuario.addRow(linea);
					tableUsuarios.setModel(modeloUsuario);
				}
			}
		});
		
		//Borrar Usuario
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int caca = tableUsuarios.getSelectedRow();
				Object valor = tableUsuarios.getValueAt(caca, 0);
				daoUsuario.borrarUsuario((int) valor);
				modeloUsuario.removeRow(caca);
				tableUsuarios.setModel(modeloUsuario);
			}
		});
		
		
		//Registrar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textUsuario.getText();
				String password = String.valueOf(passwordField.getPassword());
				String password2 = String.valueOf(passwordField_1.getPassword());
				String passEncriptada = DigestUtils.md5Hex(password);
				//System.out.println(!usuario.isEmpty());
				//System.out.println(!password.isEmpty());
				System.out.println(password.equals(password2));
				if(!usuario.isEmpty() && !password.isEmpty() && password.equals(password2)) {
					System.out.println("entre");
					int id = 0;
					int tipo = 1;
					daoUsuario.agregarUser(new Usuario(id,usuario,passEncriptada,1));
				}
			}
		});
			
		
	}
}
