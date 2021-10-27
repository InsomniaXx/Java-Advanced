package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E08SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Character> text = new ArrayDeque<>();
        ArrayDeque<String> memory = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);

            switch (command) {
                case 1:
                    String textToInsert = input[1];
                    for (int j = 0; j < textToInsert.length(); j++) {
                        text.offer(textToInsert.charAt(j));
                    }
                    memory.push(text.toString());
                    break;
                case 2:
                    int countErase = Integer.parseInt(input[1]);
                    for (int j = 0; j < countErase; j++) {
                        text.removeLast();
                    }
                    memory.push(text.toString());
                    break;
                case 3:
                    int index = Integer.parseInt(input[1]);
                    String textToFind = text.toString();
                    if (index > 0 && index < textToFind.length()) {
                        char foundChar = getChar(textToFind, index);
                        System.out.println(foundChar);
                    }
                    break;
                case 4:
                    if (!memory.isEmpty()) {
                        memory.pop();
                        String previous = memory.peek();
                        previous = previous.replace("[", "");
                        previous = previous.replace("]", "");
                        previous = previous.replace(", ", "");
                        text.clear();
                        for (int j = 0; j < previous.length(); j++) {
                            text.offer(previous.charAt(j));
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static char getChar(String textToFind, int index) {
        textToFind = textToFind.replace(", ", "");
        char currentChar = textToFind.charAt(index);
        return currentChar;
    }
}
