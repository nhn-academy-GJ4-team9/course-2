package org.example;

import java.util.Arrays;

public class Ex3_7_2 {
    public static void main(String[] args) {
        //   that have been seen so far.  A value
        //   of true in used[i] means that a person
        //   whose birthday is the i-th day of the
        //   year has been found.

        int count;       // The number of people who have been checked.


        count = 0;

        int[] counter = new int[365];
        while (count<365) {
            // Select a birthday at random, from 0 to 364.
            // If the birthday has already been used, quit.
            // Otherwise, record the birthday as used.

            int birthday;  // The selected birthday.
            birthday = (int)(Math.random()*365);
            count++;

            System.out.printf("Person %d has birthday number %d%n", count, birthday);
            counter[birthday]++;

        } // end while
        int tries =0;
        for(int i = 0; i< 365;i++){
            if(counter[i]>=1){
                tries++;
            }
        }

        System.out.println("you tried "+ tries);
    }
}
