package Advanced.Classes.E01OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
           String[] input = scanner.nextLine().split("\\s+");

           String name = input[0];
           int age = Integer.parseInt(input[1]);

           Person person = new Person(name, age);

           persons.add(person);
        }

        persons
                .stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
