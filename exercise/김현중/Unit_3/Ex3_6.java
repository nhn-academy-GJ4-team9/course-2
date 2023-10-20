package org.example;

public class Ex3_6 {
    public static void main(String[] args) {
        int maximumDivisor = 0;
        int[] N = new int[10000];
        for (int i = 1; i<= N.length-1 ;i++){
            for(int n = 1; n<=i;n++){
                if(i % n ==0){
                    N[i]++;
                }
            }
            if(N[i] > maximumDivisor){
                maximumDivisor = N[i];
            }

        }
        for(int i= 0; i< N.length-1;i++){
            if(maximumDivisor == N[i]){
                System.out.println("maximum divisors are "+i);
            }
        }



    }
}
