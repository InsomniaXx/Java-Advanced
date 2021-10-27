package Advanced.FunctionalProgramming;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class E04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> addition = arr -> Arrays
                .stream(arr)
                .map(n -> n += 1)
                .toArray();

        Function<int[], int[]> multiplication = arr -> Arrays
                .stream(arr)
                .map(n -> n *= 2)
                .toArray();

        Function<int[], int[]> subtraction = arr -> Arrays
                .stream(arr)
                .map(n -> n -= 1)
                .toArray();

        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String command = input;
            switch (command) {
                case "add":
                    numbers = addition.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplication.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtraction.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }

    }
}
