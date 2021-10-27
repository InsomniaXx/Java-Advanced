package Advanced.ExamPreparation;

import java.awt.font.ShapeGraphicAttribute;
import java.util.*;

public class E01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();
        int[] first = Arrays
                .stream(firstInput.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] second = Arrays
                .stream(secondInput.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<String, Integer> cook = new LinkedHashMap<>();
        cook.put("Biscuit", 0);
        cook.put("Cake", 0);
        cook.put("Pie", 0);
        cook.put("Pastry", 0);

        ArrayDeque<Integer> liquids = new ArrayDeque(); //queue
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(); //stack

        for (int i = 0; i < first.length; i++) {
            liquids.add(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            ingredients.push(second[i]);
        }

        while (liquids.size() > 0 && ingredients.size() > 0) {
            int currentSum = liquids.peek() + ingredients.peek();

            switch (currentSum) {
                case 25:
                    cook.put("Biscuit", cook.get("Biscuit") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 50:
                    cook.put("Cake", cook.get("Cake") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 75:
                    cook.put("Pastry", cook.get("Pastry") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 100:
                    cook.put("Pie", cook.get("Pie") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                default:
                    liquids.pop();
                    int valueIngredient = ingredients.peek() + 3;
                    ingredients.pop();
                    ingredients.push(valueIngredient);
                    break;

            }
        }
        boolean allCook = true;
        for (int c : cook.values()) {
            if (c == 0) {
                allCook = false;
            }
        }

        if (allCook) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (liquids.size() > 0) {
            String out = null;
            out = liquids.toString();
            out = out.replace("[", "");
            out = out.replace("]", "");
            System.out.println(out);
        } else {
            System.out.print("none" + "\n");
        }
        System.out.print("Ingredients left: ");
        if (ingredients.size() > 0) {
            String out = null;
            out = ingredients.toString();
            out = out.replace("[", "");
            out = out.replace("]", "");
            System.out.println(out);
        } else {
            System.out.print("none" + "\n");
        }

        for (var c : cook.entrySet()) {
            System.out.printf("%s: %d%n", c.getKey(), c.getValue());
        }

    }

}
