package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.DaoCliente;
import dao.DaoVenta;
import modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InterfazMostrarClientes extends JPanel {
	private JTable table;
	private DaoCliente daoCliente = new DaoCliente();
	private JTextField textField;
	private DaoVenta daoVenta = new DaoVenta();

	/**
	 * Create the panel.
	 */
	public InterfazMostrarClientes(JFrame frame) {
		setLayout(null);
		
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
		));
		scrollPane.setViewportView(table);
		
		table.setModel(actualizarTabla(table.getModel()));
		
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
				frame.setContentPane(new InterfazEmpresa(frame));
				frame.setVisible(true);
			}
		});
		
		btnVerCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSelecionada = table.getSelectedRow();
				Object valor = table.getValueAt(filaSelecionada, 0);
				frame.setVisible(false);
				frame.setContentPane(new InterfazCliente(frame,daoVenta.devolverCliente((int) valor)));
				frame.setVisible(true);
			}
		});
		

	}
	
	DefaultTableModel actualizarTabla(TableModel modelo) {
		DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
		modeloSolucion.setRowCount(0);
		for(Cliente c : daoCliente.devolverTodosLosClientes()) {
			Object[] linea = {c.getId(),c.getApellido(),c.getNombre()};
			modeloSolucion.addRow(linea);
			}
		return modeloSolucion;
	}
}
