import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class InterfazRegistro extends JPanel {
	private JTextField txtFieldUsuario;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public InterfazRegistro(JFrame frame) {
		setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(10, 11, 46, 14);
		add(lblUsuario);
		
		txtFieldUsuario = new JTextField();
		txtFieldUsuario.setBounds(86, 8, 86, 20);
		add(txtFieldUsuario);
		txtFieldUsuario.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContraseña.setBounds(10, 39, 73, 14);
		add(lblContraseña);
		
		JButton btnRegistrar = new JButton("Registrar");
		
		btnRegistrar.setBounds(83, 98, 89, 23);
		add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(83, 132, 89, 23);
		add(btnVolver);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(86, 64, 86, 20);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(86, 36, 86, 20);
		add(passwordField_1);
		
		//volver
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazLogueo(frame));
				frame.setBounds(0, 0, 400, 200);
				frame.setVisible(true);
			}
		});
		//registra usuario
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtFieldUsuario.getText();
				String password1 = String.valueOf(passwordField.getPassword());
				String password2 = String.valueOf(passwordField_1.getPassword());
				String passEncriptada = DigestUtils.md5Hex(password1);
				if(!usuario.isEmpty() && !password1.isEmpty() && password1.equals(password2)) {
					DAOUsuario dao = new DAOUsuario();
					int id = 0;
					int tipo = 2;
					Cliente c = new Usuario(id,txtFieldUsuario.getText(), passEncriptada,tipo);
					dao.agregarUser(c);
					}
			}
		});

	}
}

//&& String.valueOf(passwordField.getPassword().equals(String.valueOf(passwordField.getPassword())))
/*&& txtFieldContraseña.getText() == txtFieldContraseñaTwo.getText()*/
