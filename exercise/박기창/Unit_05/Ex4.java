package org.example;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        Deck deck;            // A deck of cards.
        Card card;            // A card dealt from the deck.
        BlackjackHand hand;   // A hand of from two to six cards.
        int cardsInHand;      // Number or cards in the hand.
        boolean again;        // Set to true if user wants to continue.

        deck = new Deck();    // Create the deck.

        try(Scanner scanner = new Scanner(System.in)){
            do {
                deck.shuffle();
                hand = new BlackjackHand();
                cardsInHand = 2 + (int)(Math.random()*5);
                System.out.println();
                System.out.println();
                System.out.println("Hand contains:");
                for ( int i = 1; i <= cardsInHand; i++ ) {
                    card = deck.dealCard();
                    hand.addCard(card);
                    System.out.println("    " + card);
                }
                System.out.println("Value of hand is " + hand.getBlackjackValue());
                System.out.println();
                System.out.print("Again? ");
                again = scanner.nextBoolean();
            } while (again == true);
        }


    }
}
