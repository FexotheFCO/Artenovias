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
		setLayout(null);
		frame.setBounds(0, 0, 300, 300);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 72, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 36, 72, 14);
		add(lblApellido);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 61, 72, 14);
		add(lblMail);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 111, 72, 14);
		add(lblTelefono);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 86, 72, 14);
		add(lblEdad);
		
		JLabel lblTelefono_1 = new JLabel("Telefono 2");
		lblTelefono_1.setBounds(10, 136, 72, 14);
		add(lblTelefono_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(91, 11, 86, 14);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(91, 36, 86, 14);
		add(textFieldApellido);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(91, 61, 86, 14);
		add(textFieldMail);
		
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(91, 86, 86, 14);
		add(spinnerEdad);
		
		JSpinner spinnerTelefono = new JSpinner();
		spinnerTelefono.setBounds(91, 111, 86, 14);
		add(spinnerTelefono);
		
		JSpinner spinnerTelefono2 = new JSpinner();
		spinnerTelefono2.setBounds(91, 136, 86, 14);
		add(spinnerTelefono2);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(42, 161, 89, 23);
		add(btnAgregar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(42, 195, 89, 23);
		add(btnAtras);
		
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
