package Advanced.SetsMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> personEmail = new LinkedHashMap<>();

        String regex = "(?<username>[A-Za-z]+)@([A-Za-z]+)\\.(?<domain>[A-Za-z]+)";
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            Matcher matcher = pattern.matcher(email);

            while (matcher.find()) {
                if (!matcher.group("domain").equals("us")
                        && !matcher.group("domain").equals("uk")
                        && !matcher.group("domain").equals("com")) {

                    personEmail.put(name, email);
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> personOutput : personEmail.entrySet()) {
            System.out.println(personOutput.getKey() + " -> " + personOutput.getValue());
        }
    }
}
