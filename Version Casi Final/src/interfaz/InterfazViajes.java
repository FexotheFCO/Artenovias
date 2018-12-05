package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAOviajes;

import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import datechooser.beans.DateChooserCombo;
import modelo.Cliente;
import modelo.Viaje;
import javax.swing.JTable;

public class InterfazViajes extends JPanel {
	private JTextField txtDestino;
	private JTextField txtFieldOrigen;
	private JTable tableViajes;

	public InterfazViajes(JFrame frame, Cliente admin) {
		setLayout(null);
		DAOviajes daoViaje = new DAOviajes();
		
		
		JButton btnRefreshViajes = new JButton("Referesh");
		btnRefreshViajes.setBounds(485, 26, 89, 23);
		add(btnRefreshViajes);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(66, 201, 89, 23);
		add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(274, 26, 89, 23);
		add(btnBorrar);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(10, 81, 70, 14);
		add(lblDestino);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 106, 70, 14);
		add(lblPrecio);
		
		JLabel lblPasajeros = new JLabel("Pasajeros");
		lblPasajeros.setBounds(10, 131, 70, 14);
		add(lblPasajeros);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 158, 70, 14);
		add(lblFecha);
		
		txtDestino = new JTextField();
		txtDestino.setColumns(10);
		txtDestino.setBounds(86, 78, 155, 20);
		add(txtDestino);
		
		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setBounds(85, 103, 156, 20);
		add(spinnerPrecio);
		
		JSpinner spinnerPasajeros = new JSpinner();
		spinnerPasajeros.setBounds(85, 128, 156, 20);
		add(spinnerPasajeros);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 63, 300, 202);
		add(scrollPane);
		
		tableViajes = new JTable();
		tableViajes.setBounds(253, 49, 290, 205);
		tableViajes.setRowSelectionAllowed(false);
		tableViajes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Origen", "Precio", "Fecha", "Destino"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableViajes);
		
		
		
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		dateChooserCombo.setBounds(86, 158, 155, 22);
		add(dateChooserCombo);
		
		JLabel label_4 = new JLabel("Origen");
		label_4.setBounds(10, 52, 70, 16);
		add(label_4);
		
		txtFieldOrigen = new JTextField();
		txtFieldOrigen.setColumns(10);
		txtFieldOrigen.setBounds(86, 49, 155, 22);
		add(txtFieldOrigen);
		
		JButton button_3 = new JButton("Editar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int caca = tableViajes.getSelectedRow();
				Object valor = tableViajes.getValueAt(caca, 0);
				frame.setContentPane(new InterfazEditarViaje(frame,daoViaje.devolverViaje((int)valor), admin));
				frame.setVisible(true);
				frame.setBounds(0, 0, 400, 200);
				
			}
		});
		button_3.setBounds(373, 26, 89, 23);
		add(button_3);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new InterfazMenuAdmin(frame,admin));
				frame.setVisible(true);
				frame.setBounds(0, 0, 400, 200);
			}
		});
		btnAtras.setBounds(66, 235, 89, 23);
		add(btnAtras);
		

		//Borrar Viaje
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modeloViajes = (DefaultTableModel) tableViajes.getModel();
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
			}
		);
		
		//Ver Lista Viajes
		btnRefreshViajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOviajes daoViaje = new DAOviajes();
				DefaultTableModel modeloViajes = (DefaultTableModel) tableViajes.getModel();
				modeloViajes.setRowCount(0);
				for(Viaje v : daoViaje.obtenerTodosLosViajes()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
					Object[] linea = {v.getId(),v.getDestino(),v.getPrecio(),v.getFecha().format(formatter),v.getOrigen()};
					modeloViajes.addRow(linea);
					tableViajes.setModel(modeloViajes);
					}
				}
			}
		);

	}
}
