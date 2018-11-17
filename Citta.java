package viaggio.di.josh;
import java.util.Random;

public class Citta {
	
	public static final int MASSIMIABITANTI=20;
	private String nome="";
	private int numAbitanti=0;
	private Random r = new Random();
	
	public Citta(String nome) {
		this.nome=nome;
		numAbitanti=Math.abs(r.nextInt()%MASSIMIABITANTI);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumAbitanti() {
		return numAbitanti;
	}

	public void setNumAbitanti(int numAbitanti) {
		this.numAbitanti = numAbitanti;
	}
	

}
