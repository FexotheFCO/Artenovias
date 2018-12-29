package modelo;

public class Vestido {
	
	//Atributos
	private int id;
	private int valor;
	
	//Medidas
	private int talleDelantero;
	private int talleTrasero;
	private int hombro;
	private int alturaHombro;
	private int espalda;
	private int pecho;
	private int pinza;
	private int bajoSisa;
	private int busto;
	private int bustoDelantero;
	private int contornoBustoSup;
	private int contornoBustoInf;
	private int centroBusto;
	private int cintura;
	private int cadera;
	private int escoteDelantero;
	private int escoteTrasero;
	private int pico;
	private int largoFaldaLarga;
	private int largoFaldaCorta;
	private int arrastre;
	//Manga
	private int largo;
	private int ancho;
	private int puño;
	private int largoCascada;
	
	public Vestido(int id, int valor, int talleDelantero, int talleTrasero, int hombro, int alturaHombro,
			int espalda, int pecho, int pinza, int bajoSisa, int busto, int bustoDelantero, int contornoBustoSup,
			int contornoBustoInf, int centroBusto, int cintura, int cadera, int escoteDelantero, int escoteTrasero,
			int pico, int largoFaldaLarga, int largoFaldaCorta, int arrastre, int largo, int ancho, int puño,
			int largoCascada) {
		super();
		this.id = id;
		this.valor = valor;
		//talles
		this.talleDelantero = talleDelantero;
		this.talleTrasero = talleTrasero;
		this.hombro = hombro;
		this.alturaHombro = alturaHombro;
		this.espalda = espalda;
		this.pecho = pecho;
		this.pinza = pinza;
		this.bajoSisa = bajoSisa;
		this.busto = busto;
		this.bustoDelantero = bustoDelantero;
		this.contornoBustoSup = contornoBustoSup;
		this.contornoBustoInf = contornoBustoInf;
		this.centroBusto = centroBusto;
		this.cintura = cintura;
		this.cadera = cadera;
		this.escoteDelantero = escoteDelantero;
		this.escoteTrasero = escoteTrasero;
		this.pico = pico;
		this.largoFaldaLarga = largoFaldaLarga;
		this.largoFaldaCorta = largoFaldaCorta;
		this.arrastre = arrastre;
		this.largo = largo;
		this.ancho = ancho;
		this.puño = puño;
		this.largoCascada = largoCascada;
	}
	
	
	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public int getTalleDelantero() {
		return talleDelantero;
	}

	public void setTalleDelantero(int talleDelantero) {
		this.talleDelantero = talleDelantero;
	}

	public int getTalleTrasero() {
		return talleTrasero;
	}

	public void setTalleTrasero(int talleTrasero) {
		this.talleTrasero = talleTrasero;
	}

	public int getHombro() {
		return hombro;
	}

	public void setHombro(int hombro) {
		this.hombro = hombro;
	}

	public int getAlturaHombro() {
		return alturaHombro;
	}

	public void setAlturaHombro(int alturaHombro) {
		this.alturaHombro = alturaHombro;
	}

	public int getEspalda() {
		return espalda;
	}

	public void setEspalda(int espalda) {
		this.espalda = espalda;
	}

	public int getPecho() {
		return pecho;
	}

	public void setPecho(int pecho) {
		this.pecho = pecho;
	}

	public int getPinza() {
		return pinza;
	}

	public void setPinza(int pinza) {
		this.pinza = pinza;
	}

	public int getBajoSisa() {
		return bajoSisa;
	}

	public void setBajoSisa(int bajoSisa) {
		this.bajoSisa = bajoSisa;
	}

	public int getBusto() {
		return busto;
	}

	public void setBusto(int busto) {
		this.busto = busto;
	}

	public int getBustoDelantero() {
		return bustoDelantero;
	}

	public void setBustoDelantero(int bustoDelantero) {
		this.bustoDelantero = bustoDelantero;
	}

	public int getContornoBustoSup() {
		return contornoBustoSup;
	}

	public void setContornoBustoSup(int contornoBustoSup) {
		this.contornoBustoSup = contornoBustoSup;
	}

	public int getContornoBustoInf() {
		return contornoBustoInf;
	}

	public void setContornoBustoInf(int contornoBustoInf) {
		this.contornoBustoInf = contornoBustoInf;
	}

	public int getCentroBusto() {
		return centroBusto;
	}

	public void setCentroBusto(int centroBusto) {
		this.centroBusto = centroBusto;
	}

	public int getCintura() {
		return cintura;
	}

	public void setCintura(int cintura) {
		this.cintura = cintura;
	}

	public int getCadera() {
		return cadera;
	}

	public void setCadera(int cadera) {
		this.cadera = cadera;
	}

	public int getEscoteDelantero() {
		return escoteDelantero;
	}

	public void setEscoteDelantero(int escoteDelantero) {
		this.escoteDelantero = escoteDelantero;
	}

	public int getEscoteTrasero() {
		return escoteTrasero;
	}

	public void setEscoteTrasero(int escoteTrasero) {
		this.escoteTrasero = escoteTrasero;
	}

	public int getPico() {
		return pico;
	}

	public void setPico(int pico) {
		this.pico = pico;
	}

	public int getLargoFaldaLarga() {
		return largoFaldaLarga;
	}

	public void setLargoFaldaLarga(int largoFaldaLarga) {
		this.largoFaldaLarga = largoFaldaLarga;
	}

	public int getLargoFaldaCorta() {
		return largoFaldaCorta;
	}

	public void setLargoFaldaCorta(int largoFaldaCorta) {
		this.largoFaldaCorta = largoFaldaCorta;
	}

	public int getArrastre() {
		return arrastre;
	}

	public void setArrastre(int arrastre) {
		this.arrastre = arrastre;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getPuño() {
		return puño;
	}

	public void setPuño(int puño) {
		this.puño = puño;
	}

	public int getLargoCascada() {
		return largoCascada;
	}

	public void setLargoCascada(int largoCascada) {
		this.largoCascada = largoCascada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
