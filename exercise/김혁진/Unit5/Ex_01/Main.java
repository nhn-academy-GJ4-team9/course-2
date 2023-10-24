package Ex_01;

public class Main {
    public static void main(String[] args) {
        PairOfDice pairOfDice = new PairOfDice();
        System.out.println("뱀 눈이 나올때 까지 주사위 굴린 횟수 : " + countOfRollForSnake(pairOfDice));
    }

    public static int countOfRollForSnake(PairOfDice pairOfDice) {
        int count = 1;
        while (!isSnakeEyes(pairOfDice)) {
            count++;
            pairOfDice.roll();
            System.out.println(pairOfDice);

        }
        return count;
    }

    public static boolean isSnakeEyes(PairOfDice pairOfDice) {
        return pairOfDice.getDice1() + pairOfDice.getDice2() == 2;
    }
}
