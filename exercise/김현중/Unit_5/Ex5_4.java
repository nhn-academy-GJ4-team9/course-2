package org.example;

import java.util.Scanner;

public class Ex5_4 {
    public static void main(String[] args) {
        BlackjackHand blackjackHand;
        Deck deck = new Deck();
        Card card;
        int cardsInHand;
        boolean on;
        try(Scanner sc=  new Scanner(System.in)){
            do{
                blackjackHand = new BlackjackHand();
                cardsInHand = 2+ (int) (Math.random()*5);
                System.out.println("Hands : ");
                for(int i = 1 ; i<= cardsInHand;i++){
                    card = deck.dealCard();
                    blackjackHand.addCard(card);
                    System.out.println("value of hand is  " + blackjackHand.getBlackjackValue());
                }
                System.out.println("again?");
                on = sc.nextBoolean();
            } while (on);
        }



    }

}
