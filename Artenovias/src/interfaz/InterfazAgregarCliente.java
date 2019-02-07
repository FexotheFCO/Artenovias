package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DaoCliente;
import modelo.Cliente;
import modelo.Empresa;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class InterfazAgregarCliente extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldMail;
	private DaoCliente daoCliente = new DaoCliente();

	/**
	 * Create the panel.
	 */
	public InterfazAgregarCliente(JFrame frame,Empresa empresa) {
		setBackground(new Color(255, 182, 193));
		setLayout(null);
		frame.setBounds(0, 0, 300, 300);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 72, 20);
		add(lblNombre);
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 42, 72, 20);
		add(lblApellido);
		lblApellido.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 73, 72, 20);
		add(lblMail);
		lblMail.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 135, 99, 20);
		add(lblTelefono);
		lblTelefono.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 104, 72, 20);
		add(lblEdad);
		lblEdad.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JLabel lblTelefono_1 = new JLabel("Telefono 2");
		lblTelefono_1.setBounds(10, 165, 99, 20);
		add(lblTelefono_1);
		lblTelefono_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(138, 11, 107, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(138, 42, 107, 20);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldMail = new JTextField();
		textFieldMail.setBounds(138, 73, 107, 20);
		add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(138, 104, 107, 20);
		add(spinnerEdad);
		
		JSpinner spinnerTelefono = new JSpinner();
		spinnerTelefono.setBounds(138, 135, 107, 20);
		add(spinnerTelefono);
		
		JSpinner spinnerTelefono2 = new JSpinner();
		spinnerTelefono2.setBounds(138, 166, 107, 20);
		add(spinnerTelefono2);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(45, 238, 163, 23);
		add(btnAtras);
		btnAtras.setBackground(Color.WHITE);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(45, 204, 163, 23);
		add(btnAgregar);
		btnAgregar.setBackground(Color.WHITE);
		
		//agregar	
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO Hacer un cartel para Confirmar
				String nombre = textFieldNombre.getText();
				String apellido = textFieldApellido.getText();
				String mail = textFieldMail.getText();
				int edad = (int) spinnerEdad.getValue();
				int telefono = (int) spinnerTelefono.getValue();
				int telefono2 = (int) spinnerTelefono2.getValue();
				if(!nombre.isEmpty() && !apellido.isEmpty() && !mail.isEmpty() && edad > 0 && telefono > 9999999 && telefono2 > 9999999) {
					Cliente cliente = new Cliente(0,nombre,apellido,mail,telefono,telefono2,edad);
					empresa.agregarCliente(cliente);
				}
				//TODO boton que confirme el cambio satisfactorio
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazMenu(frame,empresa));
				frame.setVisible(true);
			}
		});

	}
}
