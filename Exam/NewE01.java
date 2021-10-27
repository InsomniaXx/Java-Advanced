package Advanced.Exam;

import java.util.*;

public class NewE01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessQueue = new ArrayDeque<>();

        for (int first : firstInput) {
            ingredientsStack.push(first);
        }
        for (int second : secondInput) {
            freshnessQueue.offer(second);
        }

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        while (ingredientsStack.size() > 0 && freshnessQueue.size() > 0) {

            if (ingredientsStack.peek() == 0) {
                ingredientsStack.pop();
                if (ingredientsStack.size() == 0) {
                    break;
                }
            }

            int multiplication = ingredientsStack.peek() * freshnessQueue.peek();

            if (multiplication == 150) {
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                ingredientsStack.pop();
                freshnessQueue.poll();
            } else if (multiplication == 250) {
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                ingredientsStack.pop();
                freshnessQueue.poll();
            } else if (multiplication == 300) {
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                ingredientsStack.pop();
                freshnessQueue.poll();
            } else if (multiplication == 400) {
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                ingredientsStack.pop();
                freshnessQueue.poll();

            } else {
                freshnessQueue.poll();
                int newIngredientValue = ingredientsStack.peek() + 5;
                ingredientsStack.pop();
                ingredientsStack.push(newIngredientValue);
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
        int ingredientSum = 0;

        if (ingredientsStack.size() > 0) {
            for (int i = 0; i < ingredientsStack.size(); i++) {
                ingredientSum += ingredientsStack.peek();
                ingredientsStack.pop();
            }
        }
        if (ingredientSum > 0) {
            System.out.println("Ingredients left: " + ingredientSum);
        }
        cocktails
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue()));

    }
}
