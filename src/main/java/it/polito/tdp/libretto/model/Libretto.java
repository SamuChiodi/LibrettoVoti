package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Libretto {

	private List<Voto> voti;

	public Libretto() {
		this.voti=new ArrayList<Voto>();
	}
	
	/**
	 * aggiungi nuovo voto a libretto
	 * @param v voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		
		if(esisteVotoConflitto(v)||this.esisteVotoDuplicato(v)) {
			//non posso aggiungere voto
			throw new IllegalArgumentException("Voto errato: " +v);
			//return false;
		}
		
		return this.voti.add(v);
	}
	
	public void stampa() {
		 for(Voto v : this.voti) {
			 System.out.println(v);
		 }
	}

	public List<Voto>getVoti(){
		return this.voti;
	}
	public void stampaPuntiUguali(int valore) {
		 for(Voto v : this.voti) {
			 
			 if(v.getPunti()==valore) {
			 System.out.println(v);
		 }}}
	
	public Voto cercaNome(String nome) {
		 for(Voto v : this.voti) {
			 
			 if(v.getCorso().compareTo(nome)==0) {
				 return v;
		 }}
		 return null;}
		// throw new Exception("Voto non trovato");

	public boolean esisteVotoDuplicato(Voto nuovo) {
		for(Voto v : voti) {
			if(v.isDuplicato(nuovo)) {
				return true;
			}
		}
		
//		}
			return false;
	}

	public boolean esisteVotoConflitto(Voto nuovo) {
		for(Voto v : voti) {
				if(v.IsConflitto(nuovo)){return true;}
				}
			
			return false;
	}
	
	
	//Metodo 'FACTORY' per creare un nuovo libretto con i voti migliorati
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		
		migliore.voti = new ArrayList<>(this.voti);
		
//		for(Voto v : this.voti) {
//			migliore.voti.add(v.clone());
//	//		migliore.voti.add(new Voto(v));
//			
//			}
		 
		for(Voto v : migliore.voti) {
			if(v.getPunti() >= 18 && v.getPunti()< 24)
				v.setPunti(v.getPunti()+1);
			else if(v.getPunti()>= 24 && v.getPunti()<= 28)
				v.setPunti(v.getPunti()+2);
		}
		
		return migliore;
	}
	
	
	public void cancellaVotoInferiore(int punti) {
		List<Voto> daCancellare = new ArrayList<Voto>();
		for(Voto v : voti) {
			if(v.getPunti()<punti) {
				daCancellare.add(v);    //in questo modo non modifico mai la lista voti
			}
		}
//		for(Voto v1 : daCancellare) { //daCancellare non si modifica, ma modifico solo voti
//			this.voti.remove(v1);
//		}
		
		voti.removeAll(daCancellare);  //molto meglio rispetto al ciclo for sopra
	}


	
	//Punto 8 
	
	public Libretto LibrettoOrdinatoAlfabeticamente() {
		
		Libretto ordinato = new Libretto ();
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new ComparatorByName());
		Collections.sort(ordinato.voti, new ComparatorByName());   //--> stessa cosa della riga sopra
		
		
		return ordinato;
	}
	
	
	public Libretto librettoOrdinatoPerVoto() {
		

		Libretto ordinato = new Libretto ();
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new Comparator<Voto>(){

			@Override
			public int compare(Voto o1, Voto o2) {
				// TODO Auto-generated method stub
				return o1.getPunti()-o2.getPunti();
			}
			
		});
		
		return ordinato;
		
	}
	
	public String toString() {
		String txt = "";
		
		for(Voto v: voti) {
			txt = txt + v.toString();
		}
		return txt;
	}
	
}

