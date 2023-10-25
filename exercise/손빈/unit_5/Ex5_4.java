package org.example;

public class Ex5_4 {

    public static void main(String[] args) {
        Deck deck;
        Card card;
        BlackjackHand hand;
        int cardsInHand;
        boolean again = false;

        deck = new Deck();

        do {
            deck.shuffle();
            hand = new BlackjackHand();
            cardsInHand = 2 + (int)(Math.random()*5);
            System.out.println("Hand contains:");
            for ( int i = 1; i <= cardsInHand; i++ ) {
                card = deck.dealCard();
                hand.addCard(card);
                System.out.println("    " + card);
            }
            System.out.println("Value of hand is " + hand.getBlackjackValue());
            
        } while (again == true);

    }

}