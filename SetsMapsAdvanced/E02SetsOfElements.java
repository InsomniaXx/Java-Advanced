package Advanced.SetsMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        addInSet(scanner, n, firstSet);
        addInSet(scanner, m, secondSet);

        for (int numberFirstSet : firstSet) {
            for (int numberSecondSet : secondSet) {
                if (numberFirstSet == numberSecondSet) {
                    System.out.print(numberFirstSet + " ");
                }
            }
        }
    }

    private static void addInSet(Scanner scanner, int count, Set<Integer> set) {
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            set.add(number);
        }
    }


}
