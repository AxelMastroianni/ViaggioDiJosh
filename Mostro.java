package viaggio.di.josh;
import java.util.Random;

public class Mostro {
	
	private static final int VITA_MASSIMA=80;
	private String nome="";
	private int vita=0;
	private int livello=0;
	private Random r=new Random();
	
	public Mostro(String nome, int minimoLivello, int massimoLivello) {
		this.nome=nome;
		livello=r.nextInt()%(massimoLivello-minimoLivello)+minimoLivello+1;
		vita=VITA_MASSIMA/livello;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

}
