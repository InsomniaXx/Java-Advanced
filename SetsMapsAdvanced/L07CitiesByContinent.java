package Advanced.SetsMapsAdvanced;

import java.util.*;

public class L07CitiesByContinent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continentsAndCountries = new LinkedHashMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continentsAndCountries.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countriesAndCities = continentsAndCountries.get(continent);
            countriesAndCities.putIfAbsent(country, new ArrayList<>());

            List<String> cities = countriesAndCities.get(country);
            cities.add(city);
        }

        continentsAndCountries.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    e.getValue().entrySet()
                            .stream()
                            .forEach(ie -> {
                                System.out.println("  " + ie.getKey() + " -> " + String.join(", ", ie.getValue()));
                            });
                });
    }
}
