package no.hvl.dat102;

import java.time.*;

/**
 * SolveTowers uses recursion to solve the Towers of Hanoi puzzle.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class SolveTowers
{
    /**
     * Creates a TowersOfHanoi puzzle and solves it.
     */
    public static void main(String[] args) throws InterruptedException
    {
        TowersOfHanoi towers = new TowersOfHanoi(64);
        Instant foer = Instant.now();
        towers.solve();
        Instant etter = Instant.now();

        Duration d = Duration.between(foer, etter);

        System.out.println("Før: " + foer + ", etter: " + etter + ".\nTid brukt: " + d);

        Thread.sleep(10000);

        towers = new TowersOfHanoi(32);
        Instant foer2 = Instant.now();
        towers.solve();
        Instant etter2 = Instant.now();

        Duration d2 = Duration.between(foer2, etter2);

        System.out.println("Før: " + foer2 + ", etter: " + etter2 + ".\nTid brukt: " + d2);

        System.out.println("(2^32 - 1) / (2^16 - 1) = " + (Math.pow(2, 32) - 1) / (Math.pow(2, 16) - 1) );

        System.out.println("Tid32 / Tid 16 = " + d.toMillis() / d2.toMillis());
    }
}
