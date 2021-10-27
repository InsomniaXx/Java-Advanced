package Advanced.SetsMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Map<String, Double>> productShop = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] nextProduct = input.split(", ");
            String shop = nextProduct[0];
            String product = nextProduct[1];
            double price = Double.parseDouble(nextProduct[2]);

//            if (!productShop.containsKey(shop)) {
//                productShop.put(shop, new LinkedHashMap<>());
//          }
            productShop.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> products = productShop.get(shop);
            products.put(product, price);

            input = scanner.nextLine();
        }
        for (String shop : productShop.keySet()) {
            System.out.println(shop + "->");

            for (var entry : productShop.get(shop).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
