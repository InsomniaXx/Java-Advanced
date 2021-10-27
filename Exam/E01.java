package Advanced.Exam;

import java.util.*;

public class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//queue -> offer(element); -> queue.poll();
        //stack -> push(element); -> stack.pop();
        int[] firstInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();

        for (int i : firstInput) {
            ingredientsQueue.offer(i);
        }
        for (int s : secondInput) {
            freshnessLevelStack.push(s);
        }
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        while (ingredientsQueue.size() > 0 && freshnessLevelStack.size() > 0) {
            int multiplication = ingredientsQueue.peek() * freshnessLevelStack.peek();

            if (multiplication == 150) {
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
            } else if (multiplication == 250) {
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
            } else if (multiplication == 300) {
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
            } else if (multiplication == 400) {
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                ingredientsQueue.poll();
                freshnessLevelStack.pop();

            } else if (ingredientsQueue.peek() == 0) {
                ingredientsQueue.poll();
                continue;
            } else {
                freshnessLevelStack.pop();

                int newIngredientValue = ingredientsQueue.peek() + 5;
                ingredientsQueue.pop();
                ingredientsQueue.offer(newIngredientValue);
            }
        }

        boolean hasAllCocktails = true;

        for (int value : cocktails.values()) {
            if (value == 0) {
                hasAllCocktails = false;
                break;
            }
        }
        if (hasAllCocktails) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int ingridientSum = 0;
        if (ingredientsQueue.size() > 0) {
            while (ingredientsQueue.size() > 0) {
                ingridientSum += ingredientsQueue.peek();
                ingredientsQueue.poll();
            }
        }
        if (ingridientSum > 0) {
            System.out.println("Ingredients left: " + ingridientSum);
        }
        cocktails
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue()));
    }
}
