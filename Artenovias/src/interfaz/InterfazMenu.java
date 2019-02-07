package interfaz;
import javax.swing.JPanel;

import modelo.Empresa;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class InterfazMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public InterfazMenu(JFrame frame, Empresa empresa) {
		setBackground(Color.PINK);
		setLayout(null);
		frame.setBounds(0, 0, 200, 250);
		
		JButton btnAgregar = new JButton("Nuevo Cliente");
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(10, 59, 124, 23);
		add(btnAgregar);
		
		JButton btnVerClientes = new JButton("Ver Clientes");
		btnVerClientes.setBackground(Color.WHITE);
		btnVerClientes.setBounds(10, 93, 124, 23);
		add(btnVerClientes);
		
		JButton btnArticulos = new JButton("Articulos");
		btnArticulos.setBackground(Color.WHITE);
		btnArticulos.setBounds(10, 127, 124, 23);
		add(btnArticulos);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setBackground(Color.WHITE);
		btnBalance.setBounds(10, 161, 124, 23);
		add(btnBalance);
		
		JLabel lblArtenovias = new JLabel("Artenovias");
		lblArtenovias.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtenovias.setFont(new Font("Chaparral Pro Light", Font.ITALIC, 28));
		lblArtenovias.setBounds(10, 11, 124, 48);
		add(lblArtenovias);
		
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
		//Balance
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazBalance(frame, empresa));
				frame.setVisible(true);
			}
		});
	}
}
