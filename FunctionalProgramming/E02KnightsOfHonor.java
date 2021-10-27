package Advanced.FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class E02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> print =
                output -> System.out.println("Sir " + output);

        for (String name : input) {
            print.accept(name);
        }
    }
}
