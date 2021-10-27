package Advanced.Classes.E03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < countCars; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            Car car;
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelCost = Double.parseDouble(carData[2]);
            car = new Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }

        String nextInput = scanner.nextLine();

        while (!nextInput.equals("End")) {
            String[] driveCommand = nextInput.split("\\s+");
            String carModel = driveCommand[1];
            double kmToDrive = Double.parseDouble(driveCommand[2]);

            Car car = cars.get(carModel);
            if (!car.drive(kmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }
            nextInput = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
