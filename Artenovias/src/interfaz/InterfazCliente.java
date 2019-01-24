package interfaz;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dao.DaoCliente;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Pago;
import modelo.Rectificacion;
import modelo.Vestido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultCaret;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;

public class InterfazCliente extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldMail;
    private	DaoCliente daoCliente = new DaoCliente();
    private JTable tableRect;
    private JTable tablePagos;
    private JTextField textFieldDescripcion;
    JLabel labelNumeroFaltante = new JLabel("");
    JLabel lblNumeroPagado = new JLabel("");
    JLabel labelNumeroTotal = new JLabel("");
    
	public InterfazCliente(JFrame frame,Cliente cliente,Empresa empresa) {
		setLayout(null);
		frame.setBounds(0, 0, 260, 400);
		labelNumeroTotal.setText(String.valueOf(cliente.getValorVestido()));
		
		//Panels
		JPanel panelPagos = new JPanel();
		panelPagos.setBounds(374, 11, 327, 287);
		add(panelPagos);
		panelPagos.setLayout(null);
		
		JPanel panelEditar = new JPanel();
		panelEditar.setBounds(93, 62, 139, 238);
		add(panelEditar);
		panelEditar.setLayout(null);
		panelEditar.setVisible(false);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBounds(93, 52, 139, 238);
		add(panelCliente);
		panelCliente.setLayout(null);
		
		JPanel panelAgregarPago = new JPanel();
		panelAgregarPago.setBounds(374, 11, 327, 184);
		add(panelAgregarPago);
		panelAgregarPago.setLayout(null);
		panelAgregarPago.setVisible(false);
		
		JPanel panelRectAgregar = new JPanel();
		panelRectAgregar.setBounds(120, 504, 244, 184);
		add(panelRectAgregar);
		panelRectAgregar.setLayout(null);
		panelRectAgregar.setVisible(false);
		
		
		//ScrolPanel
		JScrollPane scrollPaneListaPagos = new JScrollPane();
		scrollPaneListaPagos.setBounds(10, 11, 307, 136);
		panelPagos.add(scrollPaneListaPagos);
		
		JScrollPane scrollPaneTextoRect = new JScrollPane();
		scrollPaneTextoRect.setBounds(0, 0, 244, 148);
		panelRectAgregar.add(scrollPaneTextoRect);
		scrollPaneTextoRect.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTextoRect.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane scrollPaneListaRect = new JScrollPane();
		scrollPaneListaRect.setBounds(120, 345, 244, 148);
		add(scrollPaneListaRect);
		
		//Areas y Tablas
		JTextArea textArea = new JTextArea("",5,20);
		scrollPaneTextoRect.setViewportView(textArea);
		textArea.setToolTipText("");
		
		//Labels
		//Usuario
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 75, 73, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 100, 73, 14);
		add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 175, 73, 14);
		add(lblTelefono);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 150, 73, 14);
		add(lblMail);
		
		JLabel lblTelefono_1 = new JLabel("Telefono 2");
		lblTelefono_1.setBounds(10, 200, 73, 14);
		add(lblTelefono_1);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 125, 73, 14);
		add(lblEdad);
		
		JLabel lblNombreUser = new JLabel("Nombre");
		lblNombreUser.setBounds(10, 23, 119, 14);
		panelCliente.add(lblNombreUser);
		
		JLabel lblApellidoUser = new JLabel("Apellido");
		lblApellidoUser.setBounds(10, 48, 119, 14);
		panelCliente.add(lblApellidoUser);
		
		JLabel lblTelefonoUser = new JLabel("Telefono");
		lblTelefonoUser.setBounds(10, 123, 119, 14);
		panelCliente.add(lblTelefonoUser);
		
		JLabel lblMailUser = new JLabel("Mail");
		lblMailUser.setBounds(10, 98, 119, 14);
		panelCliente.add(lblMailUser);
		
		JLabel lblTelefono2User = new JLabel("Telefono 2");
		lblTelefono2User.setBounds(10, 148, 119, 14);
		panelCliente.add(lblTelefono2User);
		
		JLabel lblEdadUser = new JLabel("Edad");
		lblEdadUser.setBounds(10, 73, 119, 14);
		panelCliente.add(lblEdadUser);
		
		//Rectificacion
		JLabel lblRectificacion = new JLabel("Rectificacion");
		lblRectificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblRectificacion.setLabelFor(tableRect);
		lblRectificacion.setBounds(120, 320, 244, 14);
		add(lblRectificacion);
		
		//Pagos
		JLabel lblPagado = new JLabel("Pagado");
		lblPagado.setBounds(10, 158, 60, 14);
		panelPagos.add(lblPagado);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(10, 183, 60, 14);
		panelPagos.add(lblTotal);
		
		JLabel lblFaltante = new JLabel("Faltante");
		lblFaltante.setBounds(10, 208, 60, 14);
		panelPagos.add(lblFaltante);
		
		lblNumeroPagado.setBounds(80, 158, 138, 14);
		panelPagos.add(lblNumeroPagado);
		
		labelNumeroTotal.setBounds(80, 183, 138, 14);
		panelPagos.add(labelNumeroTotal);
		
		labelNumeroFaltante.setBounds(80, 208, 138, 14);
		panelPagos.add(labelNumeroFaltante);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(61, 29, 105, 14);
		panelAgregarPago.add(lblDescripcion);
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setBounds(61, 60, 105, 14);
		panelAgregarPago.add(lblMonto);
		
		//SetText de Usuario
		lblNombreUser.setText(cliente.getNombre());
		lblApellidoUser.setText(cliente.getApellido());
		lblTelefonoUser.setText(String.valueOf(cliente.getTelefono()));
		lblTelefono2User.setText(String.valueOf(cliente.getTelefono2()));
		lblMailUser.setText(cliente.getMail());
		lblEdadUser.setText(String.valueOf(cliente.getEdad()));
		
		//Botones
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(33, 173, 73, 23);
		panelCliente.add(btnEdit);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(155, 161, 89, 23);
		panelRectAgregar.add(btnAceptar);
		
		JButton btnCancelarRect = new JButton("Cancelar");
		btnCancelarRect.setBounds(0, 161, 89, 23);
		panelRectAgregar.add(btnCancelarRect);
		
		JButton btnAgregarPago_1 = new JButton("Agregar");
		btnAgregarPago_1.setBounds(114, 98, 89, 23);
		panelAgregarPago.add(btnAgregarPago_1);
		
		JButton btnCancelarPago = new JButton("Cancelar");
		btnCancelarPago.setBounds(114, 132, 89, 23);
		panelAgregarPago.add(btnCancelarPago);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 161, 119, 23);
		panelEditar.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(10, 195, 119, 23);
		panelEditar.add(btnConfirmar);
		
		JButton btnVestido = new JButton("Vestido");
		btnVestido.setBounds(10, 225, 73, 23);
		add(btnVestido);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(10, 11, 89, 23);
		add(btnAtras);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 379, 89, 23);
		add(btnAgregar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(10, 345, 89, 23);
		add(btnMostrar);
		
		JButton btnAgregarPago = new JButton("Agregar");
		btnAgregarPago.setBounds(228, 253, 89, 23);
		panelPagos.add(btnAgregarPago);
		
		JButton btnBorrarPago = new JButton("Borrar");
		btnBorrarPago.setBounds(129, 253, 89, 23);
		panelPagos.add(btnBorrarPago);
		
		JButton btnBorrarRect = new JButton("Borrar");
		btnBorrarRect.setBounds(10, 413, 89, 23);
		add(btnBorrarRect);
		
		//TextField
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(10, 11, 119, 14);
		textFieldNombre.setText(cliente.getNombre());
		panelEditar.add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(10, 36, 119, 14);
		textFieldApellido.setText(cliente.getApellido());
		panelEditar.add(textFieldApellido);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(10, 86, 119, 14);
		textFieldMail.setText(cliente.getMail());
		panelEditar.add(textFieldMail);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(176, 26, 86, 20);
		panelAgregarPago.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		//Spinners
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(10, 61, 119, 14);
		spinnerEdad.setValue((int) cliente.getEdad());
		panelEditar.add(spinnerEdad);
		
		JSpinner spinnerTelefono = new JSpinner();
		spinnerTelefono.setBounds(10, 111, 119, 14);
		spinnerTelefono.setValue((int) cliente.getTelefono());
		panelEditar.add(spinnerTelefono);
		
		JSpinner spinnerTelefono2 = new JSpinner();
		spinnerTelefono2.setBounds(10, 136, 119, 14);
		spinnerTelefono2.setValue((int) cliente.getTelefono2());
		panelEditar.add(spinnerTelefono2);
		
		JSpinner spinnerMonto = new JSpinner();
		spinnerMonto.setBounds(176, 57, 86, 20);
		panelAgregarPago.add(spinnerMonto);
		
		tableRect = new JTable();
		tableRect.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Fecha"
			}
		));
		scrollPaneListaRect.setViewportView(tableRect);
		tableRect.setModel(actualizarTablaRectificaciones(tableRect.getModel(), cliente));
		
		tablePagos = new JTable();
		tablePagos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Descripcion", "Monto", "Fecha"
			}
		) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }});
		tablePagos.getColumnModel().getColumn(0).setPreferredWidth(25);
		tablePagos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablePagos.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPaneListaPagos.setViewportView(tablePagos);
		tablePagos.setModel(actualizarTablaPagos(tablePagos.getModel(), cliente));
		
		//Borrar Pago
		btnBorrarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSelecionada = tablePagos.getSelectedRow();
				Object valor = tablePagos.getValueAt(filaSelecionada, 0);
				cliente.borrarPago((int)valor);
				actualizarTablaPagos(tablePagos.getModel(), cliente);
				//TODO boton para confirmar
			}
		});
		
		//Agregar Pago
		btnAgregarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPagos.setVisible(false);
				panelAgregarPago.setVisible(true);
			}
		});
		
		//Agregar Pago ABM
		btnAgregarPago_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int monto = (int) spinnerMonto.getValue();
				if(!textFieldDescripcion.getText().isEmpty() && monto > 0) {
					Pago pago = new Pago(0, monto, textFieldDescripcion.getText());
					cliente.agregarPago(pago);
					tablePagos.setModel(actualizarTablaPagos(tablePagos.getModel(), cliente));
					panelPagos.setVisible(true);
					panelAgregarPago.setVisible(false);
					textFieldDescripcion.setText(null);
					spinnerMonto.setValue(0);
				}
			}
		});
		
		//Cancelar Pago ABM
		btnCancelarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPagos.setVisible(true);
				panelAgregarPago.setVisible(false);
				textFieldDescripcion.setText(null);
				spinnerMonto.setValue(0);
			}
		});
		
		//Boton Atras
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setContentPane(new InterfazMostrarClientes(frame,empresa));
			}
		});
		
		//Boton Vestido
		btnVestido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new InterfazVestido(frame,cliente,empresa));//TODO PASAR DIRECTAMENTE CLIENTE Y DSP HACER GET VESTIDO
				frame.setVisible(true);
			}
		});
		
		//Boton cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEditar.setVisible(false);
				panelCliente.setVisible(true);
			}
		});
		
		//Boton confirmar edicion
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente n = new Cliente(cliente.getId(),textFieldNombre.getText(),textFieldApellido.getText(),textFieldMail.getText(),(int) spinnerTelefono.getValue(),(int) spinnerTelefono2.getValue(),(int)spinnerEdad.getValue());
				//TODO aca deberiamos remplazar el cliente que usa esta interfaz por el actualizado, tambien actualizar los text fields y labels
				empresa.editarCliente(cliente);
				panelEditar.setVisible(false);
				panelCliente.setVisible(true);
			}
		});
		
		//Boton Editar
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelEditar.setVisible(true);
				panelCliente.setVisible(false);
			}
		});
		
		//Rectificaciones
		//Ocultar la tabla y mostrar el TextField
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPaneListaRect.setVisible(false);
				panelRectAgregar.setVisible(true);
				btnAceptar.setVisible(true);
			}
		});
		
		//Agregar nueva rectificacion con lo que hay en el textbox
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rectificacion rectificacion = new Rectificacion(0, textArea.getText());
				cliente.agregarRectificacion(rectificacion);
				tableRect.setModel(actualizarTablaRectificaciones(tableRect.getModel(), cliente));
				textArea.setText("");
				panelRectAgregar.setVisible(false);
				scrollPaneListaRect.setVisible(true);
			}
		});
		
		//Mostrar la tabla y ocultar el textfield
		btnCancelarRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelRectAgregar.setVisible(false);
				textArea.setText("");
				scrollPaneListaRect.setVisible(true);
				btnAceptar.setVisible(true);
			}
		});
		
		//Borrar rectificacion
		btnBorrarRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSelecionada = tableRect.getSelectedRow();
				Object valor = tableRect.getValueAt(filaSelecionada, 0);
				cliente.borrarRectificacion((int) valor);
				tableRect.setModel(actualizarTablaRectificaciones(tableRect.getModel(), cliente));
			}
		});
		
		//Mostrar rectificacion
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSelecionada = tableRect.getSelectedRow();
				Object valor = tableRect.getValueAt(filaSelecionada, 0);
				scrollPaneListaRect.setVisible(false);
				panelRectAgregar.setVisible(true);
				btnAceptar.setVisible(false);
				for(Rectificacion rect : cliente.getRectificaciones()) {
					if(rect.getId() == (int) valor) {
						textArea.setText(rect.getTexto());
					}
				}
				
			}
		});
		
	}
	
	private DefaultTableModel actualizarTablaPagos(TableModel modelo, Cliente cliente) {
		DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
		modeloSolucion.setRowCount(0);
		int totalPagado = 0;
		for(Pago p : cliente.getPagos()) {
			Object[] linea = {p.getId(),p.getDescripcion(),p.getMonto(),p.getFecha()};
			modeloSolucion.addRow(linea);
			totalPagado = totalPagado + p.getMonto();
			}
		int valorVestido = Integer.valueOf(labelNumeroTotal.getText());
		labelNumeroTotal.setText(String.valueOf(cliente.getValorVestido()));
		lblNumeroPagado.setText(String.valueOf(totalPagado));
		labelNumeroFaltante.setText(String.valueOf(valorVestido - totalPagado));
		return modeloSolucion;
	}
	
	private DefaultTableModel actualizarTablaRectificaciones(TableModel modelo, Cliente cliente) {
		DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
		modeloSolucion.setRowCount(0);
		for(Rectificacion rec : cliente.getRectificaciones()) {
			Object[] linea = {rec.getId(),rec.getFecha()};
			modeloSolucion.addRow(linea);
			}
		return modeloSolucion;
	}
}
