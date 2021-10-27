package Advanced.Classes.L02CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            Car car;

            if (carInfo.length == 1) {
                car = new Car(carInfo[0]);
            } else {
                car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
            }
            System.out.println(car.toString());
        }
    }
}
