package Ex_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int playerMoney = 100;

            while (playerMoney > 0) {
                try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("플레이어 현재 잔액 : " + playerMoney);
                System.out.print("게임을 시작합니다. 베팅 금액을 입력하세요 [1부터 " + playerMoney + "까지]: ");
                int bettingMoney = scanner.nextInt();

                if (!isValidBetting(bettingMoney, playerMoney)) {
                    continue;
                }

                playerMoney -= bettingMoney;

                BlackjackHand userHand = new BlackjackHand();
                BlackjackHand comHand = new BlackjackHand();
                Deck deck = new Deck();

                deck.shuffle();

                initCardInHand(deck, userHand, comHand);

                displayCard(userHand,comHand);

                userTurn(deck, userHand);

                dealerTurn(deck, comHand);

                printResult(userHand, comHand, bettingMoney, playerMoney);
            }

            System.out.println("게임 종료. 잔액이 부족합니다.");
        }
    }

    public static boolean isValidBetting(int bettingMoney, int playerMoney) {
        if (bettingMoney < 1 || bettingMoney > playerMoney) {
            System.out.println("잘못된 베팅 금액입니다. 다시 입력하세요.");
            return false;
        }
        return true;
    }

    public static void userTurn(Deck deck, BlackjackHand userHand) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Hit 하시겠습니까 (Y/N)");
                String hitOrStand = scanner.next();
                if (hitOrStand.equalsIgnoreCase("Y")) {
                    Card userCard = deck.dealCard();
                    userHand.addCard(userCard);
                    System.out.println("사용자의 카드: " + userCard);
                    if (userHand.getBlackjackValue() > 21) {
                        System.out.println("사용자 패배.");
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void dealerTurn(Deck deck, BlackjackHand comHand) {
        while (comHand.getBlackjackValue() <= 16) {
            Card comCard = deck.dealCard();
            comHand.addCard(comCard);
        }
    }

    public static void printResult(BlackjackHand userHand, BlackjackHand comHand, int bettingMoney, int playerMoney) {
        System.out.println("사용자 카드 합계: " + userHand.getBlackjackValue());
        System.out.println("딜러 카드 합계: " + comHand.getBlackjackValue());

        if (isUserWin(userHand, comHand)) {
            System.out.println("사용자 승리");
            playerMoney += 2 * bettingMoney;
        } else {
            System.out.println("딜러 승리");
            playerMoney -= bettingMoney;
        }
    }

    public static void initCardInHand(Deck deck, BlackjackHand userHand, BlackjackHand comHand) {
        for (int i = 1; i <= 2; i++) {
            Card card = deck.dealCard();
            userHand.addCard(card);
            card = deck.dealCard();
            comHand.addCard(card);
        }
    }

    public static boolean isUserWin(BlackjackHand userHand, BlackjackHand comHand) {
        if (userHand.getBlackjackValue() == 21) {
            return true;
        } else if (comHand.getBlackjackValue() == 21) {
            return false;
        } else if (userHand.getBlackjackValue() > 21) {
            return false;
        } else if (comHand.getBlackjackValue() > 21) {
            return true;
        } else if (userHand.getBlackjackValue() > comHand.getBlackjackValue()) {
            return true;
        } else {
            return false;
        }
    }

    public static void displayCard(BlackjackHand userHand,BlackjackHand comHand) {
        System.out.println("사용자의 카드");
        for (int i = 0; i < userHand.getCardCount(); i++) {
            System.out.println(userHand.getCard(i));
        }
        System.out.println("딜어의 카드");
        for (int i = 1; i < comHand.getCardCount(); i++) {
            System.out.println(comHand.getCard(i));
        }
    }
}
