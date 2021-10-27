package Advanced.StacksQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();

        String command = scanner.nextLine();
        String currentURL = "";

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
                String prevURL = history.pop();
                currentURL = prevURL;
            } else {
                if (!currentURL.equals("")) {
                    history.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = scanner.nextLine();
        }
    }
}
