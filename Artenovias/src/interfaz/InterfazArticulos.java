package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Empresa;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.DaoArticulo;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InterfazArticulos extends JPanel {
	private JTable table;
	private JTextField textFieldDescripcion;
	private JTextField textFieldLugar;
	private Empresa empresa;
	private int ultimaSeleccion = 1;

	/**
	 * Create the panel.
	 */
	public InterfazArticulos(JFrame frame, Empresa empresa) {
		setLayout(null);
		this.empresa = empresa;
		
		//Paneles
		JPanel panelEdicion = new JPanel();
		panelEdicion.setBounds(419, 58, 141, 179);
		add(panelEdicion);
		panelEdicion.setLayout(null);
		panelEdicion.setVisible(false);
		
		JPanel panelLista = new JPanel();
		panelLista.setBounds(141, 58, 268, 179);
		add(panelLista);
		panelLista.setLayout(null);
		
		JPanel panelAgregar = new JPanel();
		panelAgregar.setBounds(141, 58, 268, 179);
		add(panelAgregar);
		panelAgregar.setLayout(null);
		panelAgregar.setVisible(false);
		
		
		//Botones
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(22, 72, 89, 23);
		add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(10, 11, 121, 23);
		panelEdicion.add(btnEditar);
		
		JButton buttonAgregarCantidad = new JButton("+");
		buttonAgregarCantidad.setBounds(10, 45, 41, 24);
		panelEdicion.add(buttonAgregarCantidad);
		
		JButton buttonSacarCantidad = new JButton("-");
		buttonSacarCantidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonSacarCantidad.setBounds(10, 79, 41, 24);
		panelEdicion.add(buttonSacarCantidad);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(161, 126, 97, 23);
		panelAgregar.add(btnConfirmar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 126, 89, 23);
		panelAgregar.add(btnAtras);
		
		JButton btnConfirmarEditar = new JButton("Confirmar");
		btnConfirmarEditar.setBounds(161, 126, 97, 23);
		panelAgregar.add(btnConfirmarEditar);
		btnConfirmarEditar.setVisible(false);
		
		JButton btnAtrasInterfaz = new JButton("Atras");
		btnAtrasInterfaz.setBounds(22, 203, 89, 23);
		add(btnAtrasInterfaz);
		
		//Spinner
		JSpinner spinnerCantidadAgregar = new JSpinner();
		spinnerCantidadAgregar.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinnerCantidadAgregar.setBounds(61, 45, 70, 23);
		panelEdicion.add(spinnerCantidadAgregar);
		
		JSpinner spinnerCantidadSacar = new JSpinner();
		spinnerCantidadSacar.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinnerCantidadSacar.setBounds(61, 79, 70, 23);
		panelEdicion.add(spinnerCantidadSacar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(10, 145, 121, 23);
		panelEdicion.add(btnBorrar);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(85, 60, 173, 20);
		panelAgregar.add(spinnerCantidad);
		
		//Label
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 38, 84, 14);
		panelAgregar.add(lblDescripcion);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 63, 84, 14);
		panelAgregar.add(lblCantidad);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 88, 84, 14);
		panelAgregar.add(lblLugar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 268, 179);
		panelLista.add(scrollPane);
		
		//TextField
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(85, 35, 173, 20);
		panelAgregar.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldLugar = new JTextField();
		textFieldLugar.setBounds(85, 85, 173, 20);
		panelAgregar.add(textFieldLugar);
		textFieldLugar.setColumns(10);
		
		//Tabla
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Descripcion", "Cantidad", "Lugar"
			}
		));
		scrollPane.setViewportView(table);
		
		table.setModel(actualizarLista(table.getModel()));
		
		//Atras Interfaz
		btnAtrasInterfaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazEmpresa(frame,empresa));
				frame.setVisible(true);
			}
		});
		//Agregar
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLista.setVisible(false);
				panelAgregar.setVisible(true);
				panelEdicion.setVisible(false);
				btnConfirmarEditar.setVisible(false);
				btnConfirmar.setVisible(true);
			}
		});
		//Borrar Articulo
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empresa.borrarArticulo((int)table.getValueAt(table.getSelectedRow(), 0));
				table.setModel(actualizarLista(table.getModel()));
				//TODO boton de confirmar
			}
		});
		//Editar Articulo
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregar.setVisible(true);
				panelEdicion.setVisible(false);
				panelLista.setVisible(false);
				btnConfirmar.setVisible(false);
				btnConfirmarEditar.setVisible(true);
				DaoArticulo daoArticulo = new DaoArticulo();
				Articulo articulo = daoArticulo.devolverArticulo(ultimaSeleccion);
				textFieldDescripcion.setText(articulo.getDescripcion());
				textFieldLugar.setText(articulo.getLugar());
				spinnerCantidad.setValue(articulo.getCantidad());
			}
		});
		//Confirmar Edicion
		btnConfirmarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empresa.editarArticulo(new Articulo(ultimaSeleccion,(int)spinnerCantidad.getValue(),textFieldDescripcion.getText(),textFieldLugar.getText()));
				panelLista.setVisible(true);
				panelEdicion.setVisible(false);
				panelAgregar.setVisible(false);
				table.setModel(actualizarLista(table.getModel()));
				textFieldDescripcion.setText("");
				textFieldLugar.setText("");
				spinnerCantidad.setValue(1);
			}
		});
		//Confirmar Agregar
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((int) spinnerCantidad.getValue() > 0 && !textFieldDescripcion.getText().isEmpty() && !textFieldLugar.getText().isEmpty()) {
					empresa.agregarArticulo(new Articulo(0,(int) spinnerCantidad.getValue(),textFieldDescripcion.getText(),textFieldLugar.getText()));
					panelLista.setVisible(true);
					panelAgregar.setVisible(false);
					table.setModel(actualizarLista(table.getModel()));
					textFieldDescripcion.setText("");
					textFieldLugar.setText("");
					spinnerCantidad.setValue(1);
					//TODO agregar msj para confirmar o para mostrar que no se anidio
				}
			}
		});
		//Atras Agregar
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmar.setVisible(true);
				btnConfirmarEditar.setVisible(false);
				panelLista.setVisible(true);
				panelAgregar.setVisible(false);
				textFieldDescripcion.setText("");
				textFieldLugar.setText("");
				spinnerCantidad.setValue(1);
				
			}
		});
		//seleccion de una fila de la lista
		ListSelectionModel modeloSeleccion = table.getSelectionModel();
		modeloSeleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloSeleccion.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				panelEdicion.setVisible(true);
	        	System.out.println("Seleccion de fila");
	        	try {
	        		ultimaSeleccion = (int) table.getValueAt(table.getSelectedRow(), 0);
	        	}catch(ArrayIndexOutOfBoundsException s) {
	        		//s.printStackTrace();
	        		//TODO aca hay un problema raro
	        		//cuando se usan los botones de sumar y restar por alguna razon entra a este codigo
	        		//y tira un error por eso el try
	        	}
			}
		});
		//Restar
		buttonSacarCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoArticulo daoArticulo = new DaoArticulo();
				System.out.println(ultimaSeleccion);
				Articulo articulo = daoArticulo.devolverArticulo(ultimaSeleccion);
				int cantidad;
				cantidad = articulo.getCantidad();
				if(cantidad - (int) spinnerCantidadSacar.getValue() >= 0){
					cantidad = cantidad - (int) spinnerCantidadSacar.getValue();
					articulo.setCantidad(cantidad);
					empresa.editarArticulo(articulo);
				}
				table.setModel(actualizarLista(table.getModel()));
			}
		});
		//Sumar
		buttonAgregarCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoArticulo daoArticulo = new DaoArticulo();
				Articulo articulo = daoArticulo.devolverArticulo(ultimaSeleccion);
				int cantidad;
				cantidad = articulo.getCantidad();
				cantidad = cantidad + (int) spinnerCantidadAgregar.getValue();
				articulo.setCantidad(cantidad);
				empresa.editarArticulo(articulo);
				
				table.setModel(actualizarLista(table.getModel()));
			}
		});

	}
	
	private DefaultTableModel actualizarLista(TableModel modelo) {
			DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
			modeloSolucion.setRowCount(0);
			for(Articulo articulo : empresa.getArticulos()) {
				Object[] linea = {articulo.getId(),articulo.getDescripcion(),articulo.getCantidad(),articulo.getLugar()};
				modeloSolucion.addRow(linea);
				}
			return modeloSolucion;
	}
}
