package org.example;

public class Ex5_3 {

    static final int NUMBER_OF_EXPERIMENTS = 10000;

    private static PairOfDice dice = new PairOfDice();

    public static void main(String[] args) {

        System.out.println("Dice Total   Avg # of Rolls   Stand. Deviation   Max # of Rolls");
        System.out.println("----------   --------------   ----------------   --------------");

        for ( int total = 2;  total <= 12;  total++ ) {
            StatCalc stats;
            stats = new StatCalc();
            for ( int i = 0; i < NUMBER_OF_EXPERIMENTS; i++ ) {
                stats.enter( rollFor(total) );
            }
            System.out.printf("%6d", total);
            System.out.printf("%18.3f", stats.getMean());
            System.out.printf("%19.3f", stats.getStandardDeviation());
            System.out.printf("%14.3f", stats.getMax());
            System.out.println();
        }

    }

    static int rollFor( int N ) {
        int rollCt = 0;
        do {
            dice.roll();
            rollCt++;
        } while ( dice.getTotal() != N );
        return rollCt;
    }


}
