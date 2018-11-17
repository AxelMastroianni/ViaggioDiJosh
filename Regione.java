package viaggio.di.josh;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
public class Regione {
	
	public static final String[] capoluoghi=new String[] {"Kazuma","Ichigo","Kirito","Sagiri",
			"Albanova","Ciclamipoli","Gamipoli","Tentaculus"};
	public static final String[] paesi=new String[] {"Mileto","Pitone","Denisa","Ascella",
			"Loli","Piovra","Hueco Mundo","Aizen","Ulqiorra","Ywatch","Haschwalt",
			"Kenpachi","Rukongai","Castel Goffredo","Albalonga","Jurassic World","Area 51",
			"Nasa","Hero Academia","Saitama","Nihon","Oxford","Kyojin",
			"Karakura","Soul Society","Brescia","Pettegola","Dragon"};
	public static final String[] nomiMostri=new String[] {"Gelatiglio","Draghetto","Coyote Affamato",
			"Lupo Solitario","Ape Gigante","Avvoltoio Delle Ande","Dilofosauro","Ragno Tessitore",
			"Orso Bianco","Pinguino Imperatore","Cinghiale","Orso Bruno","Spirito di Saetti",
			"Spirito di Serina","Falco Pellegrino"};
	private static final int PAESI_PER_CAPOLUOGO=4;
	private static final int MOSTRI_PER_CAPOLUOGO=2;
	private Map<Integer,LinkedList<Citta>> regione=new HashMap<Integer,LinkedList<Citta>>();
	private Map<Integer,LinkedList<Mostro>> mostri=new HashMap<Integer,LinkedList<Mostro>>();
	private String nome="";
	
	public Regione() {
		nome="Octopus";
		int conta=0;
		for(int i=0;i<capoluoghi.length;i++) {
			regione.put(i, new LinkedList<Citta>());
			LinkedList<Citta> vicine=regione.get(i);
			for(int j=0;j<PAESI_PER_CAPOLUOGO && i!=capoluoghi.length-1;j++) {
				vicine.add(new Citta(paesi[conta++]));
			}
		}
	}
	
	public void stampaRegione() {
		for(int i=0;i<regione.size();i++) {
			System.out.println("Capoluogo: "+capoluoghi[i]);
			LinkedList<Citta> vicine=regione.get(i);
			LinkedList<Mostro> mostriPresenti=mostri.get(i);
			if(vicine.size()!=0)
				System.out.println("Collegato a: ");
			for(int j=0;j<vicine.size();j++) {
				System.out.println(vicine.get(j).getNome());
			}
			System.out.println("Sono presenti i seguenti mostri: ");
			for(int j=0;j<mostriPresenti.size();j++)
				System.out.println(mostriPresenti.get(j).getNome());
			System.out.println("------------------");
		}
	}
	
	public void aggiungiMostri() {
		int conta=0;
		for(int i=0;i<capoluoghi.length;i++) {
			mostri.put(i, new LinkedList<Mostro>());
			LinkedList<Mostro> mostriCapoluogo=mostri.get(i);
			for(int j=0;j<MOSTRI_PER_CAPOLUOGO;j++) {
				if(i!=capoluoghi.length-1) {
					switch(capoluoghi[i]) {
					case "Kazuma":
						mostriCapoluogo.add(new Mostro(nomiMostri[conta++],0,10)); break;
					case "Ichigo":
						mostriCapoluogo.add(new Mostro(nomiMostri[conta++],10,20)); break;
					case "Kirito":
						mostriCapoluogo.add(new Mostro(nomiMostri[conta++],20,30));break;
					case "Sagiri":
						mostriCapoluogo.add(new Mostro(nomiMostri[conta++],30,40)); break;
					case "Albanova":
						mostriCapoluogo.add(new Mostro(nomiMostri[conta++],40,50)); break;
					case "Ciclamipoli":
						mostriCapoluogo.add(new Mostro(nomiMostri[conta++],50,60)); break;
					case "Gamipoli":
						mostriCapoluogo.add(new Mostro(nomiMostri[conta++],60,70));break;
					default: break;
					}
				}
				else {
					mostriCapoluogo.add(new Mostro(nomiMostri[conta],79,80));//sempre di livello 80
					break;
				}
			}
		}
	}

}
