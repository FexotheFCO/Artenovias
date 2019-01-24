package interfaz;

import javax.swing.JPanel;

import modelo.Cliente;
import modelo.Empresa;
import modelo.Vestido;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import dao.DaoVestido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazVestido extends JPanel {
	private JTextField textFieldTalleDelantero;
	private JTextField textFieldTalleTrasero;
	private JTextField textFieldHombro;
	private JTextField textFieldAlturaHombro;
	private JTextField textFieldEspalda;
	private JTextField textFieldPecho;
	private JTextField textFieldPinza;
	private JTextField textFieldBajoSisa;
	private JTextField textFieldBusto;
	private JTextField textFieldBustoDelantero;
	private JTextField textFieldContornoBustoSup;
	private JTextField textFieldContornoBustoInf;
	private JTextField textFieldCentroBusto;
	private JTextField textFieldCintura;
	private JTextField textFieldCadera;
	private JTextField textFieldEscoteDelantero;
	private JTextField textFieldEscoteTrasero;
	private JTextField textFieldPico;
	private JTextField textFieldLargoFaldaLarga;
	private JTextField textFieldLargoFaldaCorta;
	private JTextField textFieldArrastre;
	private JTextField textFieldLargo;
	private JTextField textFieldAncho;
	private JTextField textFieldPuño;
	private JTextField textFieldLargoCascada;
	private JTextField textFieldValor;
	
	JLabel lblTextLargoCasaca = new JLabel();
	JLabel lblValor = new JLabel();
	JLabel lblTextTalleDelantero = new JLabel();
	JLabel lblTextTalleTrasero = new JLabel();
	JLabel lblTextPuño = new JLabel();
	JLabel lblTextAncho = new JLabel();
	JLabel lblTextLargo = new JLabel();
	JLabel lblTextArrastra = new JLabel();
	JLabel lblTextLargoFaldaCorta = new JLabel();
	JLabel lblTextLargoFaldaLarga = new JLabel();
	JLabel lblTextPico = new JLabel();
	JLabel lblTextEscoteTrasero = new JLabel();
	JLabel lblTextEscoteDelantero = new JLabel();
	JLabel lblTextCadera = new JLabel();
	JLabel lblTextCentroBusto = new JLabel();
	JLabel lblTextCintura = new JLabel();
	JLabel lblTextContornoBustoInf = new JLabel();
	JLabel lblTextContornoBustoSup = new JLabel();
	JLabel lblTextBustoDelantero = new JLabel();
	JLabel lblTextBusto = new JLabel();
	JLabel lblTextBajoSisa = new JLabel();
	JLabel lblTextPinza = new JLabel();
	JLabel lblTextPecho = new JLabel();
	JLabel lblTextEspalda = new JLabel();
	JLabel lblTextAlturaHombro = new JLabel();
	JLabel lblTextHombro = new JLabel();
	Vestido vestido;
	
	public InterfazVestido(JFrame frame,Cliente cliente,Empresa empresa) {
		setLayout(null);
		frame.setBounds(0,0,435,775);
		vestido = cliente.getVestido();
		actualizarResultados(vestido);
		
		//Labels Fijos
		JLabel lblVestido = new JLabel("Vestido");
		lblVestido.setBounds(10, 11, 160, 14);
		add(lblVestido);
		
		JLabel lblTalleDelantero = new JLabel("Talle Delantero");
		lblTalleDelantero.setBounds(10, 61, 160, 14);
		add(lblTalleDelantero);
		
		JLabel lblTalleTrasero = new JLabel("Talle Trasero");
		lblTalleTrasero.setBounds(10, 86, 160, 14);
		add(lblTalleTrasero);
		
		JLabel lblHombro = new JLabel("Hombro");
		lblHombro.setBounds(10, 111, 160, 14);
		add(lblHombro);
		
		JLabel lblAlturaHombro = new JLabel("Altura Hombro");
		lblAlturaHombro.setBounds(10, 136, 160, 14);
		add(lblAlturaHombro);
		
		JLabel lblEspalda = new JLabel("Espalda");
		lblEspalda.setBounds(10, 161, 160, 14);
		add(lblEspalda);
		
		JLabel lblPecho = new JLabel("Pecho");
		lblPecho.setBounds(10, 186, 160, 14);
		add(lblPecho);
		
		JLabel lblPinza = new JLabel("Pinza");
		lblPinza.setBounds(10, 211, 160, 14);
		add(lblPinza);
		
		JLabel lblBajoSisa = new JLabel("Bajo Sisa");
		lblBajoSisa.setBounds(10, 236, 160, 14);
		add(lblBajoSisa);
		
		JLabel lblBusto = new JLabel("Busto");
		lblBusto.setBounds(10, 261, 160, 14);
		add(lblBusto);
		
		JLabel lblBustoDelantero = new JLabel("Busto Delantero");
		lblBustoDelantero.setBounds(10, 286, 160, 14);
		add(lblBustoDelantero);
		
		JLabel lblContornoBustoSup = new JLabel("Contorno Busto Sup.");
		lblContornoBustoSup.setBounds(10, 311, 160, 14);
		add(lblContornoBustoSup);
		
		JLabel lblContornoBustoInf = new JLabel("Contorno Busto Inf.");
		lblContornoBustoInf.setBounds(10, 336, 160, 14);
		add(lblContornoBustoInf);
		
		JLabel lblCentroBusto = new JLabel("Centro Busto");
		lblCentroBusto.setBounds(10, 361, 160, 14);
		add(lblCentroBusto);
		
		JLabel lblCintura = new JLabel("Cintura");
		lblCintura.setBounds(10, 386, 160, 14);
		add(lblCintura);
		
		JLabel lblCadera = new JLabel("Cadera");
		lblCadera.setBounds(10, 411, 160, 14);
		add(lblCadera);
		
		JLabel lblEscoteDelantero = new JLabel("Escote Delantero");
		lblEscoteDelantero.setBounds(10, 436, 160, 14);
		add(lblEscoteDelantero);
		
		JLabel lblEscoteTrasero = new JLabel("Escote Trasero");
		lblEscoteTrasero.setBounds(10, 461, 160, 14);
		add(lblEscoteTrasero);
		
		JLabel lblPico = new JLabel("Pico");
		lblPico.setBounds(10, 486, 160, 14);
		add(lblPico);
		
		JLabel lblLargoFaldaLarga = new JLabel("Largo Falda Larga");
		lblLargoFaldaLarga.setBounds(10, 511, 160, 14);
		add(lblLargoFaldaLarga);
		
		JLabel lblLargoFaldaCorta = new JLabel("Largo Falda Corta");
		lblLargoFaldaCorta.setBounds(10, 536, 160, 14);
		add(lblLargoFaldaCorta);
		
		JLabel lblArrastre = new JLabel("Arrastre");
		lblArrastre.setBounds(10, 561, 160, 14);
		add(lblArrastre);
		
		JLabel lblLargo = new JLabel("Largo");
		lblLargo.setBounds(10, 586, 160, 14);
		add(lblLargo);
		
		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setBounds(10, 611, 160, 14);
		add(lblAncho);
		
		JLabel lblPuo = new JLabel("Pu\u00F1o");
		lblPuo.setBounds(10, 636, 160, 14);
		add(lblPuo);
		
		JLabel lblLargoCasaca = new JLabel("Largo Casaca");
		lblLargoCasaca.setBounds(10, 661, 160, 14);
		add(lblLargoCasaca);
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBounds(180, 11, 230, 765);
		add(panelResultado);
		panelResultado.setLayout(null);
		
		//Textos
		//TODO cambiar todo esto a spinners y hacer el actualizador de resultados
		
		lblValor.setBounds(10, 25, 46, 14);
		panelResultado.add(lblValor);
		
		
		lblTextTalleDelantero.setBounds(10, 50, 160, 14);
		panelResultado.add(lblTextTalleDelantero);
		
		
		lblTextTalleTrasero.setBounds(10, 75, 160, 14);
		panelResultado.add(lblTextTalleTrasero);
		
		
		lblTextHombro.setBounds(10, 100, 160, 14);
		panelResultado.add(lblTextHombro);
		
		
		lblTextAlturaHombro.setBounds(10, 125, 160, 14);
		panelResultado.add(lblTextAlturaHombro);
		
		
		lblTextEspalda.setBounds(10, 150, 160, 14);
		panelResultado.add(lblTextEspalda);
		
		
		lblTextPecho.setBounds(10, 175, 160, 14);
		panelResultado.add(lblTextPecho);
		
		
		lblTextPinza.setBounds(10, 200, 160, 14);
		panelResultado.add(lblTextPinza);
		
		
		lblTextBajoSisa.setBounds(10, 225, 160, 14);
		panelResultado.add(lblTextBajoSisa);
		
		
		lblTextBusto.setBounds(10, 250, 160, 14);
		panelResultado.add(lblTextBusto);
		
		
		lblTextBustoDelantero.setBounds(10, 275, 160, 14);
		panelResultado.add(lblTextBustoDelantero);
		
		
		lblTextContornoBustoSup.setBounds(10, 300, 160, 14);
		panelResultado.add(lblTextContornoBustoSup);
		
		
		lblTextContornoBustoInf.setBounds(10, 325, 160, 14);
		panelResultado.add(lblTextContornoBustoInf);
		
		
		lblTextCentroBusto.setBounds(10, 350, 160, 14);
		panelResultado.add(lblTextCentroBusto);
		
		
		lblTextCintura.setBounds(10, 375, 160, 14);
		panelResultado.add(lblTextCintura);
		
		
		lblTextCadera.setBounds(10, 400, 160, 14);
		panelResultado.add(lblTextCadera);
		
		
		lblTextEscoteDelantero.setBounds(10, 425, 160, 14);
		panelResultado.add(lblTextEscoteDelantero);
		
		
		lblTextEscoteTrasero.setBounds(10, 450, 160, 14);
		panelResultado.add(lblTextEscoteTrasero);
		
		
		lblTextPico.setBounds(10, 475, 160, 14);
		panelResultado.add(lblTextPico);
		
		
		lblTextLargoFaldaLarga.setBounds(10, 500, 160, 14);
		panelResultado.add(lblTextLargoFaldaLarga);
		
		
		lblTextLargoFaldaCorta.setBounds(10, 525, 160, 14);
		panelResultado.add(lblTextLargoFaldaCorta);
		
		
		lblTextArrastra.setBounds(10, 550, 160, 14);
		panelResultado.add(lblTextArrastra);
		
		
		lblTextLargo.setBounds(10, 575, 160, 14);
		panelResultado.add(lblTextLargo);
		
		
		lblTextAncho.setBounds(10, 600, 160, 14);
		panelResultado.add(lblTextAncho);
		
		
		lblTextPuño.setBounds(10, 625, 160, 14);
		panelResultado.add(lblTextPuño);
		
		
		lblTextLargoCasaca.setBounds(10, 650, 160, 14);
		panelResultado.add(lblTextLargoCasaca);
		
		//Edicion
		JPanel panelEdicion = new JPanel();
		panelEdicion.setBounds(180, 11, 230, 765);
		add(panelEdicion);
		panelEdicion.setLayout(null);
		panelEdicion.setVisible(false);
		
		textFieldTalleDelantero = new JTextField();
		textFieldTalleDelantero.setBounds(10, 50, 210, 14);
		panelEdicion.add(textFieldTalleDelantero);
		textFieldTalleDelantero.setColumns(10);
		
		textFieldTalleTrasero = new JTextField();
		textFieldTalleTrasero.setBounds(10, 75, 210, 14);
		panelEdicion.add(textFieldTalleTrasero);
		textFieldTalleTrasero.setColumns(10);
		
		textFieldHombro = new JTextField();
		textFieldHombro.setColumns(10);
		textFieldHombro.setBounds(10, 100, 210, 14);
		panelEdicion.add(textFieldHombro);
		
		textFieldAlturaHombro = new JTextField();
		textFieldAlturaHombro.setColumns(10);
		textFieldAlturaHombro.setBounds(10, 125, 210, 14);
		panelEdicion.add(textFieldAlturaHombro);
		
		textFieldEspalda = new JTextField();
		textFieldEspalda.setColumns(10);
		textFieldEspalda.setBounds(10, 150, 210, 14);
		panelEdicion.add(textFieldEspalda);
		
		textFieldPecho = new JTextField();
		textFieldPecho.setColumns(10);
		textFieldPecho.setBounds(10, 175, 210, 14);
		panelEdicion.add(textFieldPecho);
		
		textFieldPinza = new JTextField();
		textFieldPinza.setColumns(10);
		textFieldPinza.setBounds(10, 200, 210, 14);
		panelEdicion.add(textFieldPinza);
		
		textFieldBajoSisa = new JTextField();
		textFieldBajoSisa.setColumns(10);
		textFieldBajoSisa.setBounds(10, 225, 210, 14);
		panelEdicion.add(textFieldBajoSisa);
		
		textFieldBusto = new JTextField();
		textFieldBusto.setColumns(10);
		textFieldBusto.setBounds(10, 250, 210, 14);
		panelEdicion.add(textFieldBusto);
		
		textFieldBustoDelantero = new JTextField();
		textFieldBustoDelantero.setColumns(10);
		textFieldBustoDelantero.setBounds(10, 275, 210, 14);
		panelEdicion.add(textFieldBustoDelantero);
		
		textFieldContornoBustoSup = new JTextField();
		textFieldContornoBustoSup.setColumns(10);
		textFieldContornoBustoSup.setBounds(10, 300, 210, 14);
		panelEdicion.add(textFieldContornoBustoSup);
		
		textFieldContornoBustoInf = new JTextField();
		textFieldContornoBustoInf.setColumns(10);
		textFieldContornoBustoInf.setBounds(10, 325, 210, 14);
		panelEdicion.add(textFieldContornoBustoInf);
		
		textFieldCentroBusto = new JTextField();
		textFieldCentroBusto.setColumns(10);
		textFieldCentroBusto.setBounds(10, 350, 210, 14);
		panelEdicion.add(textFieldCentroBusto);
		
		textFieldCintura = new JTextField();
		textFieldCintura.setColumns(10);
		textFieldCintura.setBounds(10, 375, 210, 14);
		panelEdicion.add(textFieldCintura);
		
		textFieldCadera = new JTextField();
		textFieldCadera.setColumns(10);
		textFieldCadera.setBounds(10, 400, 210, 14);
		panelEdicion.add(textFieldCadera);
		
		textFieldEscoteDelantero = new JTextField();
		textFieldEscoteDelantero.setColumns(10);
		textFieldEscoteDelantero.setBounds(10, 425, 210, 14);
		panelEdicion.add(textFieldEscoteDelantero);
		
		textFieldEscoteTrasero = new JTextField();
		textFieldEscoteTrasero.setColumns(10);
		textFieldEscoteTrasero.setBounds(10, 450, 210, 14);
		panelEdicion.add(textFieldEscoteTrasero);
		
		textFieldPico = new JTextField();
		textFieldPico.setColumns(10);
		textFieldPico.setBounds(10, 475, 210, 14);
		panelEdicion.add(textFieldPico);
		
		textFieldLargoFaldaLarga = new JTextField();
		textFieldLargoFaldaLarga.setColumns(10);
		textFieldLargoFaldaLarga.setBounds(10, 500, 210, 14);
		panelEdicion.add(textFieldLargoFaldaLarga);
		
		textFieldLargoFaldaCorta = new JTextField();
		textFieldLargoFaldaCorta.setColumns(10);
		textFieldLargoFaldaCorta.setBounds(10, 525, 210, 14);
		panelEdicion.add(textFieldLargoFaldaCorta);
		
		textFieldArrastre = new JTextField();
		textFieldArrastre.setColumns(10);
		textFieldArrastre.setBounds(10, 550, 210, 14);
		panelEdicion.add(textFieldArrastre);
		
		textFieldLargo = new JTextField();
		textFieldLargo.setColumns(10);
		textFieldLargo.setBounds(10, 575, 210, 14);
		panelEdicion.add(textFieldLargo);
		
		textFieldAncho = new JTextField();
		textFieldAncho.setColumns(10);
		textFieldAncho.setBounds(10, 600, 210, 14);
		panelEdicion.add(textFieldAncho);
		
		textFieldPuño = new JTextField();
		textFieldPuño.setColumns(10);
		textFieldPuño.setBounds(10, 625, 210, 14);
		panelEdicion.add(textFieldPuño);
		
		textFieldLargoCascada = new JTextField();
		textFieldLargoCascada.setColumns(10);
		textFieldLargoCascada.setBounds(10, 650, 210, 14);
		panelEdicion.add(textFieldLargoCascada);
		
		//Botones
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(74, 682, 89, 23);
		panelEdicion.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(74, 716, 89, 23);
		panelEdicion.add(btnCancelar);
		
		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(10, 25, 210, 14);
		panelEdicion.add(textFieldValor);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(61, 686, 89, 23);
		panelResultado.add(btnEditar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(27, 700, 89, 23);
		add(btnAtras);
		
		JLabel lblValor_1 = new JLabel("Valor");
		lblValor_1.setBounds(10, 36, 160, 14);
		add(lblValor_1);
		
		//Atras
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setContentPane(new InterfazCliente(frame,cliente,empresa));
			}
		});
		
		//Cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResultado.setVisible(true);
				panelEdicion.setVisible(false);
			}
		});
		
		//Confirmar
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = Integer.valueOf(textFieldValor.getText());
				//TODO Hacer el boton de confirmar y poner el update del DAO
				int talleDelantero = Integer.valueOf(textFieldTalleDelantero.getText());
				int talleTrasero = Integer.valueOf(textFieldTalleTrasero.getText());
				int hombro = Integer.valueOf(textFieldHombro.getText());
				int alturaHombro= Integer.valueOf(textFieldAlturaHombro.getText());
				int espalda= Integer.valueOf(textFieldEspalda.getText());
				int pecho = Integer.valueOf(textFieldPecho.getText());
				int pinza = Integer.valueOf(textFieldPinza.getText());
				int bajoSisa = Integer.valueOf(textFieldBajoSisa.getText());
				int busto = Integer.valueOf(textFieldBusto.getText());
				int bustoDelantero = Integer.valueOf(textFieldBustoDelantero.getText());
				int contornoBustoSup = Integer.valueOf(textFieldContornoBustoSup.getText());
				int contornoBustoInf = Integer.valueOf(textFieldContornoBustoInf.getText());
				int centroBusto = Integer.valueOf(textFieldCentroBusto.getText());
				int cintura = Integer.valueOf(textFieldCintura.getText());
				int cadera = Integer.valueOf(textFieldCadera.getText());
				int escoteDelantero = Integer.valueOf(textFieldEscoteDelantero.getText());
				int escoteTrasero = Integer.valueOf(textFieldEscoteTrasero.getText());
				int pico = Integer.valueOf(textFieldPico.getText());
				int largoFaldaLarga = Integer.valueOf(textFieldLargoFaldaLarga.getText());
				int largoFaldaCorta = Integer.valueOf(textFieldLargoFaldaCorta.getText());
				int arrastre = Integer.valueOf(textFieldArrastre.getText());
				//Manga
				int largo = Integer.valueOf(textFieldLargo.getText());
				int ancho = Integer.valueOf(textFieldAncho.getText());
				int puño = Integer.valueOf(textFieldPuño.getText());
				int largoCascada = Integer.valueOf(textFieldLargoCascada.getText());
				cliente.editarVestido(new Vestido(vestido.getId(),valor,talleDelantero,talleTrasero,hombro,alturaHombro,espalda,pecho,pinza,bajoSisa,busto,bustoDelantero,
						contornoBustoSup,contornoBustoInf,centroBusto,cintura,cadera,escoteDelantero,escoteTrasero,pico,largoFaldaLarga,largoFaldaCorta,arrastre,
						largo,ancho,puño,largoCascada));
				actualizarResultados(cliente.getVestido());
				panelResultado.setVisible(true);
				panelEdicion.setVisible(false);
			}
		});
		
		//Editar
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelResultado.setVisible(false);
				panelEdicion.setVisible(true);
			}
		});
	}
	
	//actualizar resultados
	public void actualizarResultados(Vestido vestido) {
		lblTextLargoCasaca.setText(String.valueOf(vestido.getLargoCascada()));
		lblTextPuño.setText(String.valueOf(vestido.getPuño()));
		lblTextAncho.setText(String.valueOf(vestido.getAncho()));
		lblTextLargo.setText(String.valueOf(vestido.getLargo()));
		lblTextArrastra.setText(String.valueOf(vestido.getArrastre()));
		lblTextLargoFaldaCorta.setText(String.valueOf(vestido.getLargoFaldaCorta()));
		lblTextLargoFaldaLarga.setText(String.valueOf(vestido.getLargoFaldaLarga()));
		lblTextPico.setText(String.valueOf(vestido.getPico()));
		lblTextEscoteTrasero.setText(String.valueOf(vestido.getEscoteTrasero()));
		lblTextEscoteDelantero.setText(String.valueOf(vestido.getEscoteDelantero()));
		lblTextCadera.setText(String.valueOf(vestido.getCadera()));
		lblTextCintura.setText(String.valueOf(vestido.getCintura()));
		lblTextCentroBusto.setText(String.valueOf(vestido.getCentroBusto()));
		lblTextContornoBustoInf.setText(String.valueOf(vestido.getContornoBustoInf()));
		lblTextContornoBustoSup.setText(String.valueOf(vestido.getContornoBustoSup()));
		lblTextBustoDelantero.setText(String.valueOf(vestido.getBustoDelantero()));
		lblTextBusto.setText(String.valueOf(vestido.getBusto()));
		lblTextBajoSisa.setText(String.valueOf(vestido.getBajoSisa()));
		lblTextPinza.setText(String.valueOf(vestido.getPinza()));
		lblTextPecho.setText(String.valueOf(vestido.getPecho()));
		lblTextEspalda.setText(String.valueOf(vestido.getEspalda()));
		lblTextAlturaHombro.setText(String.valueOf(vestido.getAlturaHombro()));
		lblTextHombro.setText(String.valueOf(vestido.getHombro()));
		lblTextTalleTrasero.setText(String.valueOf(vestido.getTalleTrasero()));
		lblTextTalleDelantero.setText(String.valueOf(vestido.getTalleDelantero()));
		lblValor.setText(String.valueOf(vestido.getValor()));
	}
}
