package Advanced.ExamPreparation;

import java.rmi.MarshalledObject;
import java.util.*;

public class E01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //first -> liquids -> queue -> queue.offer(element); element = queue.poll();
        //second -> ingredients -> stack -> stack.push(element); -> element = stack.pop();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Map<String, Integer> foods = new TreeMap<>();

        foods.put("Bread", 0);
        foods.put("Cake", 0);
        foods.put("Pastry", 0);
        foods.put("Fruit Pie", 0);

        boolean cookedAllFood = true;
        int[] first = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int second[] = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int f : first) {
            liquidsQueue.offer(f);
        }
        for (int s : second) {
            ingredientsStack.push(s);
        }

        while (liquidsQueue.size() > 0 && ingredientsStack.size() > 0) {
            int currentSum = liquidsQueue.peek() + ingredientsStack.peek();

            switch (currentSum) {
                case 25:
                    foods.put("Bread", foods.get("Bread") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 50:
                    foods.put("Cake", foods.get("Cake") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 75:
                    foods.put("Pastry", foods.get("Pastry") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 100:
                    foods.put("Fruit Pie", foods.get("Fruit Pie") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                default:
                    liquidsQueue.poll();
                    int updateIngredients = ingredientsStack.peek() + 3;
                    ingredientsStack.pop();
                    ingredientsStack.push(updateIngredients);
                    break;
            }
        }

        for (var e : foods.values()) {
            if (e == 0) {
                cookedAllFood = false;
            }
        }

        if (cookedAllFood) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        String outLiquids = "";
        String outIngridients = "";

        if (liquidsQueue.size() == 0) {
            outLiquids = "none";
        } else {
            outLiquids = liquidsQueue.toString().replaceAll("\\[", "").replaceAll("]", "");
        }

        if (ingredientsStack.size() == 0) {
            outIngridients = "none";
        } else {
            outIngridients = ingredientsStack.toString().replaceAll("\\[", "").replaceAll("]", "");
        }
        System.out.println("Liquids left: " + outLiquids);
        System.out.println("Ingredients left: " + outIngridients);

        foods
                .entrySet()
                .forEach(f -> System.out.println(f.getKey() + ": " + f.getValue()));
    }
}
