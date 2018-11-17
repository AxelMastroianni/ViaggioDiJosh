package viaggio.di.josh;

public abstract class Bastone {
	
	private int intelligenza=0;
	private int attaccoMagico=0;
	private int durabilita=0;
	
	public Bastone() {
		
	}

	public int getIntelligenza() {
		return intelligenza;
	}

	public void setIntelligenza(int intelligenza) {
		this.intelligenza = intelligenza;
	}

	public int getAttaccoMagico() {
		return attaccoMagico;
	}

	public void setAttaccoMagico(int attaccoMagico) {
		this.attaccoMagico = attaccoMagico;
	}

	public int getDurabilita() {
		return durabilita;
	}

	public void setDurabilita(int durabilita) {
		this.durabilita = durabilita;
	}
	
	public abstract void attaccaMostro(Mostro mostro);

}
