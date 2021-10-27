package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] players = scanner.nextLine().split("\\s+");
        int toss = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String player : players) {
            queue.offer(player);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < toss; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());

        }

        System.out.println("Last is " + queue.poll());
    }
}
