package Advanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> printIndexOfMinElement = list -> {
            int min = Collections.min(list);
            System.out.println(list.lastIndexOf(min));
        };

//        Function<List<Integer>, Integer> getIndex = list -> list.lastIndexOf(Collections.min(list));
//        System.out.println(getIndex.apply(numbers));
//
        printIndexOfMinElement.accept(numbers);
    }
}
