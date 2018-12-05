package interfaz;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.codec.digest.DigestUtils;

import dao.DAOUsuario;
import dao.DAOviajes;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.Panel;
import datechooser.beans.DateChooserCombo;
import modelo.Admin;
import modelo.Cliente;
import modelo.Usuario;
import modelo.Viaje;

import javax.swing.JScrollPane;

public class InterfazAdmin extends JPanel {
	private JTable table;
	private JTextField textUsuario;
	private JTable tableUsuarios;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTable tableUsuariosVip;
	
	/**
	 * Create the panel.
	 */
	
	public InterfazAdmin(JFrame frame, int idAdmin, String userAdmin, Cliente admin) {
		setBackground(new Color(102, 102, 102));
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBounds(10, 11, 228, 195);
		add(panel);
		panel.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar Admin");
		btnRegistrar.setBounds(51, 150, 117, 23);
		panel.add(btnRegistrar);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(122, 35, 96, 20);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(20, 38, 92, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(20, 83, 92, 14);
		panel.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 80, 96, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(122, 111, 96, 20);
		panel.add(passwordField_1);
		
		JLabel lblConfirmar = new JLabel("Confirmar");
		lblConfirmar.setBounds(20, 114, 92, 14);
		panel.add(lblConfirmar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(235, 11, 328, 195);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 11, 124, 170);
		panel_1.add(scrollPane_1);
		
		tableUsuarios = new JTable();
		scrollPane_1.setViewportView(tableUsuarios);
		tableUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Usuario"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		JButton btnBorrarUsuario = new JButton("Borrar");
		btnBorrarUsuario.setBounds(180, 100, 91, 26);
		panel_1.add(btnBorrarUsuario);
		
		JButton btnRefreshUsuario = new JButton("Refresh");
		btnRefreshUsuario.setBounds(180, 66, 91, 23);
		panel_1.add(btnRefreshUsuario);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new InterfazMenuAdmin(frame, admin));
				frame.setVisible(true);
				frame.setBounds(0, 0, 400, 200);
			}
		});
		btnAtras.setBounds(245, 416, 89, 23);
		add(btnAtras);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(235, 212, 328, 195);
		add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 193, 170);
		panel_2.add(scrollPane);
		
		tableUsuariosVip = new JTable();
		tableUsuariosVip.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Usuario", "Tipo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableUsuariosVip.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableUsuariosVip.getColumnModel().getColumn(2).setPreferredWidth(40);
		scrollPane.setViewportView(tableUsuariosVip);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DAOUsuario daoUsuario = new DAOUsuario();
				
				DefaultTableModel modeloUsuarioVip = (DefaultTableModel) tableUsuariosVip.getModel();
				
				modeloUsuarioVip.setRowCount(0);
				for(Cliente u : daoUsuario.obtenerTodosLosClientes()) {
					Object[] linea = {u.getId(),u.getUser(),u.getTipo()};
					modeloUsuarioVip.addRow(linea);
					tableUsuariosVip.setModel(modeloUsuarioVip);
					}
				
			}
		});
		btnRefresh.setBounds(225, 35, 91, 23);
		panel_2.add(btnRefresh);
		
		JButton btnVip = new JButton("VIP");
		btnVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOUsuario daoUsuario = new DAOUsuario();
				DefaultTableModel modeloUsuarioVip = (DefaultTableModel) tableUsuariosVip.getModel();
				int id = Integer.valueOf( modeloUsuarioVip.getValueAt(tableUsuariosVip.getSelectedRow(), 0).toString());
				int tipo = Integer.valueOf( modeloUsuarioVip.getValueAt(tableUsuariosVip.getSelectedRow(), 2).toString());
				
				switch (tipo) {
				case 2:
					daoUsuario.hacerVIP(id);
					modeloUsuarioVip.setRowCount(0);
					for(Cliente u : daoUsuario.obtenerTodosLosClientes()) {
						Object[] linea = {u.getId(),u.getUser(),u.getTipo()};
						modeloUsuarioVip.addRow(linea);
						tableUsuariosVip.setModel(modeloUsuarioVip);
						}
					break;
				case 3:
					daoUsuario.hacerNoVIP(id);
					modeloUsuarioVip.setRowCount(0);
					for(Cliente u : daoUsuario.obtenerTodosLosClientes()) {
						Object[] linea = {u.getId(),u.getUser(),u.getTipo()};
						modeloUsuarioVip.addRow(linea);
						tableUsuariosVip.setModel(modeloUsuarioVip);
						}
					break;
				}
				
				
				
				
				
				
			}
		});
		btnVip.setBounds(225, 71, 97, 25);
		panel_2.add(btnVip);
		
		//Ver Lista Usuario
		btnRefreshUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOUsuario daoUsuario = new DAOUsuario();
				DefaultTableModel modeloUsuario = (DefaultTableModel) tableUsuarios.getModel();
				
				modeloUsuario.setRowCount(0);
				for(Cliente u : daoUsuario.obtenerTodosLosAdmins()) {
					Object[] linea = {u.getId(),u.getUser(),u.getPassword()};
					modeloUsuario.addRow(linea);
					tableUsuarios.setModel(modeloUsuario);
					}
		}
		});
		
		//Borrar Usuario
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DAOUsuario daoUsuario = new DAOUsuario();
				DefaultTableModel modeloUsuario = (DefaultTableModel) tableUsuarios.getModel();
				int caca = tableUsuarios.getSelectedRow();
				Object valor = tableUsuarios.getValueAt(caca, 0);
				daoUsuario.borrarUsuario((int) valor);
				modeloUsuario.removeRow(caca);
				tableUsuarios.setModel(modeloUsuario);
			}
		});
		
		
		//Registrar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DAOUsuario daoUsuario = new DAOUsuario();
				
				String usuario = textUsuario.getText();
				String password = String.valueOf(passwordField.getPassword());
				String password2 = String.valueOf(passwordField_1.getPassword());
				String passEncriptada = DigestUtils.md5Hex(password);
				//System.out.println(!usuario.isEmpty());
				//System.out.println(!password.isEmpty());
				System.out.println(password.equals(password2));
				if(!usuario.isEmpty() && !password.isEmpty() && password.equals(password2)) {
					System.out.println("entre");
					int id = 0;
					int tipo = 1;
					daoUsuario.agregarUser(new Usuario(id,usuario,passEncriptada,1));
				

				}
			}
		});
		
		
		
			
		
	}
}
