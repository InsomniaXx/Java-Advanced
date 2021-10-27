package Advanced.ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01MagicBox {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] firstMagicBox = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondMagicBox = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstBox = new ArrayDeque<>(); // stack
        ArrayDeque<Integer> secondBox = new ArrayDeque<>(); //queue

        for (int first: firstMagicBox) {
            firstBox.add(first);
        }

        for (int second : secondMagicBox) {
            secondBox.push(second);
        }
        System.out.println();

        int sumClaimedItems = 0;

        while (firstBox.size() != 0 && secondBox.size() != 0) {
            int sum = 0;

            sum += firstBox.peek() + secondBox.peek();

            if (sum % 2 == 0) {
                sumClaimedItems += sum;
                firstBox.pop();
                secondBox.poll();
            } else {
                firstBox.addLast(secondBox.peek());
                secondBox.poll();
            }

            if (firstBox.size() == 0) {
                System.out.println("First magic box is empty.");
            } else if (secondBox.size() == 0) {
                System.out.println("Second magic box is empty.");
            }
        }
        if (sumClaimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sumClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumClaimedItems);
        }
    }
}
