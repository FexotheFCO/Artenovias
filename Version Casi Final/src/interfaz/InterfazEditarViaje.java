package interfaz;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.DAOviajes;

import javax.swing.JSpinner;
import datechooser.beans.DateChooserCombo;
import modelo.Cliente;
import modelo.Viaje;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class InterfazEditarViaje extends JPanel {
	private JTextField textFieldDestino;
	private JTextField textFieldOrigen;
	private DAOviajes daoViaje = new DAOviajes();

	/**
	 * Create the panel.
	 */
	public InterfazEditarViaje(JFrame frame, Viaje viaje, Cliente admin) {
		setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(73, 126, 89, 23);
		add(btnEditar);
		
		JLabel label = new JLabel("Destino");
		label.setBounds(10, 43, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Precio");
		label_1.setBounds(10, 68, 46, 14);
		add(label_1);
		
		JLabel label_3 = new JLabel("Fecha");
		label_3.setBounds(10, 93, 46, 14);
		add(label_3);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setColumns(10);
		textFieldDestino.setBounds(86, 40, 154, 20);
		add(textFieldDestino);
		
		JSpinner spinnerPrecio = new JSpinner();
		spinnerPrecio.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spinnerPrecio.setBounds(86, 65, 154, 20);
		add(spinnerPrecio);
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		dateChooserCombo.setBounds(86, 93, 155, 22);
		add(dateChooserCombo);
		
		JLabel label_4 = new JLabel("Origen");
		label_4.setBounds(10, 14, 56, 16);
		add(label_4);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setColumns(10);
		textFieldOrigen.setBounds(86, 11, 154, 22);
		add(textFieldOrigen);
		
		textFieldDestino.setText(viaje.getDestino());
		textFieldOrigen.setText(viaje.getOrigen());
		spinnerPrecio.setValue(viaje.getPrecio());
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setContentPane(new InterfazViajes(frame,admin));
				frame.setVisible(true);
				frame.setBounds(0, 0, 400, 200);
			}
		});
		btnNewButton.setBounds(73, 160, 89, 23);
		add(btnNewButton);
		
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double precio = (Double) spinnerPrecio.getValue();
				LocalDate fecha =  dateChooserCombo.getSelectedDate().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				daoViaje.actualizarViaje(new Viaje(viaje.getId(),textFieldDestino.getText(),precio,textFieldOrigen.getText(),fecha));
			}
		});
		

	}
}
