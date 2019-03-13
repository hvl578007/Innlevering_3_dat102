package no.hvl.dat102;

import java.util.Arrays;

/**
 * Sortering
 */
public class Sortering {

    public static void main(String[] args) {
        Integer[] tab = {9, 7, 5, 3, 1};
        sortUtval(tab);
        System.out.println(Arrays.toString(tab));
    }

    public static <T extends Comparable<T>> void sortInnsetting(T[] tab) {

    }

    public static <T extends Comparable<T>> void sortUtval(T[] tab) {
        int minste;
        T temp;

        for (int i = 0; i < tab.length; i++) {
            minste = i;
        
            for (int j = i+1; j < tab.length; j++) {
                if(tab[j].compareTo(tab[i]) < 0) {
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
        
    }

    public static <T extends Comparable<T>> void fletteSort(T[] tab) {
        
    }

    //må kanskje velje noko anna enn generelt her?!
    public static <T extends Comparable<T>> void radixSort(T[] tab) {
        
    }
}