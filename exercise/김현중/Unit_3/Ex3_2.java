package org.example;

public class Ex3_2 {
    public static void main(String[] args) {
        int divCount = 0;
        int maximumDivisor = 0;
        for (int n = 1; n <= 10000; n++) {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    divCount++;
                }
            }
            if (divCount > maximumDivisor) {
                maximumDivisor = divCount;
            }
            divCount=0;
        }
        System.out.println("maximumDivisor is "+maximumDivisor);

    }
}
