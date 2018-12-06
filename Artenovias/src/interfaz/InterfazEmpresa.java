package interfaz;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InterfazEmpresa extends JPanel {

	/**
	 * Create the panel.
	 */
	public InterfazEmpresa(JFrame frame) {
		setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar Cliente");
		btnAgregar.setBounds(10, 11, 124, 23);
		add(btnAgregar);
		
		JButton btnVerClientes = new JButton("Ver Clientes");
		btnVerClientes.setBounds(10, 45, 124, 23);
		add(btnVerClientes);
		
		//Agregar Cliente
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazAgregarCliente agregar = new InterfazAgregarCliente(frame);
				frame.setVisible(false);
				frame.setContentPane(agregar);
				frame.setVisible(true);
			}
		});
		
		btnVerClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazMostrarClientes(frame));
				frame.setVisible(true);
			}
		});

	}
}
