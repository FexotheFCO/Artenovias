package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.ArtDisponible;
import modelo.Articulo;
import modelo.Compra;
import modelo.Empresa;
import javax.swing.JScrollPane;
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

public class InterfazArticulos extends JPanel {
	private JTable tableArticulos;
	private JTextField textFieldDescripcion;
	private JTextField textFieldLugar;
	private Empresa empresa;
	private int ultimaSeleccion = 1;
	private int ultimaSeleccionCompra = 1;
	private JTable tableCompras;

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
		
		JPanel panelAgregarArticulo = new JPanel();
		panelAgregarArticulo.setBounds(141, 58, 268, 179);
		add(panelAgregarArticulo);
		panelAgregarArticulo.setLayout(null);
		panelAgregarArticulo.setVisible(false);
		
		JPanel panelLista = new JPanel();
		panelLista.setBounds(141, 58, 268, 179);
		add(panelLista);
		panelLista.setLayout(null);
		
		JPanel panelAgregarCompra = new JPanel();
		panelAgregarCompra.setBounds(141, 58, 268, 179);
		add(panelAgregarCompra);
		panelAgregarCompra.setLayout(null);
		panelAgregarCompra.setVisible(false);
		
		JPanel panelCompras = new JPanel();
		panelCompras.setBounds(141, 248, 268, 179);
		add(panelCompras);
		panelCompras.setLayout(null);
		
		JPanel panelBorrarCompra = new JPanel();
		panelBorrarCompra.setBounds(419, 248, 141, 179);
		add(panelBorrarCompra);
		panelBorrarCompra.setLayout(null);
		panelBorrarCompra.setVisible(false);
		
		//TextField
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(85, 35, 173, 20);
		panelAgregarArticulo.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldLugar = new JTextField();
		textFieldLugar.setBounds(85, 85, 173, 20);
		panelAgregarArticulo.add(textFieldLugar);
		textFieldLugar.setColumns(10);
		
		//Label
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 38, 84, 14);
		panelAgregarArticulo.add(lblDescripcion);
				
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 63, 84, 14);
		panelAgregarArticulo.add(lblCantidad);
				
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 88, 84, 14);
		panelAgregarArticulo.add(lblLugar);
				
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setBounds(10, 14, 46, 14);
		panelAgregarCompra.add(lblMonto);
				
		JLabel lblCantidad_1 = new JLabel("Cantidad");
		lblCantidad_1.setBounds(10, 45, 46, 14);
		panelAgregarCompra.add(lblCantidad_1);
		
		//Botones
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(22, 72, 89, 23);
		add(btnAgregar);
		
		JButton btnAgregarCompraABM = new JButton("Agregar Compra");
		btnAgregarCompraABM.setBounds(73, 95, 111, 23);
		panelAgregarCompra.add(btnAgregarCompraABM);
		
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
		
		JButton btnAtrasInterfaz = new JButton("Atras");
		btnAtrasInterfaz.setBounds(22, 203, 89, 23);
		add(btnAtrasInterfaz);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(10, 145, 121, 23);
		panelEdicion.add(btnBorrar);
		
		JButton btnAgregarCompra = new JButton("Agregar Compra");
		btnAgregarCompra.setBounds(10, 114, 121, 23);
		panelEdicion.add(btnAgregarCompra);
		
		JButton btnAtrasCompra = new JButton("Atras");
		btnAtrasCompra.setBounds(73, 129, 111, 23);
		panelAgregarCompra.add(btnAtrasCompra);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(161, 126, 97, 23);
		panelAgregarArticulo.add(btnConfirmar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 126, 89, 23);
		panelAgregarArticulo.add(btnAtras);
		
		JButton btnConfirmarEditar = new JButton("Confirmar");
		btnConfirmarEditar.setBounds(161, 126, 97, 23);
		panelAgregarArticulo.add(btnConfirmarEditar);
		btnConfirmarEditar.setVisible(false);
		
		JButton btnBorrarCompra = new JButton("Borrar");
		btnBorrarCompra.setBounds(10, 11, 121, 23);
		panelBorrarCompra.add(btnBorrarCompra);
		
		//Spinner
		JSpinner spinnerCantidadAgregar = new JSpinner();
		spinnerCantidadAgregar.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinnerCantidadAgregar.setBounds(61, 45, 70, 23);
		panelEdicion.add(spinnerCantidadAgregar);
		
		JSpinner spinnerCantidadSacar = new JSpinner();
		spinnerCantidadSacar.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinnerCantidadSacar.setBounds(61, 79, 70, 23);
		panelEdicion.add(spinnerCantidadSacar);
		
		JSpinner spinnerCantidadCompra = new JSpinner();
		spinnerCantidadCompra.setBounds(126, 42, 132, 20);
		panelAgregarCompra.add(spinnerCantidadCompra);
		
		JSpinner spinnerMonto = new JSpinner();
		spinnerMonto.setBounds(126, 11, 132, 20);
		panelAgregarCompra.add(spinnerMonto);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(85, 60, 173, 20);
		panelAgregarArticulo.add(spinnerCantidad);
		
		//Scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 268, 179);
		panelLista.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 268, 179);
		panelCompras.add(scrollPane_1);
		
		//Tabla
		tableArticulos = new JTable();
		tableArticulos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Descripcion", "Cantidad", "Lugar"
			}
		){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }});
		scrollPane.setViewportView(tableArticulos);
		tableArticulos.setModel(actualizarListaArticulos(tableArticulos.getModel()));
		
		tableCompras = new JTable();
		tableCompras.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Articulo", "Cantidad", "Monto", "Fecha"
			}
		));
		scrollPane_1.setViewportView(tableCompras);
		//tableCompras.setModel(actualizarListaCompras(tableCompras.getModel()));
		
		//Atras Interfaz
		btnAtrasInterfaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazMenu(frame,empresa));
				frame.setVisible(true);
			}
		});
		//Agregar
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLista.setVisible(false);
				panelAgregarArticulo.setVisible(true);
				panelEdicion.setVisible(false);
				btnConfirmarEditar.setVisible(false);
				btnConfirmar.setVisible(true);
			}
		});
		//Borrar Articulo TODO replantear si hay que borrar articulos por el tema de que tienen compras asignadas a ellos.
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empresa.borrarArticulo((int)tableArticulos.getValueAt(tableArticulos.getSelectedRow(), 0));
				tableArticulos.setModel(actualizarListaArticulos(tableArticulos.getModel()));
				//TODO boton de confirmar
			}
		});
		//Editar Articulo
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregarArticulo.setVisible(true);
				panelEdicion.setVisible(false);
				panelLista.setVisible(false);
				btnConfirmar.setVisible(false);
				btnConfirmarEditar.setVisible(true);
				DaoArticulo daoArticulo = new DaoArticulo();
				ArtDisponible articulo = daoArticulo.devolverArticuloDisponible(ultimaSeleccion);
				textFieldDescripcion.setText(articulo.getDescripcion());
				textFieldLugar.setText(articulo.getLugar());
				spinnerCantidad.setValue(articulo.getCantidad());
			}
		});
		//seleccion de una fila de la lista
		ListSelectionModel modeloSeleccion = tableArticulos.getSelectionModel();
		modeloSeleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloSeleccion.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				panelEdicion.setVisible(true);
	        	try {
	        		ultimaSeleccion = (int) tableArticulos.getValueAt(tableArticulos.getSelectedRow(), 0);
	        		tableCompras.setModel(actualizarListaCompras(tableCompras.getModel(),ultimaSeleccion));
	        	}catch(ArrayIndexOutOfBoundsException s) {
	        		//s.printStackTrace();
	        		//TODO aca hay un problema raro
	        		//cuando se usan los botones de sumar y restar por alguna razon entra a este codigo
	        		//y tira un error por eso el try
	        	}
			}
		});
		ListSelectionModel modeloSeleccionCompras = tableCompras.getSelectionModel();
		modeloSeleccionCompras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloSeleccionCompras.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				panelBorrarCompra.setVisible(true);
	        	try {
	        		ultimaSeleccionCompra = (int) tableCompras.getValueAt(tableCompras.getSelectedRow(), 0);
	        	}catch(ArrayIndexOutOfBoundsException s) {
	        		//s.printStackTrace();
	        		//cuando se usan los botones de sumar y restar por alguna razon entra a este codigo
	        		//y tira un error por eso el try
	        	}
			}
		});
		//Restar
		buttonSacarCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtDisponible articuloSolucion = null;
				System.out.println(ultimaSeleccion);
				for(ArtDisponible articulo : empresa.getArticulos()) {
					if(articulo.getId() == ultimaSeleccion) {
						int cantidad;
						cantidad = articulo.getCantidad();
						if(cantidad - (int) spinnerCantidadSacar.getValue() >= 0){
							cantidad = cantidad - (int) spinnerCantidadSacar.getValue();
							articulo.setCantidad(cantidad);
							articuloSolucion = articulo;
						}
					}
				}
				empresa.editarArticulo(articuloSolucion);
				tableArticulos.setModel(actualizarListaArticulos(tableArticulos.getModel()));
			}
		});
		//Sumar
		buttonAgregarCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtDisponible articuloSolucion = null;
				for(ArtDisponible articulo : empresa.getArticulos()) {
					if(articulo.getId() == ultimaSeleccion) {
						int cantidad;
						cantidad = articulo.getCantidad();
						cantidad = cantidad + (int) spinnerCantidadAgregar.getValue();
						articulo.setCantidad(cantidad);
						articuloSolucion = articulo;
					}
				}
				empresa.editarArticulo(articuloSolucion);
				tableArticulos.setModel(actualizarListaArticulos(tableArticulos.getModel()));
			}
		});
		
		//Confirmar Edicion
		btnConfirmarEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empresa.editarArticulo(new ArtDisponible(ultimaSeleccion,(int)spinnerCantidad.getValue(),textFieldDescripcion.getText(),textFieldLugar.getText()));
				panelLista.setVisible(true);
				panelEdicion.setVisible(false);
				panelAgregarArticulo.setVisible(false);
				tableArticulos.setModel(actualizarListaArticulos(tableArticulos.getModel()));
				tableCompras.setModel(actualizarListaCompras(tableCompras.getModel(),ultimaSeleccion));
				textFieldDescripcion.setText("");
				textFieldLugar.setText("");
				spinnerCantidad.setValue(1);
			}
		});
		//Confirmar Agregar
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((int) spinnerCantidad.getValue() >= 0 && !textFieldDescripcion.getText().isEmpty() && !textFieldLugar.getText().isEmpty()) {
					empresa.agregarArticulo(new ArtDisponible(0,(int) spinnerCantidad.getValue(),textFieldDescripcion.getText(),textFieldLugar.getText()));
					panelLista.setVisible(true);
					panelAgregarArticulo.setVisible(false);
					tableArticulos.setModel(actualizarListaArticulos(tableArticulos.getModel()));
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
				panelAgregarArticulo.setVisible(false);
				textFieldDescripcion.setText("");
				textFieldLugar.setText("");
				spinnerCantidad.setValue(1);		
			}
		});
		//Agregar Compra panel agregar pago
		btnAgregarCompraABM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((int) spinnerCantidadCompra.getValue() > 0 && (int) spinnerMonto.getValue() > 0) {
					Compra compra = new Compra(0,(int) spinnerMonto.getValue(),(int) spinnerCantidadCompra.getValue());
					for(Articulo articulo : empresa.getArticulos()) {
						if(articulo.getId() == ultimaSeleccion) {
							articulo.agregarCompra(compra);
							articulo.setCantidad(articulo.getCantidad() + (int) spinnerCantidadCompra.getValue());
						}
					}
					panelLista.setVisible(true);
					panelAgregarCompra.setVisible(false);  
					spinnerCantidadCompra.setValue(0);
					spinnerMonto.setValue(0);
					tableCompras.setModel(actualizarListaCompras(tableCompras.getModel(),ultimaSeleccion));
					tableArticulos.setModel(actualizarListaArticulos(tableArticulos.getModel()));
					//TODO agregar el modelo de la otra lista de compras
				}
			}
		});
		//Borrar compra
		btnBorrarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Articulo articulo : empresa.getArticulos()) {
					if (articulo.getId() == ultimaSeleccion) {
						articulo.borrarCompra(ultimaSeleccionCompra);
						tableCompras.setModel(actualizarListaCompras(tableCompras.getModel(),ultimaSeleccion));
					}
				}
			}
		});
		//Agregar Compra panel Editar
		btnAgregarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLista.setVisible(false);
				panelAgregarCompra.setVisible(true);
			}
		});
		//Atras Panel Compra
		btnAtrasCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLista.setVisible(true);
				panelAgregarCompra.setVisible(false);
				spinnerCantidadCompra.setValue(0);
				spinnerMonto.setValue(0);
			}
		});

	}
	
	private DefaultTableModel actualizarListaArticulos(TableModel modelo) {
			DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
			modeloSolucion.setRowCount(0);
			for(ArtDisponible articulo : empresa.getArticulos()) {
				Object[] linea = {articulo.getId(),articulo.getDescripcion(),articulo.getCantidad(),articulo.getLugar()};
				modeloSolucion.addRow(linea);
				}
			return modeloSolucion;
	}
	
	private DefaultTableModel actualizarListaCompras(TableModel modelo,int articuloId) {
		DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
		modeloSolucion.setRowCount(0);
		for(Articulo articulo : empresa.getArticulos()) {
			if(articulo.getId() == articuloId) {
				for(Compra compra : articulo.getCompras()) {
					Object[] linea = {compra.getId(),articulo.getDescripcion(),compra.getCantidad(),compra.getMonto()};
					//TODO agregar fecha
					modeloSolucion.addRow(linea);
				}
			}
		}
		return modeloSolucion;
	}
}
