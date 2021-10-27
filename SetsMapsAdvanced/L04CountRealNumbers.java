package Advanced.SetsMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        String[] inputNumbers = scanner.nextLine().split("\\s+");

        for (String currentNumber : inputNumbers) {
            double number = Double.parseDouble(currentNumber);

            if (numbers.containsKey(number)) {
                numbers.put(number, numbers.get(number) + 1);
            } else {
                numbers.put(number, 1);
            }
        }

        for (Map.Entry<Double, Integer> mapNumbers : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", mapNumbers.getKey(), mapNumbers.getValue());
        }
    }
}
