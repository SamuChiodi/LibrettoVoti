package it.polito.tdp.libretto.model;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Voto>{
	
	public int compare(Voto o1, Voto o2) {
		return o1.getCorso().compareTo(o2.getCorso());
	}
}
