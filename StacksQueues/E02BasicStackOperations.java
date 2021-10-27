package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = scanner.nextInt();
        int countPops = scanner.nextInt();
        int presentElement = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfElements; i++) {
            stack.push(scanner.nextInt());
        }
        for (int i = 0; i < countPops; i++) {
            stack.pop();
        }
        if (stack.contains(presentElement)) {
            System.out.println("true");
        } else {
            int minNumber = 0;
            if (!stack.isEmpty()) {
                minNumber = Collections.min(stack);
            }
            System.out.println(minNumber);
        }
    }
}
