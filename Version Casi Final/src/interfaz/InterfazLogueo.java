package interfaz;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;

import dao.DAOUsuario;
import modelo.Cliente;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class InterfazLogueo extends JPanel {
	private JTextField txtUsuario;
	private int tipo;
	private int idUserActual;
	Cliente userActualoide;
	private JPasswordField passwordField;
	
	/**
	 * Create the panel.
	 */
	public InterfazLogueo(JFrame frame) {
		setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(156, 27, 130, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(180, 87, 89, 23);
		add(btnLogin);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.setContentPane(new InterfazRegistro(frame));
				frame.setBounds(0,0,270,200);
				frame.setVisible(true);
			}
		});
		btnRegistrar.setBounds(180, 121, 89, 23);
		add(btnRegistrar);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(156, 56, 130, 20);
		add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(45, 30, 89, 14);
		add(lblUsuario);
		
		JLabel lblContraseia = new JLabel("Contrase\u00F1ia");
		lblContraseia.setBounds(45, 59, 89, 14);
		add(lblContraseia);
		

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(revisar(txtUsuario.getText(),String.valueOf(passwordField.getPassword()))) {
					//frame.setContentPane(new InterfazAdmin(frame));
					//if(revisar(txtUsuario.getText(),String.valueOf(passwordField.getPassword()))) {
						switch(tipo){
						case 1://admin
							frame.setVisible(false);
							frame.setContentPane(new InterfazMenuAdmin(frame, userActualoide));
							frame.setBounds(0,0,500,570);
							frame.setVisible(true);
							break;
						case 2://user
							frame.setVisible(false);
							frame.setContentPane(new InterfazUsuario(frame, userActualoide));
							frame.setBounds(0,0,500,570);
							frame.setVisible(true);
						case 3://userVIP
							frame.setVisible(false);
							frame.setContentPane(new InterfazUsuario(frame, userActualoide));
							frame.setBounds(0,0,500,570);
							frame.setVisible(true);
						}
					//}
				}
			}
		});
		
		
	}
	Boolean	revisar(String user, String password) {
		DAOUsuario daoUsuario = new DAOUsuario();
		ArrayList<Cliente> usuarios = new ArrayList<Cliente>();
		usuarios = daoUsuario.obtenerTodosLosUsuarios();// lista con todos los users de la base de datos
		
		for(Cliente u : usuarios) {//estructura repetitiva que chequea si el usuario ingresado es igual a alguno de la bd
			if(u.getUser().equals(user) && u.getPassword().equals(DigestUtils.md5Hex(password))) {
				setIdUserActual(u.getId());
				tipo = u.getTipo();
				userActualoide = u;
				return true;//retorna un true si encontro
			}
		}
		System.out.println("No encontro usuario");
		return false;//retorna falso si no encontro nada
	}
	

	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public int getIdUserActual() {
		return idUserActual;
	}

	public void setIdUserActual(int idUserActual) {
		this.idUserActual = idUserActual;
	}
}
