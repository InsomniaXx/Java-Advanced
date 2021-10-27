package Advanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class L02SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, Integer> count = str -> str.split(", ").length;

        Function<String, Integer> sum = str ->
                Arrays.stream(str.split(", "))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("Count = " + count.apply(input));

        System.out.println("Sum = " + sum.apply(input));

    }
}
