package modelo;
import javax.swing.JFrame;

import interfaz.InterfazCliente;
import interfaz.InterfazEmpresa;

public class App {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		InterfazEmpresa empresa = new InterfazEmpresa(frame);
		frame.setContentPane(empresa);
		frame.setVisible(true);
		frame.setBounds(0, 0, 400, 200);
	}

}
