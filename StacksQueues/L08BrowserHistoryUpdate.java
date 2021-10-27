package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L08BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (queue.isEmpty()) {
                if (input.equals("back")) {
                    System.out.println("no previous URLs");
                } else if (input.equals("forward")) {
                    System.out.println("no next URLs");
                }
            }

            if (!input.equals("back") && !input.equals("forward")) {
                queue.addFirst(input);
                System.out.println(queue.peek());
            } else {
                if (input.equals("back")) {
                    queue.pop();
                    System.out.println(queue.peek());
                } else if (input.equals("forward")) {
                    System.out.println(queue.peek());
                }
            }
            input = scanner.nextLine();
        }
    }
}
