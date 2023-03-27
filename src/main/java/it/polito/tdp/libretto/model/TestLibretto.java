package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {

		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi 1", 27, LocalDate.of(2021,  2, 15)));
		lib.add(new Voto("Fisica 1", 25, LocalDate.of(2022,  8, 31)));
		lib.add(new Voto("Informatica", 20, LocalDate.of(2021,  1, 21)));

		lib.stampaPuntiUguali(25);
		Voto v = lib.cercaNome("Analisi 1");
		System.out.println(v);
		
		Voto a1bis = new Voto("Analisi 1", 27, LocalDate.of(2021,  2, 15));
		Voto a1ter = new Voto("Analisi 1", 30, LocalDate.of(2025,  8, 31));

		System.out.println(a1bis + "è duplicato "+lib.esisteVotoDuplicato(a1bis));
		System.out.println(a1ter + "è duplicato "+lib.esisteVotoDuplicato(a1ter));
		
		
		try {
			lib.add(new Voto("Informatica", 20, LocalDate.of(2021,  1, 21)));
		}catch(IllegalArgumentException e) {
			System.out.println("Errore nell'inserimento voto.");
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\nLIBRETTO ORIGINALE\n");
		lib.stampa();
		
		
		System.out.println("\nLIBRETTO MIGLIORATO\n");
		Libretto migliore = lib.librettoMigliorato();
		migliore.stampa();
		
		
		System.out.println("\nOrdine alfabetico\n");
		
		lib.LibrettoOrdinatoAlfabeticamente().stampa();

		
		System.out.println("\nOrdine punteggio\n");
		
		lib.librettoOrdinatoPerVoto().stampa();
	}

}
