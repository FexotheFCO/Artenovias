package interfaz;
import javax.swing.JPanel;

import modelo.Empresa;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InterfazMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public InterfazMenu(JFrame frame, Empresa empresa) {
		setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar Cliente");
		btnAgregar.setBounds(10, 11, 124, 23);
		add(btnAgregar);
		
		JButton btnVerClientes = new JButton("Ver Clientes");
		btnVerClientes.setBounds(10, 45, 124, 23);
		add(btnVerClientes);
		
		JButton btnArticulos = new JButton("Articulos");
		btnArticulos.setBounds(10, 79, 124, 23);
		add(btnArticulos);
		
		//Agregar Cliente
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazAgregarCliente agregar = new InterfazAgregarCliente(frame,empresa);
				frame.setVisible(false);
				frame.setContentPane(agregar);
				frame.setVisible(true);
			}
		});
		//Ver Clientes
		btnVerClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazMostrarClientes(frame,empresa));
				frame.setVisible(true);
			}
		});
		//Articulos
		btnArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazArticulos(frame,empresa));
				frame.setVisible(true);
			}
		});

	}
}
