package no.hvl.dat102;

import java.time.*;
import java.util.Random;
import static no.hvl.dat102.Sortering.*;

/**
 * MaalingAvSortering
 */
public class MaalingAvSortering {

    public static void main(String[] args) {

        Random tilfeldig = new Random();
        int n = 128000;
        int antal = 8;

        Integer[][] a = new Integer[antal][n];
        for (int i = 0; i < antal; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = tilfeldig.nextInt();
            }
        }
        
        Instant foer = Instant.now(); //tida før sorteringa

        for (int i = 0; i < antal; i++) {
            //kvikkSort(a[i]);
            //fletteSort(a[i]);
            //bobleSort(a[i]);
            //sortUtval(a[i]);
            sortInnsetting(a[i]);
        }

        Instant etter = Instant.now(); //tida etter sorteringa

        Duration tid = Duration.between(foer, etter).dividedBy(antal); //finn tida imellom tidspunktene og deler på antal tabellar

        System.out.println("Før: " + foer + ", etter: " + etter + ".\nGjennomsnittleg tid brukt: " + tid);
    }
}