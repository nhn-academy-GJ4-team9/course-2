package Ex_03;


public class Main {

    public static final int NUMBER_OF_EXPERIMENTS = 10000;

    private static PairOfDice dice = new PairOfDice();

    public static void main(String[] args) {
        System.out.println("Dice Total   Avg # of Rolls   Stand. Deviation   Max # of Rolls");
        System.out.println("----------   --------------   ----------------   --------------");


        for (int total = 2; total <= 12; total++) {
            StatCalc statCalc = new StatCalc();
            for (int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
                statCalc.enter(rollFor(total));
            }
            System.out.printf("%6d", total);
            System.out.printf("%18.3f", statCalc.getMean());
            System.out.printf("%19.3f", statCalc.getStandardDeviation());
            System.out.printf("%14.3f", statCalc.getMax());
            System.out.println();
        }

    }

    public static int rollFor(int N) {
        int count = 0;
        do {
            count++;
            dice.roll();
        } while (dice.getDice1() + dice.getDice2() != N);
        return count;
    }

}