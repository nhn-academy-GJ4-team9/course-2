package org.example;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int money = 100;
            System.out.println("게임 시작");
            System.out.println("잔돈 : " + money);

            int bet = 0;
            while (true) {
                System.out.println();
                System.out.print("배팅: ");
                bet = scanner.nextInt();
                scanner.nextLine();

                if (bet > money || bet <= 0) {
                    continue;
                }

                System.out.println("");
                boolean play = playgame(scanner);
                if (play) {
                    System.out.println("플레이어가 이김");
                    money += bet;
                } else {
                    System.out.println("딜러가 이김");
                    money -= bet;
                }

                System.out.println("잔돈 : " + money);

                if (money <= 0) {
                    break;
                }

                if (bet == 0) {
                    break;
                }


            }


        }

    }


    private static boolean playgame(Scanner scanner) {


        Deck deck = new Deck();
        BlackjackHand userblackjackHand = new BlackjackHand();
        BlackjackHand dealerblackjackHand = new BlackjackHand();


        deck.shuffle();
        dealerblackjackHand.addCard(deck.dealCard());
        dealerblackjackHand.addCard(deck.dealCard());
        userblackjackHand.addCard(deck.dealCard());
        userblackjackHand.addCard(deck.dealCard());

        if (userblackjackHand.getBlackjackValue() == 21 && dealerblackjackHand.getBlackjackValue() == 21) {
            printinfo(userblackjackHand, dealerblackjackHand);
            return false;
        }

        if (userblackjackHand.getBlackjackValue() == 21) {
            printinfo(userblackjackHand, dealerblackjackHand);
            return true;
        }

        if (dealerblackjackHand.getBlackjackValue() == 21) {
            printinfo(userblackjackHand, dealerblackjackHand);
            return false;
        }


        while (true) {

            System.out.println("플레이어의 카드 ");
            for (int i = 0; i < userblackjackHand.getCardCount(); i++) {
                System.out.println(userblackjackHand.getCard(i));
            }
            System.out.print("플레이의의 총합: ");
            System.out.println(userblackjackHand.getBlackjackValue() + "\n");

            System.out.println("딜러의 카드");
            System.out.println(dealerblackjackHand.getCard(0));

            System.out.print("hit(h) or stand (s) 중 하나를 입력: ");
            String line = scanner.nextLine();

            System.out.println();
            char c = (line.length() > 0) ? line.charAt(0) : ' ';

            if (c == 's' || c == 'S') {
                break;
            }
            if (c == 'h' || c == 'H') {

                userblackjackHand.addCard(deck.dealCard());
                if (userblackjackHand.getBlackjackValue() > 21) {
                    System.out.println("플레이어의 총합: ");
                    for (int i = 0; i < userblackjackHand.getCardCount(); i++) {
                        System.out.println(userblackjackHand.getCard(i));
                    }
                    System.out.println(userblackjackHand.getBlackjackValue());
                    return false;
                }

            } else {
                System.out.println("다시 입력 하시오");
            }
        }


        System.out.println("딜러의 카드 ");
        System.out.println(dealerblackjackHand.getCard(0));
        System.out.println(dealerblackjackHand.getCard(1));
        while (true) {
            for (int i = 2; i < dealerblackjackHand.getCardCount(); i++) {
                System.out.println(dealerblackjackHand.getCard(i));
            }

            if (dealerblackjackHand.getBlackjackValue() <= 16) {
                dealerblackjackHand.addCard(deck.dealCard());
            } else if (dealerblackjackHand.getBlackjackValue() > 21) {
                System.out.println("딜러의 총합: " + dealerblackjackHand.getBlackjackValue());
                return true;
            } else {
                System.out.println("딜러의 총합: " + dealerblackjackHand.getBlackjackValue());
                break;
            }
        }


        if (dealerblackjackHand.getBlackjackValue() >= userblackjackHand.getBlackjackValue()) {
            return false;
        } else if (userblackjackHand.getBlackjackValue() > dealerblackjackHand.getBlackjackValue()) {
            return true;
        }


        return false;
    }


    /**
     * 현재 플레이어와 딜러의 카드 정보를 출력해주는 메서드
     *
     * @param userblackjackHand
     * @param dealerblackjackHand
     */

    public static void printinfo(BlackjackHand userblackjackHand, BlackjackHand dealerblackjackHand) {
        System.out.println("플레이어의 카드 ");
        for (int i = 0; i < userblackjackHand.getCardCount(); i++) {
            System.out.println(userblackjackHand.getCard(i));
        }

        System.out.print("플레이의의 총합: ");
        System.out.println(userblackjackHand.getBlackjackValue() + "\n");

        System.out.println("딜러의 카드");
        for (int i = 0; i < dealerblackjackHand.getCardCount(); i++) {
            System.out.println(dealerblackjackHand.getCard(i));
        }
        System.out.println(dealerblackjackHand.getBlackjackValue());
    }

}
