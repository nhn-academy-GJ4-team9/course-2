import java.util.Scanner;

public class Ex2_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("quarters : ");
        int quarters = scanner.nextInt();
        System.out.print("dimes : ");
        int dimes = scanner.nextInt();
        System.out.print("nickels : ");
        int nickels = scanner.nextInt();
        System.out.print("pennies : ");
        int pennies = scanner.nextInt();
        double dollars = (0.25 * quarters) + (0.10 * dimes) + (0.05 * nickels) + (0.01 * pennies);
        System.out.println("Total dollars :" + dollars + "$");

    }
}
