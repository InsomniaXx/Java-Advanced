package Advanced.ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01LootBox {
    public static int[] firstInput;
    public static int[] secondInput;
    public static ArrayDeque<Integer> firstLootQueue = new ArrayDeque<>();
    public static ArrayDeque<Integer> secondLootStack = new ArrayDeque<>();
    public static int sumClaimedItems = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //first -> queue -> offer / poll
        //second -> stack -> push / pop

        firstInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        secondInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int first: firstInput) {
            firstLootQueue.offer(first);
        }
        for (int second : secondInput) {
            secondLootStack.push(second);
        }

        while (firstLootQueue.size() > 0 && secondLootStack.size() > 0) {
            int sum = firstLootQueue.peek() + secondLootStack.peek();

            if (sum % 2 == 0) {
                sumClaimedItems += sum;
                firstLootQueue.poll();
                secondLootStack.pop();
            } else {
                int removed = secondLootStack.peek();
                firstLootQueue.addLast(removed);
                secondLootStack.pop();
            }
        }

        if (firstLootQueue.size() == 0) {
            System.out.println("First lootbox is empty");
        }
        if (secondLootStack.size() == 0) {
            System.out.println("Second lootbox is empty");
        }
        if (sumClaimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumClaimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumClaimedItems);
        }
    }
}
