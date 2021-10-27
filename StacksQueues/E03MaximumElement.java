package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    stack.push(scanner.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
                default:
                    break;
            }
        }
    }
}
