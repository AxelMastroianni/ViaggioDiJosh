package quest.di.mileto;

import java.util.LinkedList;
import java.util.Scanner;

public class RisoluzioneQuest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner tastiera=new Scanner(System.in);
		System.out.println("Quanti partecipanti ci sono alla tua gara di calisthenics? ");
		int numeroPartecipanti=tastiera.nextInt();
		Classifica classifica=new Classifica(numeroPartecipanti);
		classifica.creaListaPartecipanti();
		long inizio=System.currentTimeMillis();
		classifica.ordinamentoEta();
		long fine=System.currentTimeMillis();
		System.out.println("Ordinamento per eta: ");
		classifica.stampaClassificaEta();
		System.out.println("Durata ordinamento: "+(fine-inizio)+" millisecondi");
		
		Thread.sleep(2000);
		
		inizio=System.currentTimeMillis();
		classifica.ordinamentoPerPeso();
		fine=System.currentTimeMillis();
		classifica.stampaPesi();
		System.out.println("Durata ordinamento: "+(fine-inizio)+" millisecondi");
		
		Thread.sleep(2000);
		
		inizio=System.currentTimeMillis();
		LinkedList<Partecipante> ordinaExp=classifica.quickSortEsperienza(classifica.getListaSupporto2());
		fine=System.currentTimeMillis();
		classifica.stampaAnniEsperienza(ordinaExp);
		System.out.println("Durata ordinamento: "+(fine-inizio)+" millisecondi");

	}

}
