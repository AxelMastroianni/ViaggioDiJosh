package quest.di.mileto;

import java.util.LinkedList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Classifica {
	
	private final int ETA_MINIMA=14;
	private final int ETA_MASSIMA=50;
	private final int PESO_MINIMO=40;
	private final int PESO_MASSIMO=120;
	private final int ESPERIENZA_MINIMA=0;
	private final int ESPERIENZA_MASSIMA=20;
	private int numeroPartecipanti=0;
	private Random r=new Random();
	private LinkedList<Partecipante> listaSupporto1=new LinkedList<Partecipante>();
	private LinkedList<Partecipante> listaSupporto2=new LinkedList<Partecipante>();
	
	public Classifica(int numeroPartecipanti) {
		this.numeroPartecipanti=numeroPartecipanti;
	}
	
	public void creaListaPartecipanti() {
		for(int i=0;i<numeroPartecipanti;i++) {
			int eta=Math.abs(r.nextInt()%(ETA_MASSIMA-ETA_MINIMA))+ETA_MINIMA;
			int peso=Math.abs(r.nextInt()%(PESO_MASSIMO-PESO_MINIMO))+PESO_MINIMO;
			int anniEsperienza=Math.abs(r.nextInt()%(ESPERIENZA_MASSIMA-ESPERIENZA_MINIMA))+ESPERIENZA_MINIMA;
			listaSupporto1.add(new Partecipante(eta,peso,anniEsperienza,i));
		}
	}
	/**
	 * ordina i partecipanti in base all'età: in sintesi cerca il minimo nella prima lista,
	 * glielo rimuove e lo mette in un'altra lista vuota che conterrà i valori ordinati
	 */
	public void ordinamentoEta() {
		if(listaSupporto1.isEmpty())
			return; //termina quando la prima lista è vuota
		int indirizzoMinimo=cercaMin(); //cerca l'indirizzo del minimo nella prima lista
		listaSupporto2.add(listaSupporto1.remove(indirizzoMinimo)); //rimuovi il minimo dalla lista 1 e dallo alla 2
		ordinamentoEta(); //richiama la funzione
	}
	
	private int cercaMin() {
		int min=Integer.MAX_VALUE;
		int indirizzoMinimo=0;
		for(int i=0;i<listaSupporto1.size();i++) {
			if(listaSupporto1.get(i).getEta()<min) {
				min=listaSupporto1.get(i).getEta();
				indirizzoMinimo=i;
			}
		}
		return indirizzoMinimo;
	}
	
	public void stampaClassificaEta() {
		for(int i=0;i<listaSupporto2.size();i++) {
			Partecipante partecipante=listaSupporto2.get(i);
			System.out.println("Partecipante "+partecipante.getTarghetta()+": "+partecipante.getEta()+" anni");
		}
	}

	
	public void ordinamentoPerPeso() {
		int contaScambi=ordinaPesi(0,0);
		if(contaScambi==0)
			return;
		ordinamentoPerPeso();
	}
	
	private int ordinaPesi(int indice, int contaScambi) {
		if(indice==listaSupporto2.size()-1)
			return contaScambi;
		else {
			if(listaSupporto2.get(indice).getPeso()>listaSupporto2.get(indice+1).getPeso()) {
				Collections.swap(listaSupporto2, indice, indice+1);
				contaScambi++;
			}
			return ordinaPesi(indice+1,contaScambi);
		}
	}
	
	public void stampaPesi() {
		for(int i=0;i<listaSupporto2.size();i++) {
			Partecipante partecipante=listaSupporto2.get(i);
			System.out.println("Partecipante "+partecipante.getTarghetta()+": "+partecipante.getPeso()+" kilogrammi");
		}
	}
	
	public LinkedList<Partecipante> quickSortEsperienza(LinkedList<Partecipante> listaPartecipanti){
		if(listaPartecipanti.size()<=1)
			return listaPartecipanti;
		else {
			Partecipante pivot=listaPartecipanti.get(listaPartecipanti.size()/2);
			LinkedList<Partecipante> subList1=new LinkedList<Partecipante>();
			LinkedList<Partecipante> subList2=new LinkedList<Partecipante>();
			for(int i=0;i<listaPartecipanti.size();i++) {
				if(i==listaPartecipanti.size()/2)
					continue;
				if(pivot.getAnniPratica()<listaPartecipanti.get(i).getAnniPratica())
					subList2.add(listaPartecipanti.get(i));
				else
					subList1.add(listaPartecipanti.get(i));
			}
			LinkedList<Partecipante> risultato=new LinkedList<Partecipante>();
			LinkedList<Partecipante> minori=quickSortEsperienza(subList1);
			LinkedList<Partecipante> maggiori=quickSortEsperienza(subList2);
			risultato.addAll(minori); risultato.add(pivot); risultato.addAll(maggiori);
			return risultato;
		}
	}
	
	public int media(LinkedList<Partecipante> listaPartecipanti) {
		int somma=0;
		for(int i=0;i<listaPartecipanti.size();i++)
			somma+=listaPartecipanti.get(i).getAnniPratica();
		return somma/listaPartecipanti.size();
	}
	
	public void stampaAnniEsperienza(LinkedList<Partecipante> listaSupporto2) {
		for(int i=0;i<listaSupporto2.size();i++) {
			Partecipante partecipante=listaSupporto2.get(i);
			System.out.println("Partecipante "+partecipante.getTarghetta()+": "+partecipante.getAnniPratica()+" anni");
		}
	}
	
	public LinkedList<Partecipante> getListaSupporto2(){
		return listaSupporto2;
	}

}
