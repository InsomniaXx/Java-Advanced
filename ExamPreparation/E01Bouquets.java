package Advanced.ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //tulips  => stack -> stack.push(element); -> element = stack.pop();
        //daffodils => queue -> queue.offer(element); -> element = queue.poll();

        int countBouquets = 0;
        int flowersStored = 0;

        int[] tulipsArr = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] daffodilsArr = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> tulips = new ArrayDeque<>(); //stack
        ArrayDeque<Integer> daffodils = new ArrayDeque<>(); //queue

        for (int tulip : tulipsArr) {
            tulips.push(tulip);
        }
        for (int daffodil : daffodilsArr) {
            daffodils.offer(daffodil);
        }

        while (tulips.size() > 0 && daffodils.size() > 0) {
            int currentSum = tulips.peek() + daffodils.peek();

            if (currentSum == 15) {
                countBouquets++;
                tulips.pop();
                daffodils.poll();
            } else if (currentSum > 15) {
                while (currentSum > 15) {
                    currentSum -= 2;
                }
                if (currentSum == 15) {
                    countBouquets++;
                    tulips.pop();
                    daffodils.poll();
                }
            }
            if (currentSum < 15) {
                flowersStored += currentSum;
                tulips.pop();
                daffodils.poll();
            }
        }

        countBouquets += flowersStored / 15;

        if (countBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", countBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - countBouquets);
        }


    }
}
