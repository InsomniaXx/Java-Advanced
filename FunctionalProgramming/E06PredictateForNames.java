package Advanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E06PredictateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> checkName = name -> name.length() > n;
        names.removeIf(checkName);

        names.forEach(name -> System.out.println(name));
    }
}
