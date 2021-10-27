package Advanced.SetsMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> symbolList = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (symbolList.containsKey(currentChar)) {
                symbolList.put(currentChar, symbolList.get(currentChar) + 1);
            } else {
                symbolList.put(currentChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> symbol : symbolList.entrySet()) {
            System.out.printf("%s: %d time/s%n", symbol.getKey(), symbol.getValue());
        }
    }
}
