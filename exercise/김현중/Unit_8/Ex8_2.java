package com.example.chapter8;


import java.math.BigInteger;
import java.util.Scanner;

public class Ex8_2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String line;
            BigInteger n;
            while (true){
                System.out.println("input positive num");
                line = sc.nextLine();
                if(line.equals(" ")) {
                    break;
                }
                try {
                    n = new BigInteger(line);
                    if(n.signum()==1) {
                        threeN1(n);
                    } else {
                        throw new IllegalArgumentException("n must be grater than zero");
                    }
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }

    public static void threeN1(BigInteger n) {
        assert n != null && n.signum() == 1 : "must be not null and negative";

        int count = 1;
        while (!n.equals(new BigInteger("1"))) {
            if (n.testBit(0) == false)
                n = n.divide(new BigInteger("2"));
            else{
                n = n.multiply(new BigInteger("3"));
                n = n.add(BigInteger.valueOf(1));
            }
            System.out.println(n.toString());
            count++;
        }
        System.out.println();
        System.out.println("there were " + count + " terms in the sequecne");


    }


}
