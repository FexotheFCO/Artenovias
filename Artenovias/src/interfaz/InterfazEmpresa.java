package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Cliente;
import modelo.Empresa;
import modelo.Pago;

public class InterfazEmpresa extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public InterfazEmpresa() {
		setLayout(null);
		
		JLabel lblPagos = new JLabel("Pagos");
		lblPagos.setBounds(10, 11, 46, 14);
		add(lblPagos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 430, 182);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Cliente", "Descripcion", "Monto", "Fecha"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		scrollPane.setViewportView(table);

	}
	
	DefaultTableModel actualizarTabla(TableModel modelo,Empresa empresa) {
		DefaultTableModel modeloSolucion = (DefaultTableModel) modelo;
		modeloSolucion.setRowCount(0);
		for(Pago p : empresa.devolverTodosLosPagos()) {
			Object[] linea = {p.getId()};
			modeloSolucion.addRow(linea);
			}
		return modeloSolucion;
	}
}
