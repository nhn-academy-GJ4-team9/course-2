package org.example;

public class Ex5_3 {
    static final int EXPERIMENT_TIMES = 10000;
    private static PairOfDice dice = new PairOfDice();

    public static void main(String[] args) {
        System.out.println("Dice Total   Avg # of Rolls   Stand. Deviation   Max # of Rolls");
        System.out.println("----------   --------------   ----------------   --------------");

        for(int i = 2; i<= 12; i++){
            StatCalc statCalc = new StatCalc();

            for(int j = 0 ; j< EXPERIMENT_TIMES; j++ ){
                statCalc.enter(rollFor(i));
            }
            System.out.printf("%18.3f",statCalc.getMean());
            System.out.printf("%19.3f",statCalc.getStandardDeviation());
            System.out.printf("%14.3f",statCalc.getMax());
            System.out.println();
        }


    }

    static int rollFor(int N){
        int count= 0;
        do{
            dice.roll();
            count++;
        } while (dice.sumOfDice() != N);
        return count;
    }


}
