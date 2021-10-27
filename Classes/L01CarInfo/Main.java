package Advanced.Classes.L01CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String make = carInfo[0];
            String model = carInfo[1];
            int hp = Integer.parseInt(carInfo[2]);

            CarInfo car = new CarInfo(make, model, hp);
            System.out.println(car.toString());
        }
    }
}
