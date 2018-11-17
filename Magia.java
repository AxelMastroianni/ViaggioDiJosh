package viaggio.di.josh;

public class Magia {
	
	public enum Tipo{NORMALE,GHIACCIO,FULMINE,FUOCO};
	private String nome="";
	private int danno=0;
	private static final int DANNO_BASE=10;
	
	public Magia(String nome, String tipo) {
		this.nome=nome;
		tipo=tipo.toUpperCase();
		switch (Tipo.valueOf(tipo)) {
		case NORMALE:
			danno=3;
			break;
		case GHIACCIO:
			danno=DANNO_BASE*2; break;
		case FULMINE:
			danno=DANNO_BASE*3; break;
		case FUOCO:
			danno=DANNO_BASE*4; break;
		default:
			break;
		}
	}

}
