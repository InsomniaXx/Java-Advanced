package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] splitInput = input.split("\\s+");

        for (String element : splitInput) {
            stack.push(Integer.parseInt(element));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        //System.out.println(String.join(" ", stack));
    }
}
