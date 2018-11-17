package viaggio.di.josh;

public class Josh {
	
	private static String[] magie=new String[] {"Freccia Magica", "Freccia di Ghiaccio","Freccia Fulminea",
			"Freccia Infuocata","Prigione di Ghiaccio","Tempesta di Fulmini","Cerchio Infuocato"};
	private Bastone mioBastone;
	private Mantello mioMantello;
	private int intelligenza=0;
	private int attaccoMagico=0;
	private int difesa=0;
	private int difesaMagica=0;
	private int livello=0;
	private int vita=0;
	private int mana=0;
	private int esperienza=0;
	
	public Josh() {
		livello=1;
		vita=10;
		mana=10;
		esperienza=10;
		intelligenza=20;
		attaccoMagico=5;
		difesa=3;
		difesaMagica=10;
	}

}
