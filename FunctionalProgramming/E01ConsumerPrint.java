package Advanced.FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class E01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

//        Consumer<String> print =
//                name -> System.out.println(name);
//
//        for (String name : input) {
//            print.accept(name);
//        }

        Consumer<String[]> printNames = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };
        printNames.accept(input);
    }
}
