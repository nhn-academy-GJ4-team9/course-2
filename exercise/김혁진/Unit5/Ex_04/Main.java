package Ex_04;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        BlackjackHand blackjackHand = new BlackjackHand();
        deck.shuffle();
        int playCards = (int)(Math.random()*5) + 2;
        for ( int i = 1; i <= playCards; i++ ) {
            Card card = deck.dealCard();
            blackjackHand.addCard(card);
            System.out.println(card);
        }
        System.out.println("카드 합계 : " + blackjackHand.getBlackjackValue());
    }

}