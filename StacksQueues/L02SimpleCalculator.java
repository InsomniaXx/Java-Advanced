package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expressionElements = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = expressionElements.length - 1; i >= 0; i--) {
            stack.push(expressionElements[i]);
        }
        while (stack.size() > 1) {
            int rightOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int leftOperand = Integer.parseInt(stack.pop());

            int result = operator.equals("+")
                    ? rightOperand + leftOperand
                    : rightOperand - leftOperand;

            stack.push(String.valueOf(result));
        }
        System.out.println(stack.pop());
    }
}
