/**
 * 
 */
package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

/**
 * @author Ole Olsen
 * @param <T>
 * 
 */
public class TabellKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int bak;// indikerer neste plass, er ogs� antall
	private T[] koe; // front ved indeks 0

	public TabellKoe() {
		this(STDK);
	}

	public TabellKoe(int startKapasitet) {
		koe = ((T[]) (new Object[startKapasitet]));
		bak = 0;
	}

	public void innKoe(T element) {
		if (antall() == koe.length)
			utvid();

		koe[bak] = element;
		bak = bak + 1;

	}

	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		T resultat = koe[0];
		bak--;
		/** flytter elementene en plass fram */
		for (int flytt = 0; flytt < bak; flytt++) {
			koe[flytt] = koe[flytt+1];
		}
		koe[bak] = null;
		return resultat;
	}

	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("k�");

		T resultat = koe[0];
		return resultat;
	}

	public boolean erTom() {
		return (bak == 0);
	}

	public int antall() {
		return bak;
	}
	
	private void utvid() {
	       T[] hjelpetabell = (T[])(new Object[koe.length*2]);

	      for (int soek =0; soek < koe.length; soek++){
	         hjelpetabell[soek] = koe[soek];
		  }

	       koe = hjelpetabell;
	   }

	
}// class
