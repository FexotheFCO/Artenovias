package modelo;
import javax.swing.JFrame;

import dao.DaoArticulo;
import interfaz.InterfazArticulos;
import interfaz.InterfazCliente;
import interfaz.InterfazEmpresa;

public class App {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		DaoArticulo daoArticulo = new DaoArticulo();
		Empresa empresa = new Empresa(daoArticulo.devolverTodosLosArticulos());
		
		InterfazArticulos articulos = new InterfazArticulos(frame,empresa);
		InterfazEmpresa interfazEmpresa = new InterfazEmpresa(frame,empresa);
		
		frame.setContentPane(interfazEmpresa);
		frame.setVisible(true);
		frame.setBounds(0, 0, 400, 200);
	}

}
