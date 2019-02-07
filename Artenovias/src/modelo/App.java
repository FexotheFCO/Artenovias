package modelo;
import java.util.ArrayList;

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
		Empresa empresa = new Empresa(daoArticulo.devolverTodosLosArticulosDisponibles(),daoCliente.devolverTodosLosClientes());
		InterfazMenu interfazMenu = new InterfazMenu(frame,empresa);
		
		frame.setContentPane(interfazMenu);
		frame.setVisible(true);
	}

}
