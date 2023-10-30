package Ex_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (Character.isDigit(input.charAt(0))) {
            RomaNumber romaNumberInt = new RomaNumber(Integer.parseInt(input));
            System.out.println(romaNumberInt.toStr());
        } else {
            RomaNumber romaNumberStr = new RomaNumber(input);
            System.out.println(romaNumberStr.toInt());
        }
    }
}