package Advanced.ExamPreparation;

import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println();
        int checkSum = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> task = new ArrayDeque<>(); // stack -> stack.push(element); /  element = stack.pop();
        ArrayDeque<Integer> thread = new ArrayDeque<>(); //queue -> queue.offer(element); / element = queue.poll();

        for (int first: firstInput) {
            task.push(first);
        }
        for (int second: secondInput) {
            thread.offer(second);
        }

        while (task.size() > 0 && thread.size() > 0) {
            if (task.peek() == checkSum) {
                System.out.printf("Thread with value %d killed task %d%n", thread.peek(), task.peek());
                break;
            }
            if (thread.peek() >= task.peek()) {
                task.pop();
                thread.poll();
            } else {
                thread.poll();
            }

        }
        while (!thread.isEmpty()) {
            System.out.print(thread.pop());
            if (thread.size() > 0) {
                System.out.print(" ");
            }
        }




    }
}
