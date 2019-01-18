package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.DaoCliente;
import modelo.Cliente;
import modelo.Empresa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class InterfazMostrarClientes extends JPanel {
	private JTable table;
	private DaoCliente daoCliente = new DaoCliente();
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public InterfazMostrarClientes(JFrame frame,Empresa empresa) {
		setLayout(null);
		frame.setBounds(0,0,440,350);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 266, 253);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Apellido", "Nombre"
			}
		){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }});
		scrollPane.setViewportView(table);
		
		table.setModel(actualizarTabla(table.getModel(),empresa));
		
		JLabel lblBuscador = new JLabel("Buscador");
		lblBuscador.setBounds(10, 11, 79, 14);
		add(lblBuscador);
		
		textField = new JTextField();
		textField.setBounds(99, 8, 177, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(323, 266, 89, 23);
		add(btnAtras);
		
		JButton btnVerCliente = new JButton("Ver Cliente");
		btnVerCliente.setBounds(323, 33, 89, 23);
		add(btnVerCliente);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazMenu(frame,empresa));
				frame.setVisible(true);
			}
		});
		
		btnVerCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSelecionada = table.getSelectedRow();
				Object valor = table.getValueAt(filaSelecionada, 0);
				frame.setVisible(false);
				Cliente cliente = daoCliente.devolverCliente((int) valor);
				frame.setContentPane(new InterfazCliente(frame,cliente,empresa));
				frame.setVisible(true);
			}
		});
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				table.setModel(actualizarTablaConBusqueda(table.getModel(), empresa, textField.getText()));
			}
		});
		
	}
	
	DefaultTableModel actualizarTabla(TableModel modelo,Empresa empresa) {
		DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
		modeloSolucion.setRowCount(0);
		for(Cliente c : empresa.getClientes()) {
			Object[] linea = {c.getId(),c.getApellido(),c.getNombre()};
			modeloSolucion.addRow(linea);
			}
		return modeloSolucion;
	}
	
	DefaultTableModel actualizarTablaConBusqueda(TableModel modelo,Empresa empresa,String busqueda) {
		DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
		modeloSolucion.setRowCount(0);
		for(Cliente c : empresa.busquedaDeClientes(busqueda)) {
			Object[] linea = {c.getId(),c.getApellido(),c.getNombre()};
			modeloSolucion.addRow(linea);
			}
		return modeloSolucion;
	}
}
