package viaggio.di.josh;

import viaggio.di.josh.Magia.Tipo;

public class Piovra {

	public static void main(String[] args) {
		Regione regione=new Regione();
		regione.aggiungiMostri();
		regione.stampaRegione();
		
		System.out.println(Tipo.valueOf("GHIACCIO"));

	}

}
