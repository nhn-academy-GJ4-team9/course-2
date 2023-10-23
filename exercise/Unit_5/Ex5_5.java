package org.example;

import java.util.Scanner;

public class Ex5_5 {
    public static void main(String[] args) {
        playBlackjack();
    }

    public static boolean playBlackjack() {
        Deck deck = new Deck();
        deck.shuffle();
        BlackjackHand user = new BlackjackHand();
        BlackjackHand dealer = new BlackjackHand();

        for (int i = 0; i < 2; i++) {
            user.addCard(deck.dealCard());
            dealer.addCard(deck.dealCard());
        }
        System.out.println("value of user hand is " + user.getBlackjackValue());
        if(user.getBlackjackValue() == 21 ){
            System.out.println("you got blackjack, you win");
            return true;
        } else if(dealer.getBlackjackValue() == 21){
            System.out.println("dealer got blackjack, dealer win");
           return false;
        }
       try(Scanner sc = new Scanner(System.in)){
           while (true){
               System.out.println("open card "  + user.getCard(0) + " and "+user.getCard(1));
               System.out.println("dealer shows " + dealer.getCard(0));
               System.out.println("input (0) to hit or (1) to stop ");
               int val = sc.nextInt();
               if(val == 0){
                   user.addCard(deck.dealCard());
                   System.out.println("open card  "+ user.getCard(0)+ " and " +user.getCard(1) + " and " + user.getCard(2));
                   System.out.println("your value" + user.getBlackjackValue());
                   if(user.getBlackjackValue() >= 21){
                       System.out.println("open card "  + user.getCard(0) + " and "+user.getCard(1));

                       System.out.println("user loose ");
                       return false;
                   } else if(user.getBlackjackValue() <21 && user.getBlackjackValue() > dealer.getBlackjackValue()){
                       System.out.println("open card "  + user.getCard(0) + " and "+user.getCard(1));

                       System.out.println("user win ");
                       return true;
                   } else if(user.getBlackjackValue() <21 && user.getBlackjackValue() <= dealer.getBlackjackValue()){
                       System.out.println("dealer has " + dealer.getCard(0) + " and "+ dealer.getCard(1) + " his value " + dealer.getBlackjackValue());

                       System.out.println("dealer win ");
                       return false;
                   }
               } else if(val ==1 ){
                   System.out.println("dealer has " + dealer.getCard(0) + " and "+ dealer.getCard(1) + " his value " + dealer.getBlackjackValue());
                   dealer.addCard(deck.dealCard());
                   if(dealer.getBlackjackValue()<=16){
                       System.out.println("dealer hit, user loose");
                       return false;
                   } else if (dealer.getBlackjackValue()>=21){
                       System.out.println("dealer over : " +dealer.getBlackjackValue() +"user win" );
                       return true;
                   } else if(dealer.getBlackjackValue() >= user.getBlackjackValue()){
                       System.out.println("user win dealer has " +dealer.getBlackjackValue() + " and user has " + user.getBlackjackValue());
                       return true;
                   }

               }

           }
       }


    }



}

