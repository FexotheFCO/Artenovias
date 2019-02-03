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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 130, 431, 528);
		add(panel);
		panel.setLayout(null);
		
		actualizarResultadosV2(panel, empresa, comboBoxYear);
			
		comboBoxYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.repaint();
				actualizarResultadosV2(panel, empresa, comboBoxYear);
			}
		});
		
	}

	private void actualizarResultadosV2(JPanel panel,Empresa empresa,JComboBox<Integer> comboBox) {
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(6, 6, 54, 14);
		panel.add(lblMes);
		
		JLabel lblIngreso = new JLabel("Ingreso");
		lblIngreso.setBounds(66, 6, 54, 14);
		panel.add(lblIngreso);
		
		JLabel lblEgreso = new JLabel("Egreso");
		lblEgreso.setBounds(130, 6, 54, 14);
		panel.add(lblEgreso);
		
		JLabel lblEnero = new JLabel("Enero");
		lblEnero.setBounds(6, 26, 54, 14);
		panel.add(lblEnero);
		
		JLabel lblFebrero = new JLabel("Febrero");
		lblFebrero.setBounds(6, 46, 54, 14);
		panel.add(lblFebrero);
		
		JLabel lblMarzo = new JLabel("Marzo");
		lblMarzo.setBounds(6, 66, 54, 14);
		panel.add(lblMarzo);
		
		JLabel lblAbril = new JLabel("Abril");
		lblAbril.setBounds(6, 86, 54, 14);
		panel.add(lblAbril);
		
		JLabel lblMayo = new JLabel("Mayo");
		lblMayo.setBounds(6, 106, 54, 14);
		panel.add(lblMayo);
		
		JLabel lblJunio = new JLabel("Junio");
		lblJunio.setBounds(6, 126, 54, 14);
		panel.add(lblJunio);
		
		JLabel lblJulio = new JLabel("Julio");
		lblJulio.setBounds(6, 146, 54, 14);
		panel.add(lblJulio);
		
		JLabel lblAgosto = new JLabel("Agosto");
		lblAgosto.setBounds(6, 166, 54, 14);
		panel.add(lblAgosto);
		
		JLabel lblSeptiembre = new JLabel("Septiembre");
		lblSeptiembre.setBounds(6, 186, 54, 14);
		panel.add(lblSeptiembre);
		
		JLabel lblOctubre = new JLabel("Octubre");
		lblOctubre.setBounds(6, 206, 54, 14);
		panel.add(lblOctubre);
		
		JLabel lblNoviembre = new JLabel("Noviembre");
		lblNoviembre.setBounds(6, 226, 54, 14);
		panel.add(lblNoviembre);
		
		JLabel lblDiciembre = new JLabel("Diciembre");
		lblDiciembre.setBounds(6, 246, 54, 14);
		panel.add(lblDiciembre);
		
		int year = (int) comboBox.getSelectedItem();
		int[][] valores = new int[12][2];
		for(Compra c : empresa.devolverTodasLasCompras()) {
			if(c.getFecha().getYear() == year) {
				switch (c.getFecha().getMonthValue()) {
				case 1:
					valores[0][1] = valores[0][1] + c.getMonto();
					break;
				case 2:
					valores[1][1] = valores[1][1] + c.getMonto();
					break;
				case 3:
					valores[2][1] = valores[2][1] + c.getMonto();
					break;
				case 4:
					valores[3][1] = valores[3][1] + c.getMonto();
					break;
				case 5:
					valores[4][1] = valores[4][1] + c.getMonto();
					break;
				case 6:
					valores[5][1] = valores[5][1] + c.getMonto();
					break;
				case 7:
					valores[6][1] = valores[6][1] + c.getMonto();
					break;
				case 8:
					valores[7][1] = valores[7][1] + c.getMonto();
					break;
				case 9:
					valores[8][1] = valores[8][1] + c.getMonto();
					break;
				case 10:
					valores[9][1] = valores[9][1] + c.getMonto();
					break;
				case 11:
					valores[10][1] = valores[10][1] + c.getMonto();
					break;
				case 12:
					valores[11][1] = valores[11][1] + c.getMonto();
					break;
				default:
					break;
				}
			}
		}
		for(Pago p : empresa.devolverTodosLosPagos()) {
			if(p.getFecha().getYear() == year) {
				switch (p.getFecha().getMonthValue()) {
				case 1:
					valores[0][0] = valores[0][0] + p.getMonto();
					break;
				case 2:
					valores[1][0] = valores[1][0] + p.getMonto();
					break;
				case 3:
					valores[2][0] = valores[2][0] + p.getMonto();
					break;
				case 4:
					valores[3][0] = valores[3][0] + p.getMonto();
					break;
				case 5:
					valores[4][0] = valores[4][0] + p.getMonto();
					break;
				case 6:
					valores[5][0] = valores[5][0] + p.getMonto();
					break;
				case 7:
					valores[6][0] = valores[6][0] + p.getMonto();
					break;
				case 8:
					valores[7][0] = valores[7][0] + p.getMonto();
					break;
				case 9:
					valores[8][0] = valores[8][0] + p.getMonto();
					break;
				case 10:
					valores[9][0] = valores[9][0] + p.getMonto();
					break;
				case 11:
					valores[10][0] = valores[10][0] + p.getMonto();
					break;
				case 12:
					valores[11][0] = valores[11][0] + p.getMonto();
					break;
				default:
					break;
				}
			}
		}
		
		for (int i = 1; i < valores.length+1; i++) {
			JLabel lblValorIng = new JLabel(String.valueOf(valores[i-1][0]));
			lblValorIng.setBounds(66,6+i*20,54,14);
			panel.add(lblValorIng);
			JLabel lblValorEg = new JLabel(String.valueOf(valores[i-1][1]));
			lblValorEg.setBounds(130,6+i*20,54,14);
			panel.add(lblValorEg);
		}
		//
		
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
