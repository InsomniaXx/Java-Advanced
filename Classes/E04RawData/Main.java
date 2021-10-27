package Advanced.Classes.E04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carDetails = scanner.nextLine().split("\\s+");

            String model = carDetails[0];
            int engineSpeed = Integer.parseInt(carDetails[1]);
            int enginePower = Integer.parseInt(carDetails[2]);
            int cargoWeight = Integer.parseInt(carDetails[3]);
            String cargoType = carDetails[4];
            double tirePressure_1 = Double.parseDouble(carDetails[5]);
            int tireAge_1 = Integer.parseInt(carDetails[6]);
            double tirePressure_2 = Double.parseDouble(carDetails[7]);
            int tireAge_2 = Integer.parseInt(carDetails[8]);
            double tirePressure_3 = Double.parseDouble(carDetails[9]);
            int tireAge_3 = Integer.parseInt(carDetails[10]);
            double tirePressure_4 = Double.parseDouble(carDetails[11]);
            int tireAge_4 = Integer.parseInt(carDetails[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight,
                    cargoType, tirePressure_1, tireAge_1,
                    tirePressure_2, tireAge_2,
                    tirePressure_3, tireAge_3,
                    tirePressure_4, tireAge_4);
            cars.add(car);
        }
        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            cars
                    .stream()
                    .filter(e -> e.getCargo().getCargoType().equals(command))
                    .filter(Car::underTirePressure)
                    .forEach(System.out::println);
        } else if (command.equals("flamable")) {
            cars
                    .stream()
                    .filter(e -> e.getCargo().getCargoType().equals(command))
                    .filter(Car::highEnginePower)
                    .forEach(System.out::println);
        }
    }
}
