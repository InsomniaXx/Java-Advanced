package Advanced.Generics.L01.E06;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box();
        for (int i = 0; i < n; i++) {
            double value = Double.parseDouble(scanner.nextLine());
            box.add(value);
        }

        double elementToCompare = Double.parseDouble(scanner.nextLine());
        int greaterElementsCount = box.countOfGreaterItems(elementToCompare);

        System.out.println(greaterElementsCount);

    }
}