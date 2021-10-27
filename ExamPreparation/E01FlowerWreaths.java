package Advanced.ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //first lilies -> stack stack.push(element); -> element = stack.pop();
        //second roses -> queue -> queue.offer(element); -> element = queue.poll();

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        int flowersLeft = 0;
        int countWreaths = 0;

        int[] firstInput = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondInput = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int f : firstInput) {
            lilies.push(f);
        }
        for (int s :secondInput) {
            roses.offer(s);
        }

        while (lilies.size() > 0 && roses.size() > 0) {
            int sum = lilies.peek() + roses.peek();

            if (sum == 15) {
                countWreaths++;
                lilies.pop();
                roses.poll();
            } else if (sum > 15) {
                while (sum > 15) {
                    int liliesCount = lilies.peek() - 2;
                    lilies.pop();
                    lilies.push(liliesCount);

                    sum = lilies.peek() + roses.peek();
                }
                if (sum == 15) {
                    countWreaths++;
                    lilies.pop();
                    roses.poll();
                }
            } else if (sum < 15) {
                flowersLeft += sum;
                lilies.pop();
                roses.poll();
            }
        }

        if (flowersLeft > 15) {
            countWreaths += flowersLeft / 15;
        }

        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreaths);
        }

    }
}
