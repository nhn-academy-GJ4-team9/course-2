package org.example;

public class Ex3_7_3 {
    public static void main(String[] args) {

        int count;       // The number of people who have been checked.

        count = 0;
        boolean[] used;

        used = new boolean[365];
        int check= 0;
        while (check<365) {

            // Select a birthday at random, from 0 to 364.
            // If the birthday has already been used, quit.
            // Otherwise, record the birthday as used.

            int birthday;  // The selected birthday.
            birthday = (int)(Math.random()*365);
            count++;

            System.out.printf("Person %d has birthday number %d%n", count, birthday);
            if(used[birthday]==false){
                check++;
            }
            used[birthday]=true;

        } // end while
        System.out.println("you checked " + count);

    }
}
