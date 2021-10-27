package Advanced.SetsMapsAdvanced;

import java.util.Scanner;
import java.util.TreeSet;

public class E03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> periodicElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] currentElement = scanner.nextLine().split("\\s+");

            for (String element : currentElement) {
                periodicElements.add(element);
            }
        }

        for (String element : periodicElements) {
            System.out.print(element + " ");
        }

    }
}
