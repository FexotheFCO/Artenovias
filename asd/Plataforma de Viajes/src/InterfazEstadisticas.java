import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class InterfazEstadisticas extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public InterfazEstadisticas() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 261, 212);
		add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		
		table.setModel(viajesMasComprados(table.getModel()));

	}
	
DefaultTableModel viajesMasComprados(TableModel table) {
		
		DAOCompras daoCompras = new DAOCompras();
		
		DefaultTableModel modelo = (DefaultTableModel) table ;
		modelo.setRowCount(0);
		int[][] matriz = new int[10][2];
		
		for(Pasaje pasaje : daoCompras.obtenerTodosLosPasajes()) {
			int idViaje = pasaje.getIdViaje();
			System.out.println("Analizando Viaje id: "+idViaje);
			for (int i = 0; i < matriz.length; i++) {
				System.out.println("Renglon: "+ i +" Es "+matriz[i][0] );
				if(matriz[i][0] == 0) {
					matriz[i][0] = idViaje;
					matriz[i][1] = matriz[i][1] + 1; 
					break;
				}
				if(matriz[i][0] == idViaje) {
					matriz[i][1]++;
					break;
				}
			}
		}
		
		
		int idViaje = 0;
		int index = 0;
		int lugar = 0;
		
		do {
			if(matriz[lugar][0] == 0) {
				break;
			}
			int numeroMasAlto = 0;
			for(int i = lugar; i < matriz.length; i++) {
				if(matriz[i][0] != 0) {
					System.out.println("analizando esto con lugar"+i);
					System.out.println(matriz[i][0]+" caca "+matriz[i][1]);
					System.out.println(numeroMasAlto);
					if(matriz[i][1]>numeroMasAlto) {
						numeroMasAlto = matriz[i][1];
						idViaje = matriz[i][0];
						index=i;
					}
				}
			}
			if(lugar < matriz.length){
				System.out.println("numero Mas alto "+numeroMasAlto);
				int tempId = matriz[lugar][0],tempCant = matriz[lugar][1];
				System.out.println("en el lugar: "+lugar+" tenia id: "+tempId+" con cantidad "+tempCant);
				matriz[lugar][0] = idViaje;
				matriz[lugar][1] = numeroMasAlto;
				System.out.println("en el lugar: "+index+" tenia id: "+matriz[index][0]+" con cantidad "+matriz[index][1]);
				matriz[index][0] = tempId;
				matriz[index][1] = tempCant;
			}
			lugar++;
		}while(lugar<matriz.length);
		
		
		for (int i = 0; i < matriz.length; i++) {
			Object[] linea = {matriz[i][0],matriz[i][1]};
			modelo.addRow(linea);
		}
		
		return modelo;
		
	}
	
DefaultTableModel lugaresMasVisitados(TableModel table) {
	DAOCompras daoCompras = new DAOCompras();
		
	DefaultTableModel modelo = (DefaultTableModel) table ;
	modelo.setRowCount(0);
	int[][] matriz = new int[10][2];
		
	for(Pasaje pasaje : daoCompras.obtenerTodosLosPasajes()) {
		int idViaje = pasaje.getIdViaje();
		System.out.println("Analizando Viaje id: "+idViaje);
		for (int i = 0; i < matriz.length; i++) {
			System.out.println("Renglon: "+ i +" Es "+matriz[i][0] );
			if(matriz[i][0] == 0) {
				matriz[i][0] = idViaje;
				matriz[i][1] = matriz[i][1] + 1; 
				break;
			}
			if(matriz[i][0] == idViaje) {
				matriz[i][1]++;
				break;
			}
		}
	}
		
		
	int idViaje = 0;
	int index = 0;
	int lugar = 0;
		
	do {
		if(matriz[lugar][0] == 0) {
			break;
		}
		int numeroMasAlto = 0;
		for(int i = lugar; i < matriz.length; i++) {
			if(matriz[i][0] != 0) {
				System.out.println("analizando esto con lugar"+i);
				System.out.println(matriz[i][0]+" caca "+matriz[i][1]);
				System.out.println(numeroMasAlto);
				if(matriz[i][1]>numeroMasAlto) {
					numeroMasAlto = matriz[i][1];
					idViaje = matriz[i][0];
					index=i;
				}
			}
		}
		if(lugar < matriz.length){
			System.out.println("numero Mas alto "+numeroMasAlto);
			int tempId = matriz[lugar][0],tempCant = matriz[lugar][1];
			System.out.println("en el lugar: "+lugar+" tenia id: "+tempId+" con cantidad "+tempCant);
			matriz[lugar][0] = idViaje;
			matriz[lugar][1] = numeroMasAlto;
			System.out.println("en el lugar: "+index+" tenia id: "+matriz[index][0]+" con cantidad "+matriz[index][1]);
			matriz[index][0] = tempId;
			matriz[index][1] = tempCant;
		}
		lugar++;
	}while(lugar<matriz.length);
			
	for (int i = 0; i < matriz.length; i++) {
		Object[] linea = {matriz[i][0],matriz[i][1]};
		modelo.addRow(linea);
	}
			
		return modelo;
}}
