package org.example;

import java.math.BigInteger;

public class Ex9_1 {
    public static void main(String[] args) {
        System.out.println(factorial(new BigInteger("4")));
        System.out.println(fibonacci(new BigInteger("4")));

    }


    public static BigInteger factorial(BigInteger n){
        if((!(n.signum()==1))){
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }

    public static BigInteger fibonacci(BigInteger n){
        if(n.compareTo(BigInteger.ZERO)<0){
            throw new NumberFormatException("must be greater than 0");
        } else if(n.equals(BigInteger.ZERO) ) {
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(BigInteger.TWO)));
        }

    }
}
