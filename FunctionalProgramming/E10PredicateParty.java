package Advanced.FunctionalProgramming;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class E10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        BiFunction<List<String>, String, List<String>> personStartsWith = ((list, letter) -> {
            List<String> foundPeople = new ArrayList<>();
            for (String person : list) {
                if (person.startsWith(letter)) {
                    foundPeople.add(person);
                }
            }
            return foundPeople;
        });

        BiFunction<List<String>, String, List<String>> personEndsWith = ((list, letter) -> {
            List<String> foundPeople = new ArrayList<>();
            for (String person : list) {
                if (person.endsWith(letter)) {
                    foundPeople.add(person);
                }
            }
            return foundPeople;
        });

        BiFunction<List<String>, Integer, List<String>> personWithLength = ((list, size) -> {
            List<String> foundPeople = new ArrayList<>();
            for (String person : list) {
                if (person.length() == size) {
                    foundPeople.add(person);
                }
            }
            return foundPeople;
        });

        while (!input.equals("Party!")) {
            String[] nextInput = input.split("\\s+");

            String command = nextInput[0];
            String criteria = nextInput[1];
            String option = nextInput[2];

            List<String> foundPerson = new ArrayList<>();
            switch (command) {
                case "Remove":
                    if (criteria.equals("StartsWith")) {
                        foundPerson = personStartsWith.apply(guests, option);
                    } else if (criteria.equals("EndsWith")) {
                        foundPerson = personEndsWith.apply(guests, option);
                    } else if (criteria.equals("Length")) {
                        foundPerson = personWithLength.apply(guests, Integer.parseInt(option));
                    }
                    guests.removeAll(foundPerson);
                    break;
                case "Double":
                    if (criteria.equals("StartsWith")) {
                        foundPerson = personStartsWith.apply(guests, option);
                    } else if (criteria.equals("EndsWith")) {
                        foundPerson = personEndsWith.apply(guests, option);
                    } else if (criteria.equals("Length")) {
                        foundPerson = personWithLength.apply(guests, Integer.parseInt(option));
                    }
                    guests.addAll(foundPerson);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }

        Collections.sort(guests);
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }
}
