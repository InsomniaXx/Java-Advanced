package Advanced.SetsMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] record = input.split("-");
            String name = record[0];
            String number = record[1];

            phonebook.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")) {
            String searchName = input;

            if (phonebook.containsKey(searchName)) {
                System.out.printf("%s -> %s%n", searchName, phonebook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }
            input = scanner.nextLine();
        }
    }
}
