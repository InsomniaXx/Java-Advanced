package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] players = scanner.nextLine().split("\\s+");
        int toss = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String player : players) {
            queue.offer(player);
        }
        int cycle = 1;
        boolean isPrime = false;

        while (queue.size() > 1) {
            for (int i = 1; i < toss; i++) {
                queue.offer(queue.poll());
            }
            if (CheckPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    public static boolean CheckPrime(int numberToCheck) {
        boolean isPrime = true;
        if (numberToCheck <= 1)
            isPrime = false;
        for (int i = 2; i < numberToCheck; i++) {
            if (numberToCheck % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}
