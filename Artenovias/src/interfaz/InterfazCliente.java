package interfaz;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dao.DaoCliente;
import modelo.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class InterfazCliente extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldMail;
    private	DaoCliente daoCliente = new DaoCliente();
    
	public InterfazCliente(JFrame frame,Cliente cliente) {
		setLayout(null);
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(93, 52, 139, 238);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreUser = new JLabel("Nombre");
		lblNombreUser.setBounds(10, 23, 119, 14);
		panel.add(lblNombreUser);
		
		JLabel lblApellidoUser = new JLabel("Apellido");
		lblApellidoUser.setBounds(10, 48, 119, 14);
		panel.add(lblApellidoUser);
		
		JLabel lblTelefonoUser = new JLabel("Telefono");
		lblTelefonoUser.setBounds(10, 123, 119, 14);
		panel.add(lblTelefonoUser);
		
		JLabel lblMailUser = new JLabel("Mail");
		lblMailUser.setBounds(10, 98, 119, 14);
		panel.add(lblMailUser);
		
		JLabel lblTelefono2User = new JLabel("Telefono 2");
		lblTelefono2User.setBounds(10, 148, 119, 14);
		panel.add(lblTelefono2User);
		
		JLabel lblEdadUser = new JLabel("Edad");
		lblEdadUser.setBounds(10, 73, 119, 14);
		panel.add(lblEdadUser);
		
		//SetText de Usuario
		lblNombreUser.setText(cliente.getNombre());
		lblApellidoUser.setText(cliente.getApellido());
		lblTelefonoUser.setText(String.valueOf(cliente.getTelefono()));
		lblTelefono2User.setText(String.valueOf(cliente.getTelefono2()));
		lblMailUser.setText(cliente.getMail());
		lblEdadUser.setText(String.valueOf(cliente.getEdad()));
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(33, 173, 73, 23);
		panel.add(btnEdit);
		//Fin Usuarioo
		
		//Editar User
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(93, 62, 139, 238);
		add(panel_1);
		panel_1.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(10, 11, 119, 14);
		textFieldNombre.setText(cliente.getNombre());
		panel_1.add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(10, 36, 119, 14);
		textFieldApellido.setText(cliente.getApellido());
		panel_1.add(textFieldApellido);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(10, 86, 119, 14);
		textFieldMail.setText(cliente.getMail());
		panel_1.add(textFieldMail);
		
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(10, 61, 119, 14);
		spinnerEdad.setValue((int) cliente.getEdad());
		panel_1.add(spinnerEdad);
		
		JSpinner spinnerTelefono = new JSpinner();
		spinnerTelefono.setBounds(10, 111, 119, 14);
		spinnerTelefono.setValue((int) cliente.getTelefono());
		panel_1.add(spinnerTelefono);
		
		JSpinner spinnerTelefono2 = new JSpinner();
		spinnerTelefono2.setBounds(10, 136, 119, 14);
		spinnerTelefono2.setValue((int) cliente.getTelefono2());
		panel_1.add(spinnerTelefono2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 161, 119, 23);
		panel_1.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(10, 195, 119, 23);
		panel_1.add(btnConfirmar);
		
		JLabel lblVestido = new JLabel("Vestido");
		lblVestido.setBounds(11, 317, 46, 14);
		add(lblVestido);
		
		//TEST1
		//tEST2
		panel_1.setVisible(false);
		//Fin Editar
		
		//Boton cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		//Boton confirmar
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente n = new Cliente(cliente.getId(),textFieldNombre.getText(),textFieldApellido.getText(),textFieldMail.getText(),(int) spinnerTelefono.getValue(),(int) spinnerTelefono2.getValue(),(int)spinnerEdad.getValue());
				//TODO aca deberiamos remplazar el cliente que usa esta interfaz por el actualizado, tambien actualizar los text fields y labels
				daoCliente.editarCliente(n);
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		//Boton Editar
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		
	}
}
