package no.hvl.dat102;

import java.util.Arrays;
import no.hvl.dat102.tabell.TabellKoe;

/**
 * Sortering
 */
public class Sortering {

    public static void main(String[] args) {
        Integer[] tab = {9, 7, 5, 3, 1, 39, 14, 0, 19, 10};
        Integer[] radixTab = {345, 767, 103, 665, 448, 876, 247, 196, 521, 333, 100};
        fletteSort(tab);
        System.out.println(Arrays.toString(tab) + "\n");

        radixSort(radixTab);
        System.out.println(Arrays.toString(radixTab));
    }

    public static <T extends Comparable<T>> void sortInnsetting(T[] tab) {
        T temp;
        int pos;

        for(int i = 1; i < tab.length; i++) {
            pos = i;
            temp = tab[i];

            while(pos > 0 && temp.compareTo(tab[pos-1]) < 0) {
                tab[pos] = tab[pos-1];
                pos--;
            }

            tab[pos] = temp;
        }
    }

    public static <T extends Comparable<T>> void sortUtval(T[] tab) {
        int minste;
        T temp;

        for (int i = 0; i < tab.length-1; i++) {
            minste = i;
        
            for (int j = i+1; j < tab.length; j++) {
                if(tab[j].compareTo(tab[minste]) < 0) {
                    minste = j;
                }
            }
            temp = tab[i];
            tab[i] = tab[minste];
            tab[minste] = temp;
        }
    }

    public static <T extends Comparable<T>> void bobleSort(T[] tab) {
        T temp;
        for (int i = tab.length; i > 1; i--) {
            for (int j = 0; j < i-1; j++) {
                if(tab[j].compareTo(tab[j+1]) > 0) {
                    temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void kvikkSort(T[] tab) {
        kvikkSort(tab, 0, tab.length-1);
    }

    private static <T extends Comparable<T>> void kvikkSort(T[] tab, int min, int maks) {
        if(min < maks) {
            int partisjon = finnPartisjon(tab, min, maks);
            kvikkSort(tab, min, partisjon-1);
            kvikkSort(tab, partisjon+1, maks);
        }

    }

    private static <T extends Comparable<T>> int finnPartisjon(T[] tab, int min, int maks) {
        int venstre = min;
        int hogre = maks;
        T pivot = tab[min];

        while (venstre < hogre) {
            while (venstre <= maks && tab[venstre].compareTo(pivot) <= 0) {
                venstre++;
            }
            while (hogre >= min && tab[hogre].compareTo(pivot) > 0) {
                hogre--;
            }

            if(venstre < hogre) {
                T temp = tab[hogre];
                tab[hogre] = tab[venstre];
                tab[venstre] = temp;
            }
        }

        tab[min] = tab[hogre];
        tab[hogre] = pivot;

        return hogre;
    }

    public static <T extends Comparable<T>> void fletteSort(T[] tab) {
        fletteSort(tab, 0, tab.length-1);
    }

    private static <T extends Comparable<T>> void fletteSort(T[] tab, int min, int maks) {
        if(min < maks) {
            int midten = (min + maks) / 2;
            fletteSort(tab, min, midten);
            fletteSort(tab, midten+1, maks);

            flette(tab, min, midten, maks);
        }
    }

    private static <T extends Comparable<T>> void flette(T[] tab, int forste, int midten, int siste) {
        //første halvdel er forste -> midten
        //andre halvdel er midten+1 -> siste
        int storrelse = siste - forste + 1;
        T[] hjelpeTab = (T[])(new Comparable[storrelse]);
        int forste1 = forste, siste1 = midten;
        int forste2 = midten+1, siste2 = siste;

        int i = 0;

        while (forste1 <= siste1 && forste2 <= siste2) {
            if (tab[forste1].compareTo(tab[forste2]) <= 0) {
                hjelpeTab[i] = tab[forste1];
                forste1++;
            } else {
                hjelpeTab[i] = tab[forste2];
                forste2++;
            }
            i++;
        }

        while (forste1 <= siste1) {
            hjelpeTab[i] = tab[forste1];
            forste1++;
            i++;
        }

        while (forste2 <= siste2) {
            hjelpeTab[i] = tab[forste2];
            forste2++;
            i++;
        }

        i = 0;
        for (int j = forste; j <= siste; j++) {
            tab[j] = hjelpeTab[i];
            i++;
        }
    }

    //Integer-objekt, må vere lik lengde på alle tala, og større eller lik 0
    public static void radixSort(Integer[] tab) {
        String temp;
        int siffer, tal;
        TabellKoe<Integer>[] sifferKoer = (TabellKoe<Integer>[])(new TabellKoe[10]);
        int lengdePaaTal = String.valueOf(tab[0]).length();

        for (int sifferV = 0; sifferV <= 9; sifferV++) {
            sifferKoer[sifferV] = new TabellKoe<Integer>();
        }

        for (int pos = 0; pos < lengdePaaTal; pos++) {
            for (int i = 0; i < tab.length; i++) {
                temp = String.valueOf(tab[i]);
                
                /*while (temp.length() < lengdePaaTal) {
                    temp = "0" + temp;
                }
                */

                siffer = Character.digit(temp.charAt(lengdePaaTal-1 - pos), 10);
                sifferKoer[siffer].innKoe(tab[i]);
            }
            tal = 0;
            for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
                while (!(sifferKoer[sifferVerdi].erTom())) {
                    tab[tal] = sifferKoer[sifferVerdi].utKoe();
                    tal++;
                }
            }
        }
        
    }
}