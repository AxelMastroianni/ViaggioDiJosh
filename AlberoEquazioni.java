package quest.albero.equazioni;

import java.util.LinkedList;
public class AlberoEquazioni {
	
	private int massimaProfondita=0;
	private int numeroVicini=0;
	private LinkedList<Equazione> alberoListato=new LinkedList<Equazione>();
	private Equazione radice;
	
	public AlberoEquazioni(Equazione radice, int massimaProfondita, int numeroVicini) {
		this.radice=radice;
		radice.calcolaSoluzioni();
		this.massimaProfondita=massimaProfondita;
		this.numeroVicini=numeroVicini;
	}
	
	public LinkedList<Equazione> getAlberoListato() {
		return alberoListato;
	}

	public void setAlberoListato(LinkedList<Equazione> alberoListato) {
		this.alberoListato = alberoListato;
	}

	public LinkedList<Equazione> quickSort(LinkedList<Equazione> listaEquazioni) {
		if(listaEquazioni.size()<=1)
			return listaEquazioni;
		else {
			Equazione pivot=listaEquazioni.get(listaEquazioni.size()/2);
			LinkedList<Equazione> subList1=new LinkedList<Equazione>();
			LinkedList<Equazione> subList2=new LinkedList<Equazione>();
			for(int i=0;i<listaEquazioni.size();i++) {
				if(i==listaEquazioni.size()/2)
					continue;
				if(listaEquazioni.get(i).getDelta()>pivot.getDelta())
					subList2.add(listaEquazioni.get(i));
				else
					subList1.add(listaEquazioni.get(i));
			}
			LinkedList<Equazione> risultato=new LinkedList<Equazione>();
			LinkedList<Equazione> minori=quickSort(subList1);
			LinkedList<Equazione> maggiori=quickSort(subList2);
			risultato.addAll(minori); risultato.add(pivot);risultato.addAll(maggiori);
			return risultato;
		}
	}
	
	/**
	 * funzione che genera l'albero mediante 3 cicli for:
	 * 1. mi serve per la profondita dell'albero;
	 * 2. mi serve per scorrere un livello di profondità dell'albero in orizzontale, lo faccio usando 
	 * potenze di numeroVicini: noto infatti che ogni livello di profondità ha un numero di nodi pari
	 * a, nel caso di un albero binario, 2^i se i è zero, sono al livello radice e 2^0 fa 1, ho solo
	 * un elemento, se scendo i=1 se 2^1 fa 2, infatti ho 2 elementi e così via;
	 * 3. mi serve per aggiungere i vicini ad un nodo, essendo l'albero binario ne mette 2 però nulla
	 * vieta di aggiungerne di più
	 */
	public void creaAlbero() {
		 LinkedList<Equazione> supporto=new LinkedList<Equazione>();
		 radice.calcolaSoluzioni();
		 supporto.add(radice); //comincio dalla radice 
		 for(int i=0;i<massimaProfondita;i++){
		  	for(int j=0;j<Math.pow(numeroVicini,i);j++){//uso potenze di numeroVicini
		  		Equazione nodo=supporto.remove(0);//estraggo un nodo in orizzontale
		  		LinkedList<Equazione> figli=nodo.getVicine();//estraggo la lista del nodo
		  		for(int k=0;k<numeroVicini;k++){
		  			Equazione figlio=new Equazione();//inizializzo la lista
		  			figlio.calcolaSoluzioni();
		  			figli.add(figlio);
		 			supporto.add(figlio); //metto tutti i figli in supporto che rappresenta la riga dell'albero
		  		}
		 	}
		 }
	}
	/**
	 * stampa l'albero e ne approfitta per memorizzarlo in una lista
	 */
	public void stampaAlbero() {
		alberoListato.add(radice);
		System.out.printf("%.2f\n",radice.getDelta());
		LinkedList<Equazione> figlie=radice.getVicine();//ottengo le figlie della radice
		for(int i=0;i<massimaProfondita;i++) {
			for(int j=0;j<Math.pow(numeroVicini,i+1);j++){ //percorro l'albero in orizzontale
			 	Equazione figlia=figlie.remove(0); //rimuovo dall'albero la radice così posso lavorarci
			 	alberoListato.add(figlia);//aggiungo quella rimossa alla lista così poi posso ricreare l'albero
			 	System.out.printf("%.2f\t",figlia.getDelta());
			  	figlie.addAll(figlia.getVicine());//agginugo le nuove figlie della figlia
			}
			System.out.println();
		}
	}
	/**
	 * toglie le vicine in questo modo quando lo ricreo dalla lista non ci sono problemi di vicine invasive
	 */
	public void rimuoviVicine() {
		for(int i=0;i<alberoListato.size();i++)
			alberoListato.get(i).eliminaVicine();
	}
	
	public void fromListToTree(LinkedList<Equazione> alberoListato) {
		radice=alberoListato.remove(0);
		LinkedList<Equazione> supporto=new LinkedList<Equazione>();
		supporto.add(radice);
		for(int i=0;i<massimaProfondita;i++) {
			for(int j=0;j<Math.pow(numeroVicini, i);j++) {
				Equazione figlia=supporto.remove(0);
				LinkedList<Equazione> figlie=figlia.getVicine();
				for(int k=0;k<numeroVicini;k++) {
					Equazione nodo=alberoListato.remove(0);
					figlie.add(nodo);
					supporto.add(nodo);
				}
			}
		}
	}
	
}
