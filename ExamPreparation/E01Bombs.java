package Advanced.ExamPreparation;

import java.util.*;

public class E01Bombs {
    public static boolean isCollected = false;
    public static String countBombEffects = null;
    public static String countBombCasings = null;
    public static Map<String, Integer> bombs = new LinkedHashMap<>();
    public static ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
    public static ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();
    public static int[] firstInput;
    public static int[] secondInput;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        bombs.put("Cherry Bombs", 0);
        bombs.put("Datura Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        firstInput = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        secondInput = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int effect : firstInput) {
            bombEffectsQueue.offer(effect);
        }

        for (int casing : secondInput) {
            bombCasingsStack.push(casing);
        }

        while (bombEffectsQueue.size() > 0 && bombCasingsStack.size() > 0) {
            int sum = bombEffectsQueue.peek() + bombCasingsStack.peek();

            if (sum < 40) {
                bombEffectsQueue.poll();
                bombCasingsStack.pop();
            } else {
                while (sum != 40 && sum != 60 && sum != 120) {
                    int casing = bombCasingsStack.peek() - 5;
                    bombCasingsStack.poll();
                    bombCasingsStack.push(casing);
                    sum = bombCasingsStack.peek() + bombEffectsQueue.peek();
                }
                switch (sum) {
                    case 40:
                        bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                        bombEffectsQueue.poll();
                        bombCasingsStack.pop();
                        break;
                    case 60:
                        bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                        bombEffectsQueue.poll();
                        bombCasingsStack.pop();
                        break;
                    case 120:
                        bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                        bombEffectsQueue.poll();
                        bombCasingsStack.pop();
                        break;
                    default:
                        if (sum < 0) {
                            bombEffectsQueue.poll();
                            bombCasingsStack.pop();
                        }
                        break;
                }
            }
            if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
                isCollected = true;
            }
            if (isCollected) {
                break;
            }
        }

        if (isCollected) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.println("Bomb Effects: " + printEffectsCasings(bombEffectsQueue, countBombEffects));
        System.out.println("Bomb Casings: " + printEffectsCasings(bombCasingsStack, countBombCasings));

        bombs
                .entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));


    }

    private static String printEffectsCasings(ArrayDeque<Integer> stack, String count) {
        if (stack.size() == 0) {
            count = "empty";
        } else {
            count = stack.toString()
                    .replaceAll("\\[", "")
                    .replaceAll("]", "");
        }
        return count;
    }
}
