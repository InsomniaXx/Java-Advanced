package Advanced.FunctionalProgramming;

import java.math.BigDecimal;
import java.util.function.*;

public class ImportantNotes {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply()
        Function<Integer, Integer> power2 = n -> n * n;
        System.out.println(power2.apply(5));
        // Output : 25

        //Consumer<приема стойност> -> void -> accept()
        Consumer<String> printWord = word -> System.out.println(word);
        printWord.accept("Hello");
        // Output : Hello

        //Supplier<връща стойност> -> get()
        Supplier<Integer> date = () -> 30;
        System.out.println(date.get());
        //Output : 30

        //Predicate<приема стойност> проверява и връща true/false -> test()
        Predicate<String> isEqual = word -> word.equals("Test");
        System.out.println(isEqual.test("Word"));
        //Output : false

        //BiFunction<приема стойност, приема стойност, връща стойност> -> apply()
        BiFunction<Integer, Integer, String> test = (n1, n2) -> String.valueOf(n1 + n2);
        System.out.println(test.apply(5, 6));
        //Output : 11
    }
}
