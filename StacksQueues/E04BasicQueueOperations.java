package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        int removeCount = scanner.nextInt();
        int numberToCheck = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numberOfElements; i++) {
            queue.offer(scanner.nextInt());
        }
        for (int i = 0; i < removeCount; i++) {
            queue.poll();
        }
        if (queue.contains(numberToCheck)) {
            System.out.println("true");
        } else {
            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue));
            } else {
                System.out.println(0);
            }
        }
    }
}
