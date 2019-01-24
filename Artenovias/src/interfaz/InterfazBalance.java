package interfaz;

import javax.swing.JPanel;

import modelo.Compra;
import modelo.Empresa;
import modelo.Pago;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class InterfazBalance extends JPanel {

	/**
	 * Create the panel.
	 */
	public InterfazBalance(JFrame frame,Empresa empresa) {
		setLayout(null);
		
		JComboBox comboBoxMeses = new JComboBox();
		comboBoxMeses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBoxMeses.setBounds(10, 22, 124, 20);
		add(comboBoxMeses);
		
		JComboBox<Integer> comboBoxYear = new JComboBox();
		comboBoxYear.setBounds(144, 22, 60, 20);
		add(comboBoxYear);
		agregarYearsAlComboBox(comboBoxYear, empresa);
		
		JPanel panelTextoFijo = new JPanel();
		panelTextoFijo.setBounds(10, 53, 60, 66);
		add(panelTextoFijo);
		panelTextoFijo.setLayout(null);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setBounds(10, 11, 46, 14);
		panelTextoFijo.add(lblEntrada);
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setBounds(10, 36, 46, 14);
		panelTextoFijo.add(lblSalida);
		
		JPanel panelTextoDinamico = new JPanel();
		panelTextoDinamico.setBounds(80, 53, 124, 66);
		add(panelTextoDinamico);
		panelTextoDinamico.setLayout(null);
		
		JLabel labelEntradaDinamico = new JLabel("");
		labelEntradaDinamico.setBounds(10, 11, 104, 14);
		panelTextoDinamico.add(labelEntradaDinamico);
		
		JLabel labelSalidaDinamico = new JLabel("");
		labelSalidaDinamico.setBounds(10, 36, 104, 14);
		panelTextoDinamico.add(labelSalidaDinamico);

	}
	
	private void agregarYearsAlComboBox(JComboBox<Integer> comboBox,Empresa empresa){
		ArrayList<Integer>years = new ArrayList<Integer>();
		for(Compra c : empresa.devolverTodasLasCompras()) {
			if(!years.contains(c.getFecha().getYear())) {
				years.add(c.getFecha().getYear());
			}
		}
		for(Pago p : empresa.devolverTodosLosPagos()) {
			if(!years.contains(p.getFecha().getYear())) {
				years.add(p.getFecha().getYear());
			}
		}
		for(Integer year : years) {
			comboBox.addItem(year);
		}
	}
	
	private void actualizarResultados(Empresa empresa, JLabel pagos,JLabel compras,JComboBox<Integer>years,JComboBox meses) {
		
	}
}
