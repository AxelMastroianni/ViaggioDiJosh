package quest.di.mileto;

public class Partecipante {
	
	private int eta=0;
	private int peso=0;
	private int anniPratica=0;
	private int targhetta=0;
	
	public Partecipante(int eta, int peso, int anniPratica,int targhetta) {
		this.eta=eta;
		this.peso=peso;
		this.anniPratica=anniPratica;
		this.targhetta=targhetta;
	}

	public int getTarghetta() {
		return targhetta;
	}

	public void setTarghetta(int targhetta) {
		this.targhetta = targhetta;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAnniPratica() {
		return anniPratica;
	}

	public void setAnniPratica(int anniPratica) {
		this.anniPratica = anniPratica;
	}

}
