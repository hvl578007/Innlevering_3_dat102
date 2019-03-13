package no.hvl.dat102;

import java.time.*;

public class Oppgave_1 {

    public static void main(String[] args) {
        Instant foerN = Instant.now();
        System.out.println(sumN(10)); //tester a)
        Instant etterN = Instant.now();

        Duration durN = Duration.between(foerN, etterN);
        System.out.println("Tid brukt på summen av naturlege tal: " + durN);

        System.out.println();

        
        //main-program for b)
        for (int i = 0; i < 10; i++) {
            System.out.println(tallFolge(i));
        }
    }

    // a)
    public static int sumN(int n) {
        if(n <= 1) { //evt ha med n < 1 -> return 0
            return 1;
        } else {
            return sumN(n-1) + n;
        }
    }

    // b)
    public static int tallFolge(int n) {
        if(n <= 0) { //evt ha med n < 0 -> return 0
            return 2;
        } else if(n == 1) {
            return 5;
        } else {
            return 5 * tallFolge(n-1) - 6 * tallFolge(n-2) + 2;
        }
    }
}