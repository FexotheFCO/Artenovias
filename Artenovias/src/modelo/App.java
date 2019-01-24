package modelo;
import javax.swing.JFrame;

import dao.DaoArticulo;
import dao.DaoCliente;
import interfaz.InterfazArticulos;
import interfaz.InterfazBalance;
import interfaz.InterfazCliente;
import interfaz.InterfazMenu;

public class App {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		DaoArticulo daoArticulo = new DaoArticulo();
		DaoCliente	daoCliente = new DaoCliente();
		Empresa empresa = new Empresa(daoArticulo.devolverTodosLosArticulos(),daoCliente.devolverTodosLosClientes());
		InterfazMenu interfazMenu = new InterfazMenu(frame,empresa);
		InterfazBalance intbalance = new InterfazBalance(frame,empresa);
		
		frame.setContentPane(intbalance);
		frame.setVisible(true);
		frame.setBounds(0, 0, 400, 200);
	}

}
