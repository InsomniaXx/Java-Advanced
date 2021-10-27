package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);

            if (ch == '(') {
                stack.push(index);
            } else if (ch == ')') {
                int startIndex = stack.pop();
                String contents = input.substring(startIndex, index + 1);
                System.out.println(contents);
            }
        }
    }
}
