package interfaz;

import javax.swing.JPanel;

import modelo.Admin;
import modelo.Cliente;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazMenuAdmin extends JPanel {

	/**
	 * Create the panel.
	 */
	public InterfazMenuAdmin(JFrame	frame, Cliente admin) {
		setLayout(null);
		
		JButton btnAdmins = new JButton("Admins");
		btnAdmins.setBounds(10, 59, 89, 23);
		add(btnAdmins);
		
		JButton btnViajes = new JButton("Viajes");
		btnViajes.setBounds(10, 93, 89, 23);
		add(btnViajes);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setBounds(10, 127, 89, 23);
		add(btnConsultas);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMenu.setBounds(10, 11, 73, 37);
		add(lblMenu);
		
		//InterfazAdmin
		btnAdmins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new InterfazAdmin(frame,admin.getId(),admin.getUser(),admin));
				frame.setVisible(true);
				frame.setBounds(0, 0, 400, 200);
			}
		});
		
		//InterfazViajes
		btnViajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new InterfazViajes(frame, admin));
				frame.setVisible(true);
				frame.setBounds(0, 0, 400, 200);
			}
		});
		
		//InterfazEsadisticas
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new InterfazEstadisticas(frame, admin));
				frame.setVisible(true);
				frame.setBounds(0, 0, 400, 200);
			}
		});

	}
}
