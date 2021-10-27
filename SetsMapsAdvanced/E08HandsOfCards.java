package Advanced.SetsMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] nextInput = input.split(": ");
            String name = nextInput[0];
            String[] cards = nextInput[1].split(", ");

            players.putIfAbsent(name, new LinkedHashMap<>());
            Map<String, Integer> playerCards = players.get(name);

            getMultipliedCardValue(playerCards, cards);

            input = scanner.nextLine();
        }

        for (String player : players.keySet()) {
            int sum = 0;
            for (Map.Entry<String, Integer> cards : players.get(player).entrySet()) {
                sum += cards.getValue();
            }
            System.out.println(player + ": " + sum);
        }
    }

    private static void getMultipliedCardValue(Map<String, Integer> playerCards, String[] cards) {
        for (String card : cards) {
            int cardValue = 1;

            for (int i = 0; i < card.length(); i++) {
                switch (card.charAt(i)) {
                    case 'S':
                        cardValue = cardValue * 4;
                        break;
                    case 'H':
                        cardValue = cardValue * 3;
                        break;
                    case 'D':
                        cardValue = cardValue * 2;
                        break;
                    case 'C':
                        cardValue = cardValue * 1;
                        break;
                    case 'J':
                        cardValue = cardValue * 11;
                        break;
                    case 'Q':
                        cardValue = cardValue * 12;
                        break;
                    case 'K':
                        cardValue = cardValue * 13;
                        break;
                    case 'A':
                        cardValue = cardValue * 14;
                        break;
                    case '1':
                        cardValue = cardValue * 10;
                        break;
                    case '0':
                        break;
                    default:
                        cardValue = cardValue * Character.getNumericValue(card.charAt(i));
                }
                playerCards.put(card, cardValue);
            }
        }
    }
}
