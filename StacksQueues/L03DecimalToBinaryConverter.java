package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class L03DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (inputNumber != 0) {
            stack.push(inputNumber % 2);
            inputNumber /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.poll());
        }
    }
}
